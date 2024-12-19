package org.example.controllers;

import org.example.models.Funcion;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class FunctionsController {
    
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
}
