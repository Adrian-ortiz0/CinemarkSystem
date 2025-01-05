
package org.example.models;

import java.util.ArrayList;

public class ComboBuilder {
    private int id;
    private String nombre;
    private ArrayList<Producto> productos = new ArrayList<>();

    public ComboBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ComboBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComboBuilder addProducto(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.productos.add(producto);
        }
        return this;
    }


    public Combo build() {
        return new Combo(id, nombre, productos);
    }
}

