package org.example.models;

import java.sql.Date;

public class MateriaPrima {
    
    private int id;
    private String nombre;
    private MedidasMateriaPrima medida;
    private double precioPorUnidad;
    private Date fechaVencimiento;
    private int cantidad;
    private Proveedor proveedor;
    private int cantidadMinima;
    private int cantidadNecesaria;

    public MateriaPrima() {
    }

    public MateriaPrima(int id, String nombre, MedidasMateriaPrima medida, double precioPorUnidad, Date fechaVencimiento, int cantidad, Proveedor proveedor, int cantidadMinima, int cantidadNecesaria) {
        this.id = id;
        this.nombre = nombre;
        this.medida = medida;
        this.precioPorUnidad = precioPorUnidad;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.cantidadMinima = cantidadMinima;
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public int getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(int cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
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

    public MedidasMateriaPrima getMedida() {
        return medida;
    }

    public void setMedida(MedidasMateriaPrima medida) {
        this.medida = medida;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
}
