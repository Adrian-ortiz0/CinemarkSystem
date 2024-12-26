package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Membresia;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class MembresiaController {
    public static Membresia obtenerMembresiaPorNombre(String membresia){
            CRUD.setConexion(ConnectionDB.getConnection());
            String sql = "SELECT * FROM membresias WHERE Nombre = ?";
            Object[] params = {membresia.toUpperCase()};
            ResultSet rs = CRUD.consultarDB(sql, params);
            try {
                while(rs != null && rs.next()){
                    Membresia membresiaObtenida = new Membresia();
                    int id = rs.getInt("ID");
                    double precio = rs.getDouble("Precio");
                    String descripcion = rs.getString("Descripcion");
                    membresiaObtenida.setId(id);
                    membresiaObtenida.setNombre(membresia);
                    membresiaObtenida.setPrecio(precio);
                    membresiaObtenida.setDescripcion(descripcion);
                    return membresiaObtenida;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
}
