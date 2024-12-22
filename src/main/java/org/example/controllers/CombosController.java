package org.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.example.models.Combo;
import org.example.models.Producto;
import org.example.persistence.CRUD;
import org.example.persistence.ConnectionDB;

public class CombosController {
    
    public static ArrayList<Producto> obtenerProductos() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlProductos = "SELECT ID, Nombre, Precio FROM productos";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            ResultSet rsProductos = CRUD.consultarDB(sqlProductos);
            while (rsProductos != null && rsProductos.next()) {
                int idProducto = rsProductos.getInt("ID");
                String nombreProducto = rsProductos.getString("Nombre");
                double precioProducto = rsProductos.getDouble("Precio");

                Producto producto = new Producto(idProducto, nombreProducto, null, precioProducto);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    
    public static ArrayList<Combo> obtenerCombos() {
        CRUD.setConexion(ConnectionDB.getConnection());
        String sqlCombos = "SELECT ID, Nombre, Precio FROM combos";
        ArrayList<Combo> combos = new ArrayList<>();

        try {
            ResultSet rsCombos = CRUD.consultarDB(sqlCombos);
            while (rsCombos != null && rsCombos.next()) {
                int idCombo = rsCombos.getInt("ID");
                String nombreCombo = rsCombos.getString("Nombre");
                double precioCombo = rsCombos.getDouble("Precio");

                Combo combo = new Combo(idCombo, nombreCombo, new ArrayList<>()); 
                combo.setPrecioTotal(precioCombo);
                combos.add(combo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combos;
    }



}
