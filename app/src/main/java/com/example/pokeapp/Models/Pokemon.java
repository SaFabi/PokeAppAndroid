package com.example.pokeapp.Models;

public class Pokemon {

    private int id;
    private String nombre;
    private String url;


    public Pokemon(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public Pokemon(int id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
