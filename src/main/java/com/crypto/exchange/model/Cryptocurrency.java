package com.crypto.exchange.model;

public class Cryptocurrency {
    private String name;
    private String simbolo;

    // Constructor
    public Cryptocurrency(String name, String simbolo) {
        this.name = name;
        this.simbolo = simbolo;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Cryptocurrency{" +
                "nombre='" + name + '\'' +
                ", simbolo='" + simbolo + '\'' +
                '}';
    }
}
