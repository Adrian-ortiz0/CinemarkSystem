package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.MateriaPrima;
import org.example.models.MedidasMateriaPrima;
import org.example.models.Proveedor;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class InventaryController {
    
    public static boolean reabastecerAutomaticamente() {
        ArrayList<MateriaPrima> productosAgotados = mostrarProductosCasiAgotados();
        if (productosAgotados.isEmpty()) {
            System.out.println("No hay productos agotados de momento");
            return false;
        }

        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = """
            SELECT 
                mp.ID AS ID_MateriaPrima,
                mp.Nombre AS Nombre_MateriaPrima,
                p.ID AS ID_Proveedor,
                p.NombreEmpresa AS Nombre_Proveedor,
                mp.PrecioPorUnidad AS Precio_Unitario
            FROM 
                materiaPrima mp
            LEFT JOIN 
                proveedoresMateriaPrima pm ON mp.ID = pm.ID_MateriaPrima
            LEFT JOIN 
                proveedores p ON pm.ID_Proveedor = p.ID
            WHERE 
                mp.ID = ?
            ORDER BY 
                p.ID;
        """;

        for (MateriaPrima mp : productosAgotados) {
            try (ResultSet rs = CRUD.consultarDB(sql, mp.getId())) {
                boolean proveedoresEncontrados = false;

                while (rs.next()) {
                    proveedoresEncontrados = true;

                    int idProveedor = rs.getInt("ID_Proveedor");
                    String nombreProveedor = rs.getString("Nombre_Proveedor");
                    double precioUnitario = rs.getDouble("Precio_Unitario");
                    int cantidadNecesaria = mp.getCantidadNecesaria();
                    double totalOrden = cantidadNecesaria * precioUnitario;

                    Proveedor proveedor = new Proveedor();
                    proveedor.setId(idProveedor);
                    proveedor.setNombreEmpresa(nombreProveedor);

                    String insertarOrdenSql = "INSERT INTO ordenesDeCompra (ID_Proveedor, FechaOrden, Total) VALUES (?, NOW(), ?);";
                    if (!CRUD.insertarDB(insertarOrdenSql, idProveedor, totalOrden)) {
                        System.err.println("Error al crear la orden de compra para el proveedor: " + proveedor.getNombreEmpresa());
                        continue;
                    }

                    try (ResultSet ordenRs = CRUD.consultarDB("SELECT LAST_INSERT_ID() AS ID_Orden;")) {
                        if (!ordenRs.next()) {
                            System.err.println("No se pudo obtener el ID de la última orden de compra.");
                            continue;
                        }
                        int idOrden = ordenRs.getInt("ID_Orden");

                        String insertDetalleSql = """
                            INSERT INTO detalleOrden (ID_Orden, ID_MateriaPrima, Cantidad, PrecioUnitario) 
                            VALUES (?, ?, ?, ?);
                        """;
                        CRUD.insertarDB(insertDetalleSql, idOrden, mp.getId(), cantidadNecesaria, precioUnitario);

                        String updateInventarioSql = "UPDATE inventario SET Cantidad = Cantidad + ? WHERE ID_MateriaPrima = ?;";
                        CRUD.updateDB(updateInventarioSql, cantidadNecesaria, mp.getId());

                        System.out.println("Reabastecido " + cantidadNecesaria + " unidades de " + mp.getNombre() +
                                " usando al proveedor " + proveedor.getNombreEmpresa() +
                                " (ID: " + idProveedor + ")");
                        
                        PDFGenerator.generateOrdenDeCompraPDF(proveedor.getNombreEmpresa(), mp.getNombre(), 
                                                            cantidadNecesaria, precioUnitario, totalOrden);
                    }
                }

                if (!proveedoresEncontrados) {
                    System.err.println("NO SE ENCONTRARON PROVEEDORES para el producto: " + mp.getNombre());
                }
            } catch (SQLException e) {
                System.err.println("Error al procesar el reabastecimiento para: " + mp.getNombre());
                e.printStackTrace();
            }
        }

        return true;
    }
    
    public static ArrayList<MateriaPrima> mostrarProductosCasiAgotados(){
    CRUD.setConexion(ConnectionDB.getConnection());
    ArrayList<MateriaPrima> inventarioCasiAgotado = new ArrayList();
    String sql = "SELECT " +
         "mp.ID AS ProductoID, " +  
         "mp.Nombre AS Producto, " + 
         "i.Cantidad, " +
         "i.CantidadMinima, " +
         "i.CantidadNecesaria, " +   
         "p.NombreEmpresa AS Proveedor, " +
         "pm.PrecioPorUnidad " +
         "FROM inventario i " +
         "INNER JOIN materiaPrima mp ON i.ID_MateriaPrima = mp.ID " +
         "INNER JOIN proveedoresMateriaPrima pm ON mp.ID = pm.ID_MateriaPrima " +
         "INNER JOIN proveedores p ON pm.ID_Proveedor = p.ID " +
         "WHERE i.Cantidad < i.CantidadMinima;";
        
    ResultSet rs = CRUD.consultarDB(sql);
    try {
        while(rs != null && rs.next()){
            MateriaPrima mp = new MateriaPrima();
            
            int productoId = rs.getInt("ProductoID");
            
            mp.setId(productoId);
            
            String nombre = rs.getString("Producto");
            int cantidad = rs.getInt("Cantidad");
            int cantidadMinima = rs.getInt("CantidadMinima");
            int cantidadNecesaria = rs.getInt("CantidadNecesaria");
            Proveedor proveedor = new Proveedor();
            String nombreEmpres = rs.getString("Proveedor");
            proveedor.setNombreEmpresa(nombreEmpres);
            double precioPorUnidad = rs.getDouble("PrecioPorUnidad");
            mp.setNombre(nombre);
            mp.setCantidad(cantidad);
            mp.setCantidadMinima(cantidadMinima);
            mp.setProveedor(proveedor);
            mp.setPrecioPorUnidad(precioPorUnidad);
            mp.setCantidadNecesaria(cantidadNecesaria);
            inventarioCasiAgotado.add(mp);
        }
    } catch (SQLException ex) {
        Logger.getLogger(InventaryController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return inventarioCasiAgotado;
}
    
    public static ArrayList<MateriaPrima> mostrarInventario(){
        CRUD.setConexion(ConnectionDB.getConnection());
        ArrayList<MateriaPrima> inventario = new ArrayList();
        String sql = "SELECT mp.Nombre AS Producto, i.Cantidad AS Cantidad, mm.Nombre AS Unidad FROM inventario i INNER JOIN materiaPrima mp ON i.ID_MateriaPrima = mp.ID INNER JOIN medidasMateriaPrima mm ON mp.ID_MedidasMateriaPrima = mm.ID";
        try {
            ResultSet rs = CRUD.consultarDB(sql);
            while(rs != null && rs.next()){
                MateriaPrima mp = new MateriaPrima();
                String nombre = rs.getString("Producto");
                int cantidad = rs.getInt("Cantidad");
                MedidasMateriaPrima medida = new MedidasMateriaPrima();
                String unidad = rs.getString("Unidad");
                medida.setNombre(unidad);
                mp.setNombre(nombre);
                mp.setCantidad(cantidad);
                mp.setMedida(medida);
                inventario.add(mp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventario;
    }
}
