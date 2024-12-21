package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Cliente;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class ClientsController {
    
    public static Cliente obtenerClientePorCedula(String cedula){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "select * from cliente where Cedula = ?";
        ResultSet rs = CRUD.consultarDB(sql, cedula);
        Cliente clienteObtener = new Cliente();
        try {
            while(rs != null && rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                clienteObtener.setCedula(cedula);
                clienteObtener.setId(id);
                clienteObtener.setNombre(nombre);
                clienteObtener.setApellido(apellido);
                clienteObtener.setCedula(cedula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteObtener;
    }
    
    public static boolean crearClientes(Cliente cliente){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "insert into clientes (Nombre, Apellido, Cedula) values (?, ?, ?)";
        Object [] params = {cliente.getNombre(), cliente.getApellido(), cliente.getCedula()};
        return CRUD.insertarDB(sql, params);
    }
}
