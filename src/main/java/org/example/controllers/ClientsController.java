package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.models.Cliente;
import org.example.models.Membresia;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class ClientsController {
    
        public static boolean actualizarMembresia(int idCliente ,int idMembresia){
            CRUD.setConexion(ConnectionDB.getConnection());
            String sql = "UPDATE clientes SET ID_Membresia = ? WHERE ID = ?";
            Object[] params = { idMembresia, idCliente,};
            return CRUD.updateDB(sql, params);
        }
    
        public static Cliente obtenerClientePorCedula(String cedula) {
    CRUD.setConexion(ConnectionDB.getConnection());
    String sql = "SELECT c.ID, c.Nombre, c.Apellido, c.Cedula, c.ID_Membresia, " +
                 "m.Nombre AS MembresiaNombre, m.Precio AS MembresiaPrecio, m.Descripcion AS MembresiaDescripcion " +
                 "FROM clientes c " +
                 "LEFT JOIN membresias m ON c.ID_Membresia = m.ID " +
                 "WHERE c.Cedula = ?";
    Object[] params = {cedula};
    ResultSet rs = CRUD.consultarDB(sql, params);

    try {
        if (rs != null && rs.next()) {
            int id = rs.getInt("ID");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            int idMembresia = rs.getInt("ID_Membresia");
            String nombreMembresia = rs.getString("MembresiaNombre");
            double precioMembresia = rs.getDouble("MembresiaPrecio");
            String descripcionMembresia = rs.getString("MembresiaDescripcion");

            Membresia membresia = null;
            if (nombreMembresia != null) {
                membresia = new Membresia();
                membresia.setId(idMembresia);
                membresia.setNombre(nombreMembresia);
                membresia.setPrecio(precioMembresia);
                membresia.setDescripcion(descripcionMembresia);
            }

            Cliente cliente = new Cliente();
            cliente.setApellido(apellido);
            cliente.setNombre(nombre);
            cliente.setCedula(cedula);
            cliente.setMembresia(membresia);
            cliente.setId(id);

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
