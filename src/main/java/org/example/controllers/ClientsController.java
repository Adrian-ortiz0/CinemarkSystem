package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Cliente;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class ClientsController {
    
        public static Cliente obtenerClientePorCedula(String cedula) {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "SELECT * FROM clientes WHERE Cedula = ?";
        Object[] params = {cedula};
        ResultSet rs = CRUD.consultarDB(sql, params);

        try {
            if (rs != null && rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCedula(cedula);
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public static boolean crearClientes(Cliente cliente){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "insert into clientes (Nombre, Apellido, Cedula) values (?, ?, ?)";
        Object [] params = {cliente.getNombre(), cliente.getApellido(), cliente.getCedula()};
        return CRUD.insertarDB(sql, params);
    }
}
