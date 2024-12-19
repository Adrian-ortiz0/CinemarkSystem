package org.example.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Generos;
import org.example.models.Pelicula;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class PeliculasController {
    
    public static boolean retirarPeliculas(int id){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "update peliculas set Disponible = false where ID = ?";
        return CRUD.updateDB(sql, id);
    }
    
    public static ArrayList<Pelicula> obtenerPeliculasDisponibles(){
        CRUD.setConexion(ConnectionDB.getConnection());
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        String sql = "select * from peliculas where Disponible = true;";
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                java.util.Date fechaLanzamiento = rs.getDate("FechaLanzamiento");
                String director = rs.getString("Director");
                String generoString = rs.getString("Genero");
                Generos genero = null;
                genero = Generos.valueOf(generoString.toUpperCase());
                int duracion = rs.getInt("Duracion");
                boolean disponible = rs.getBoolean("Disponible");
                boolean estreno = rs.getBoolean("Estreno");
                Pelicula pelicula = new Pelicula(id, nombre, fechaLanzamiento, director, genero, duracion,disponible, estreno);
                listaPeliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPeliculas;
    }
    
    public static ArrayList<Pelicula> obtenerPeliculas(){
        CRUD.setConexion(ConnectionDB.getConnection());
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        String sql = "select * from peliculas";
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                java.util.Date fechaLanzamiento = rs.getDate("FechaLanzamiento");
                String director = rs.getString("Director");
                String generoString = rs.getString("Genero");
                Generos genero = null;
                genero = Generos.valueOf(generoString.toUpperCase());
                int duracion = rs.getInt("Duracion");
                boolean disponible = rs.getBoolean("Disponible");
                boolean estreno = rs.getBoolean("Estreno");
                Pelicula pelicula = new Pelicula(id, nombre, fechaLanzamiento, director, genero, duracion,disponible, estreno);
                listaPeliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPeliculas;
    }
    
    public static boolean insertarPeliculas(Pelicula pelicula){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "insert into peliculas (Nombre, FechaLanzamiento, Director, Genero, Duracion, Disponible, Estreno) values (?,?,?,?,?,?,?)";
        String nombrePelicula = pelicula.getNombre();
        java.util.Date fechaLanzamiento = pelicula.getFechaLanzamiento();
        String director = pelicula.getDirector();
        String genero = pelicula.getGenero().name();
        int duracion = pelicula.getDuracion();
        boolean disponible = true;
        boolean estreno = true;
        
        Object[] params = {
            nombrePelicula,
            fechaLanzamiento,
            director,
            genero,
            duracion,
            disponible,
            estreno
        };
        return CRUD.insertarDB(sql, params);
    }
}
