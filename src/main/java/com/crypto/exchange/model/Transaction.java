package com.crypto.exchange.model;

import java.util.Date;

public class Transaction {
    private User usuario;
    private Cryptocurrency criptomoneda;
    private double cantidad;
    private Date fecha;

    // Constructor
    public Transaction(User usuario, Cryptocurrency criptomoneda, double cantidad, Date fecha) {
        this.usuario = usuario;
        this.criptomoneda = criptomoneda;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters y Setters
    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Cryptocurrency getCriptomoneda() {
        return criptomoneda;
    }

    public void setCriptomoneda(Cryptocurrency criptomoneda) {
        this.criptomoneda = criptomoneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "usuario=" + usuario +
                ", criptomoneda=" + criptomoneda +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                '}';
    }
}
