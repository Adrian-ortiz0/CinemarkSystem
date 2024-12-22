package org.example.controllers;

import java.sql.Date;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class FacturasController {
    
    public static boolean insertarFacturasYDetalles(Date fechaFactura, int idCliente, double total, String metodoPago){
        CRUD.setConexion(ConnectionDB.getConnection());
        String sql = "insert into facturas (FechaFactura, ID_Cliente, Total, MetodoPago) values (?, ?, ?, ?)";
        Object [] params = {
            fechaFactura,
            idCliente,
            total,
            metodoPago
        };
        return CRUD.insertarDB(sql, params);
    }
}
