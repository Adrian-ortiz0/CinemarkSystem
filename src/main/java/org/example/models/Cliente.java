package org.example.models;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Membresia membresia;
    private DescuentoStrategy descuentoStrategy;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String cedula, Membresia membresia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.membresia = membresia;
        setDescuentoStrategy();
    }
    
    private void setDescuentoStrategy(){
        switch(membresia.getNombre()){
            case "GOLD":
                this.descuentoStrategy = new DescuentoMembresiaGold();
                break;
            case "PLATINUM":
                this.descuentoStrategy = new DescuentoMembresiaPlatino();
                break;
            default:
                throw new IllegalArgumentException("Tipo de membresia no reconocida");
        }
    }
    public double aplicarDescuento(double amount){
        return descuentoStrategy.aplicarDescuento(amount);
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    
}
