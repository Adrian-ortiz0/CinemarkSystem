package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combo {
    private int id;
    private String nombre;
    private List<Producto> productos;
    private Map<Producto, Integer> productosMap;
    private double precioTotal;
    

    public Combo() {
        this.productosMap = new HashMap<>();
    }

    public Combo(int id, String nombre, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos != null ? productos : new ArrayList<>();
        this.productosMap = new HashMap<>();
        for (Producto producto : productos) {
            this.productosMap.put(producto, this.productosMap.getOrDefault(producto, 0) + 1);
        }
        this.precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        return productosMap.entrySet().stream()
            .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
            .sum();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        this.productosMap = new HashMap<>();
        for (Producto producto : productos) {
            this.productosMap.put(producto, this.productosMap.getOrDefault(producto, 0) + 1);
        }
        this.precioTotal = calcularPrecioTotal();
    }

    public Map<Producto, Integer> getProductosMap() {
        return productosMap;
    }

    public void setProductosMap(Map<Producto, Integer> productosMap) {
        this.productosMap = productosMap;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
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
}
