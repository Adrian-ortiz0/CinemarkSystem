package org.example.models;

import java.util.ArrayList;

public class Boleto {
    private int id;
    private Cliente cliente;
    private Asiento asientos;
    private Funcion funcion;
    private boolean vencido;

    public Boleto() {
    }

    public Boleto(int id, Cliente cliente, Asiento asientos, Funcion funcion) {
        this.id = id;
        this.cliente = cliente;
        this.asientos = asientos;
        this.funcion = funcion;
    }

    public Boleto(int id, Cliente cliente, Asiento asientos, Funcion funcion, boolean vencido) {
        this.id = id;
        this.cliente = cliente;
        this.asientos = asientos;
        this.funcion = funcion;
        this.vencido = vencido;
    }

    public boolean isVencido() {
        return vencido;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }

    public Asiento getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento asientos) {
        this.asientos = asientos;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    
}
