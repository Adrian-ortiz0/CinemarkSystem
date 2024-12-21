package org.example.models;

import java.util.Date;

public class FacturaBoleto {
    private int id;
    private double total;
    private java.util.Date fecha;
    private Cliente cliente;
    private Boleto boleto;

    public FacturaBoleto() {
    }

    public FacturaBoleto(int id, double total, Date fecha, Cliente cliente, Boleto boleto) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.boleto = boleto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
    
    
}
