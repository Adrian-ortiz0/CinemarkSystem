package org.example.models;

import java.util.ArrayList;

public class Sala {
    private int id;
    private String nombre;
    private double precio;
    private TipoSala tipo;
    private boolean llena;
    private int capacidadMaxima;
    private int capacidadActual;
    private ArrayList<Asiento> asientos;

    public Sala() {
    }

    public Sala(int id, String nombre, double precio, TipoSala tipo, boolean llena, int capacidadMaxima, int capacidadActual, ArrayList<Asiento> asientos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.llena = llena;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
        this.asientos = asientos;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
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

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public boolean isLlena() {
        return llena;
    }

    public void setLlena(boolean llena) {
        this.llena = llena;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }
    
}
