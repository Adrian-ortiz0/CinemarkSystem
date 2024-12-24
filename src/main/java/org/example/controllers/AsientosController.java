package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Asiento;
import org.example.models.Sala;
import org.example.models.TipoAsiento;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class AsientosController {
    
    public static ArrayList<Asiento> obtenerAsientosPorFuncion(int idFuncion) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlAsientos = "SELECT a.ID, a.Numero, a.Fila, fa.Estado, ta.ID AS TipoAsientoID, ta.Nombre, ta.Precio FROM asientos a " +
                             "JOIN funcionAsientos fa ON a.ID = fa.ID_Asiento " +
                             "JOIN tipoAsientos ta ON a.ID_TipoAsiento = ta.ID " +
                             "WHERE fa.ID_Funcion = ?";
        Object[] params = {idFuncion};
        ResultSet rs = CRUD.consultarDB(sqlAsientos, params);

        ArrayList<Asiento> asientos = new ArrayList<>();
        try {
            while (rs.next()) {
                int idAsiento = rs.getInt("ID");
                int numeroAsiento = rs.getInt("Numero");
                String filaAsiento = rs.getString("Fila");
                boolean estadoAsiento = rs.getBoolean("Estado");

                Asiento asiento = new Asiento();
                asiento.setId(idAsiento);
                asiento.setFila(filaAsiento != null ? filaAsiento : "N/A"); // Asegurarse que fila no es null
                asiento.setNumero(numeroAsiento);
                asiento.setOcupado(estadoAsiento);

                int tipoAsientoID = rs.getInt("TipoAsientoID");
                String nombreTipoAsiento = rs.getString("Nombre");
                double precioTipoAsiento = rs.getDouble("Precio");

                TipoAsiento tipoAsiento = new TipoAsiento();
                tipoAsiento.setId(tipoAsientoID);
                tipoAsiento.setNombre(nombreTipoAsiento);
                tipoAsiento.setPrecio(precioTipoAsiento);

                asiento.setTipo(tipoAsiento);
                asientos.add(asiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asientos;
    }


    
    public static boolean asignarAsientosFuncion(int idFuncion, ArrayList<Asiento> asientos) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlInsert = "INSERT INTO funcion_asientos (ID_Funcion, ID_Asiento) VALUES (?, ?)";

        for (Asiento asiento : asientos) {
            Object[] params = {idFuncion, asiento.getId()};
            boolean insertado = CRUD.insertarDB(sqlInsert, params);
            if (!insertado) {
                return false;
            }
        }
        return true;
    }

    
    public static boolean actualizarAsiento(int idAsiento){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "UPDATE asientos SET Ocupado = true WHERE ID = ?";
        return CRUD.updateDB(sql, idAsiento);
    }
    
    public static TipoAsiento traerTipoAsientoPorId(int idTipoAsiento){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM tipoAsientos WHERE ID = ?";
        TipoAsiento tipoAsiento = new TipoAsiento();
        ResultSet rs = CRUD.consultarDB(sql, idTipoAsiento);
        try {
            while(rs != null && rs.next()){
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                tipoAsiento.setId(idTipoAsiento);
                tipoAsiento.setNombre(nombre);
                tipoAsiento.setPrecio(precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsientosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoAsiento;
    }
    
    public static ArrayList<Asiento> traerAsientosPorSala(int idSala) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT " +
                     "a.ID AS ID_Asiento, " +
                     "a.ID_Sala, " +
                     "a.ID_TipoAsiento, " +
                     "a.Fila, " +
                     "a.Numero, " +
                     "a.Ocupado, " +
                     "ta.ID AS ID_TipoAsiento, " +
                     "ta.Nombre AS NombreTipoAsiento, " +
                     "ta.Precio " +
                     "FROM asientos a " +
                     "INNER JOIN tipoAsientos ta " +
                     "ON a.ID_TipoAsiento = ta.ID " +
                     "WHERE a.ID_Sala = ?;";

        ArrayList<Asiento> asientos = new ArrayList<>();
        ResultSet rs = CRUD.consultarDB(sql, idSala);
        Sala sala = SalasController.obtenerSalaPorId(idSala); 

        try {
            while (rs != null && rs.next()) {
                Asiento asiento = new Asiento();

                int idAsiento = rs.getInt("ID_Asiento");
                String fila = rs.getString("Fila");
                int numero = rs.getInt("Numero");
                boolean ocupado = rs.getBoolean("Ocupado");

                int idTipoAsiento = rs.getInt("ID_TipoAsiento");
                String nombreTipoAsiento = rs.getString("NombreTipoAsiento");
                double precioTipoAsiento = rs.getDouble("Precio");

                asiento.setId(idAsiento);
                asiento.setSala(sala);
                asiento.setFila(fila != null ? fila : "N/A"); // Asegurarse que fila no es null
                asiento.setNumero(numero);
                asiento.setOcupado(ocupado);

                TipoAsiento tipoAsiento = new TipoAsiento();
                tipoAsiento.setId(idTipoAsiento);
                tipoAsiento.setNombre(nombreTipoAsiento);
                tipoAsiento.setPrecio(precioTipoAsiento);

                asiento.setTipo(tipoAsiento);

                asientos.add(asiento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsientosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return asientos; 
    }


}
