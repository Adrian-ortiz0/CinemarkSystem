package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Asiento;
import org.example.models.Funcion;
import org.example.models.Pelicula;
import org.example.models.Sala;
import org.example.models.TipoAsiento;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class FunctionsController {
    
    public static boolean actualizarEstadoAsiento(int idFuncion, int idAsiento, boolean estado) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlUpdate = "UPDATE funcionAsientos SET Estado = ? WHERE ID_Funcion = ? AND ID_Asiento = ?";
        Object[] params = {estado, idFuncion, idAsiento};
        return CRUD.updateDB(sqlUpdate, params);
    }

    
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


    
    public static boolean actualizarFuncionFecha(int id, LocalDateTime nuevaFecha){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "UPDATE funciones SET FechaInicio = ?, FechaFin = ? WHERE ID = ?";
        Object[] params = {
            nuevaFecha,
            nuevaFecha.plusMinutes(30),
            id
        };
        return CRUD.updateDB(sql, params);
    }
    
    public static Funcion obtenerFuncionesPorId(int id){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, s.ID as idSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID WHERE f.ID = ?";
        ResultSet rs = CRUD.consultarDB(sql, id);
        Funcion funcion = new Funcion();
        try {
            while(rs != null && rs.next()){
                int idFuncion = rs.getInt("ID");
                String nombrePelicula = rs.getString("NombrePelicula");
                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(nombrePelicula);
                String nombreSala = rs.getString("NombreSala");
                int idSala = rs.getInt("idSala");
                Sala sala = new Sala();
                sala.setId(idSala);
                sala.setNombre(nombreSala);
                Timestamp fechaInicioTimestamp = rs.getTimestamp("FechaInicio");
                LocalDateTime fechaInicio = fechaInicioTimestamp.toLocalDateTime();
                funcion.setId(idFuncion);
                funcion.setPelicula(pelicula);
                funcion.setSala(sala);
                funcion.setFechaInicio(fechaInicio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcion;
    }
    
    public static boolean removerFunciones(int id){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "DELETE FROM funciones WHERE ID = ?";
        return CRUD.eliminarDB(sql, id);
    }
    
    public static boolean crearFunciones(Funcion funcion) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "INSERT INTO funciones (FechaInicio, FechaFin, ID_Pelicula, ID_Sala) VALUES (?, ?, ?, ?)";
        int duracion = funcion.getPelicula().getDuracion();
        Object[] params = {
            funcion.getFechaInicio(),
            funcion.getFechaInicio().plusMinutes(duracion),
            funcion.getPelicula().getId(),
            funcion.getSala().getId()
        };

        boolean funcionCreada = CRUD.insertarDB(sql, params);

        if (!funcionCreada) {
            return false;
        }

        int idFuncion = obtenerUltimoIdFuncion();

        if (idFuncion > 0 && funcion.getAsientos() != null) {
            return asignarAsientosFuncion(idFuncion, funcion.getAsientos());
        }

        return false;
    }

    private static int obtenerUltimoIdFuncion() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT MAX(ID) AS ID FROM funciones";
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean asignarAsientosFuncion(int idFuncion, ArrayList<Asiento> asientos) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlInsert = "INSERT INTO funcionAsientos (ID_Funcion, ID_Asiento) VALUES (?, ?)";

        if (asientos == null || asientos.isEmpty()) {
            return false;
        }

        for (Asiento asiento : asientos) {
            Object[] params = {idFuncion, asiento.getId()};
            boolean insertado = CRUD.insertarDB(sqlInsert, params);
            if (!insertado) {
                return false;
            }
        }
        return true;
    }


    
    public static ArrayList<Funcion> obtenerFuncionesDisponibles(){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID WHERE f.Completa = FALSE";
        ArrayList<Funcion> funciones = new ArrayList<>();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while (rs != null && rs.next()) {
                int idFuncion = rs.getInt("ID");
                String nombrePelicula = rs.getString("NombrePelicula");
                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(nombrePelicula);
                String nombreSala = rs.getString("NombreSala");
                Sala sala = new Sala();
                sala.setNombre(nombreSala);
                Timestamp fechaInicioTimestamp = rs.getTimestamp("FechaInicio");
                LocalDateTime fechaInicio = fechaInicioTimestamp.toLocalDateTime();

                Funcion funcion = new Funcion();
                funcion.setId(idFuncion);
                funcion.setPelicula(pelicula);
                funcion.setSala(sala);
                funcion.setFechaInicio(fechaInicio);
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
    
    public static ArrayList<Funcion> obtenerFunciones() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID";
        ArrayList<Funcion> funciones = new ArrayList<>();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while (rs != null && rs.next()) {
                int idFuncion = rs.getInt("ID");
                String nombrePelicula = rs.getString("NombrePelicula");
                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(nombrePelicula);
                String nombreSala = rs.getString("NombreSala");
                Sala sala = new Sala();
                sala.setNombre(nombreSala);
                Timestamp fechaInicioTimestamp = rs.getTimestamp("FechaInicio");
                LocalDateTime fechaInicio = fechaInicioTimestamp.toLocalDateTime();

                Funcion funcion = new Funcion();
                funcion.setId(idFuncion);
                funcion.setPelicula(pelicula);
                funcion.setSala(sala);
                funcion.setFechaInicio(fechaInicio);
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FunctionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
}
