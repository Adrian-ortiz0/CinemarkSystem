package org.example.models;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private ArrayList<MateriaPrima> ingredientes;

    public Producto() {
    }

    public Producto(int id, String nombre, ArrayList<MateriaPrima> ingredientes, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public Producto(int id, String nombre, double precio, int cantidad, ArrayList<MateriaPrima> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.ingredientes = ingredientes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<MateriaPrima> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<MateriaPrima> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
