package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Boleto;
import org.example.models.Tiquetero;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class TiqueteroController {
    
//    public static boolean registrarVentaBoleto(){
//        
//    }
    
    public static boolean venderBoleto(Boleto boleto){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "insert into boletos (ID_Cliente, ID_Asiento, ID_Funcion) values (?, ?, ?)";
        Object[] params = {boleto.getCliente().getId(), boleto.getAsientos().getId(), boleto.getFuncion().getId()};
        return CRUD.insertarDB(sql, params);
    }
    
    public static Tiquetero iniciarSesionTiquetero(String correo, String contraseña){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM tiquetero WHERE Correo = ? AND Contraseña = ?";
        Object [] params = {correo, contraseña};
        ResultSet rs = CRUD.consultarDB(sql, params);
        Tiquetero tiquetero = new Tiquetero();
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String correoTiquetero = rs.getString("Correo");
                String contraseñaTiquetero = rs.getString("Contraseña");
                tiquetero.setId(id);
                tiquetero.setContraseña(contraseñaTiquetero);
                tiquetero.setCorreo(correoTiquetero);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiqueteroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiquetero;
    }
}
