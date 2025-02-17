package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Combo;
import org.example.models.MateriaPrima;
import org.example.models.Producto;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class CombosController {
    
    public static boolean crearNuevoCombo(Combo combo) {
    CRUD.setConexion(ConnectionDB.getConnection());
    try {
        String sqlCombo = "INSERT INTO combos (Nombre, Precio) VALUES (?, ?)";
        Object[] paramsCombo = {combo.getNombre(), combo.getPrecioTotal()};
        CRUD.insertarDB(sqlCombo, paramsCombo);

        ResultSet rs = CRUD.consultarDB("SELECT LAST_INSERT_ID()");
        int idCombo = 0;
        if (rs.next()) {
            idCombo = rs.getInt(1);
        }

        for (HashMap.Entry<Producto, Integer> entry : combo.getProductosMap().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            String sqlProductos = "INSERT INTO combos_productos (ID_Combo, ID_Producto, Cantidad) VALUES (?, ?, ?)";
            Object[] paramsProductos = {idCombo, producto.getId(), cantidad};
            CRUD.insertarDB(sqlProductos, paramsProductos);
        }

        return true;
    } catch (SQLException e) {
        throw new RuntimeException("Error al insertar el nuevo combo", e);
    }
}



    
    public static Producto obtenerProductoPorNombre(String nombre){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM productos WHERE Nombre = ?;";
        Producto producto = new Producto();
        Object [] params = {nombre};
        ResultSet rs = CRUD.consultarDB(sql, params);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                double precio = rs.getDouble("Precio");
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CombosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    public static ArrayList<Producto> obtenerAdicionales(){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM productos WHERE id IN (4, 11, 12, 13)";
        ArrayList<Producto> adicionales = new ArrayList();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                adicionales.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CombosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adicionales;
    }
    
    public static ArrayList<Producto> obtenerRefrescos(){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM productos WHERE id IN (5, 6, 7)";
        ArrayList<Producto> refrescos = new ArrayList();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                refrescos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CombosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return refrescos;
    }
    
    public static ArrayList<Producto> obtenerPalomitas(){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM productos WHERE id IN (1, 2, 3)";
        ArrayList<Producto> palomitas = new ArrayList();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                palomitas.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CombosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return palomitas;
    }
    
    public static ArrayList<MateriaPrima> obtenerMateriasPrimasProducto(int idProducto) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlMateriasPrimas = "SELECT ID_MateriaPrima, Cantidad FROM productos_materia_prima WHERE ID_Producto = ?";
        Object[] params = {idProducto};
        ResultSet rs = CRUD.consultarDB(sqlMateriasPrimas, params);

        ArrayList<MateriaPrima> materiasPrimas = new ArrayList<>();
        try {
            while (rs.next()) {
                int idMateriaPrima = rs.getInt("ID_MateriaPrima");
                int cantidad = rs.getInt("Cantidad");
                MateriaPrima mp = new MateriaPrima();
                mp.setCantidad(cantidad);
                mp.setId(idMateriaPrima);
                materiasPrimas.add(mp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materiasPrimas;
    }

    
    public static boolean actualizarInventario(int idMateriaPrima, int cantidadDeducir) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlUpdate = "UPDATE inventario SET Cantidad = Cantidad - ? WHERE ID_MateriaPrima = ? AND Cantidad >= ?";
        Object[] params = {cantidadDeducir, idMateriaPrima, cantidadDeducir};

        return CRUD.updateDB(sqlUpdate, params);
    }


    
    public static int insertarCompra(int idCliente, double total, String metodoPago) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlCompra = "INSERT INTO comprasCombosProductos (ID_Cliente, Total, MetodoPago) VALUES (?, ?, ?)";
        Object[] paramsCompra = {idCliente, total, metodoPago};

        boolean compraInsertada = CRUD.insertarDB(sqlCompra, paramsCompra);

        if (!compraInsertada) {
            return -1;
        }

        int idCompra = -1;
        ResultSet rs = CRUD.consultarDB("SELECT LAST_INSERT_ID() AS last_id");
        try {
            if (rs.next()) {
                idCompra = rs.getInt("last_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idCompra;
    }
    
    public static boolean insertarDetalleCompra(int idCompra, Integer idCombo, Integer idProducto, int cantidad, double precioUnitario) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlDetalle = "INSERT INTO detalleCompras (ID_Compra, ID_Combo, ID_Producto, Cantidad, PrecioUnitario) VALUES (?, ?, ?, ?, ?)";
        Object[] paramsDetalle = new Object[5];
        paramsDetalle[0] = idCompra;
        paramsDetalle[1] = idCombo != null ? idCombo : null;
        paramsDetalle[2] = idProducto != null ? idProducto : null;
        paramsDetalle[3] = cantidad;
        paramsDetalle[4] = precioUnitario;

        return CRUD.insertarDB(sqlDetalle, paramsDetalle);
    }



    
    public static ArrayList<Producto> obtenerProductos() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlProductos = "SELECT ID, Nombre, Precio FROM productos";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            ResultSet rsProductos = CRUD.consultarDB(sqlProductos);
            while (rsProductos != null && rsProductos.next()) {
                int idProducto = rsProductos.getInt("ID");
                String nombreProducto = rsProductos.getString("Nombre");
                double precioProducto = rsProductos.getDouble("Precio");

                Producto producto = new Producto(idProducto, nombreProducto, null, precioProducto);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
    
    public static Producto obtenerProductoPorId(int id) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlProducto = "SELECT ID, Nombre, Precio FROM productos WHERE ID = ?";
        Producto producto = null;

        try {
            Object[] paramsProducto = {id};
            ResultSet rsProducto = CRUD.consultarDB(sqlProducto, paramsProducto);
            if (rsProducto != null && rsProducto.next()) {
                int idProducto = rsProducto.getInt("ID");
                String nombreProducto = rsProducto.getString("Nombre");
                double precioProducto = rsProducto.getDouble("Precio");

                producto = new Producto(idProducto, nombreProducto, null, precioProducto);

                String sqlMateriasPrimas = "SELECT mp.ID, mp.Nombre, pmp.Cantidad " +
                                           "FROM materiaPrima mp " +
                                           "JOIN productos_materia_prima pmp ON mp.ID = pmp.ID_MateriaPrima " +
                                           "WHERE pmp.ID_Producto = ?";
                Object[] paramsMateriasPrimas = {idProducto};
                ResultSet rsMateriasPrimas = CRUD.consultarDB(sqlMateriasPrimas, paramsMateriasPrimas);
                ArrayList<MateriaPrima> listaMateriasPrimas = new ArrayList<>();

                while (rsMateriasPrimas != null && rsMateriasPrimas.next()) {
                    int idMateriaPrima = rsMateriasPrimas.getInt("ID");
                    String nombreMateriaPrima = rsMateriasPrimas.getString("Nombre");
                    int cantidadMateriaPrima = rsMateriasPrimas.getInt("Cantidad");

                    MateriaPrima materiaPrima = new MateriaPrima();
                    materiaPrima.setCantidad(idMateriaPrima);
                    materiaPrima.setNombre(nombreMateriaPrima);
                    materiaPrima.setCantidad(cantidadMateriaPrima);
                    listaMateriasPrimas.add(materiaPrima);
                }
                producto.setIngredientes(listaMateriasPrimas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    
    public static Combo obtenerCombosPorId(int id) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlCombos = "SELECT ID, Nombre, Precio FROM combos WHERE ID = ?";
        Combo combo = null;

        try {
            Object[] paramsCombos = {id};
            ResultSet rsCombos = CRUD.consultarDB(sqlCombos, paramsCombos);
            if (rsCombos != null && rsCombos.next()) {
                int idCombo = rsCombos.getInt("ID");
                String nombreCombo = rsCombos.getString("Nombre");
                double precioCombo = rsCombos.getDouble("Precio");

                combo = new Combo(idCombo, nombreCombo, new ArrayList<>());
                combo.setPrecioTotal(precioCombo);

                String sqlProductos = "SELECT p.ID, p.Nombre, p.Precio, cp.Cantidad " +
                                      "FROM productos p " +
                                      "JOIN combos_productos cp ON p.ID = cp.ID_Producto " +
                                      "WHERE cp.ID_Combo = ?";
                Object[] paramsProductos = {idCombo};
                ResultSet rsProductos = CRUD.consultarDB(sqlProductos, paramsProductos);
                while (rsProductos != null && rsProductos.next()) {
                    int idProducto = rsProductos.getInt("ID");
                    String nombreProducto = rsProductos.getString("Nombre");
                    double precioProducto = rsProductos.getDouble("Precio");
                    int cantidadProducto = rsProductos.getInt("Cantidad");

                    Producto producto = new Producto(idProducto, nombreProducto, null, precioProducto);
                    for (int i = 0; i < cantidadProducto; i++) {
                        combo.getProductos().add(producto);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combo;
    }


    
    public static ArrayList<Combo> obtenerCombos() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlCombos = "SELECT ID, Nombre, Precio FROM combos";
        ArrayList<Combo> combos = new ArrayList<>();

        try {
            ResultSet rsCombos = CRUD.consultarDB(sqlCombos);
            while (rsCombos != null && rsCombos.next()) {
                int idCombo = rsCombos.getInt("ID");
                String nombreCombo = rsCombos.getString("Nombre");
                double precioCombo = rsCombos.getDouble("Precio");

                Combo combo = new Combo(idCombo, nombreCombo, new ArrayList<>());
                combo.setPrecioTotal(precioCombo);
                String sqlProductos = "SELECT p.ID, p.Nombre, p.Precio, cp.Cantidad " +
                                      "FROM productos p " +
                                      "JOIN combos_productos cp ON p.ID = cp.ID_Producto " +
                                      "WHERE cp.ID_Combo = ?";
                Object[] paramsProductos = {idCombo};
                ResultSet rsProductos = CRUD.consultarDB(sqlProductos, paramsProductos);
                while (rsProductos != null && rsProductos.next()) {
                    int idProducto = rsProductos.getInt("ID");
                    String nombreProducto = rsProductos.getString("Nombre");
                    double precioProducto = rsProductos.getDouble("Precio");
                    int cantidadProducto = rsProductos.getInt("Cantidad");

                    Producto producto = new Producto(idProducto, nombreProducto, null, precioProducto);
                    for (int i = 0; i < cantidadProducto; i++) {
                        combo.getProductos().add(producto);
                    }
                }

                combos.add(combo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combos;
    }

}
