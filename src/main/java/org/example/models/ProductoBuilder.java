
package org.example.models;

import java.util.ArrayList;

public class ProductoBuilder {
    private int id;
    private String nombre;
    private ArrayList<MateriaPrima> ingredientes = new ArrayList<>();
    private double precio;

    public ProductoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder addIngrediente(MateriaPrima materiaPrima) {
        this.ingredientes.add(materiaPrima);
        return this;
    }

    public ProductoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, ingredientes, precio);
    }
}

