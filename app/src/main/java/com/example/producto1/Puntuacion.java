package com.example.producto1;

public class Puntuacion {
    private int id;
    private String name;
    private String time;

    public Puntuacion(String nombre, String tiempo) {
    }

    @Override
    public String toString() {
        return name;
    }

    public Puntuacion() {
    }

    public Puntuacion(int id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
