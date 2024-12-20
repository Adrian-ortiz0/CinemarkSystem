package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Funcion;
import org.example.models.Pelicula;
import org.example.models.Sala;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class FunctionsController {
    
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
        String sql = "SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID WHERE f.ID = ?";
        ResultSet rs = CRUD.consultarDB(sql, id);
        Funcion funcion = new Funcion();
        try {
            while(rs != null && rs.next()){
                int idFuncion = rs.getInt("ID");
                String nombrePelicula = rs.getString("NombrePelicula");
                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(nombrePelicula);
                String nombreSala = rs.getString("NombreSala");
                Sala sala = new Sala();
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
    
    public static boolean crearFunciones(Funcion funcion){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "INSERT INTO funciones (FechaInicio, FechaFin, ID_Pelicula, ID_Sala)  VALUES (?, ?, ?, ?)";
        Object[] params = {
            funcion.getFechaInicio(),
            funcion.getFechaInicio().plusMinutes(30),
            funcion.getPelicula().getId(),
            funcion.getSala().getId()
        };
        return CRUD.insertarDB(sql, params);
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
