package org.example.models;

import java.sql.Date;

public class Pelicula {
    private int id;
    private String nombre;
    private java.util.Date fechaLanzamiento;
    private String director;
    private Generos genero;
    private int duracion;
    private boolean disponible;
    private boolean estreno;

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, java.util.Date fechaLanzamiento, String director, Generos genero, int duracion, boolean disponible, boolean estreno) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.disponible = disponible;
        this.estreno = estreno;
    }

    

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
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

    public java.util.Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(java.util.Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        this.estreno = estreno;
    }
    
    
}
