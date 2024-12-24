package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Funcion {
    private int id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Pelicula pelicula;
    private Sala sala;
    private boolean completa;
    private ArrayList<Asiento> asientos;

    public Funcion() {
    }

    public Funcion(int id, LocalDateTime fechaInicio, LocalDateTime fechaFin, Pelicula pelicula, Sala sala, boolean completa, ArrayList<Asiento> asientos) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pelicula = pelicula;
        this.sala = sala;
        this.completa = completa;
        this.asientos = asientos;
    }

    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }



    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    
}
