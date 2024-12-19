package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Admin;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class AdminController {
    
    public static Admin iniciarSesionAdmin(String correo, String contraseña){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM administrador WHERE Correo = ? and Contraseña = ? ";
        Object[] params = {
            correo,
            contraseña
        };
        try {
            ResultSet rs = CRUD.consultarDB(sql, params);
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String correoAdmin = rs.getString("Correo");
                String contraseñaAdmin = rs.getString("Contraseña");
                return new Admin(id, correoAdmin, contraseñaAdmin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
