package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Sala;
import org.example.models.TipoSala;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class SalasController {
    
    public static ArrayList<Sala> salasDisponibles(){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM salas";
        ArrayList<Sala> salas = new ArrayList();
        ResultSet rs = CRUD.consultarDB(sql);
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                String tipoSalaString = rs.getString("Tipo");
                TipoSala tipoSala = TipoSala.valueOf(tipoSalaString);
                boolean llena = rs.getBoolean("Llena");
                int capacidadMaxima = rs.getInt("CapacidadMaxima");
                int capacidadActual = rs.getInt("CapacidadActual");
                Sala sala = new Sala(id, nombre, precio, tipoSala, llena, capacidadMaxima, capacidadActual);
                salas.add(sala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salas;
    }
}
