package org.example.models;

public class Asiento {
    private int id;
    private Sala sala;
    private TipoAsiento tipo;
    private String fila;
    private int numero;
    private boolean ocupado;

    public Asiento() {
    }

    public Asiento(int id, Sala sala, TipoAsiento tipo, String fila, int numero, boolean ocupado) {
        this.id = id;
        this.sala = sala;
        this.tipo = tipo;
        this.fila = fila;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public TipoAsiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAsiento tipo) {
        this.tipo = tipo;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
