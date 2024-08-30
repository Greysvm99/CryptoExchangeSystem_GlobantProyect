package com.crypto.exchange.model;

import java.util.HashMap;
import java.util.Map;

public class Wallet {
    private Map<Cryptocurrency, Double> criptomonedas;

    // Constructor
    public Wallet() {
        this.criptomonedas = new HashMap<>();
    }

    // Método para agregar criptomonedas
    public void agregarCriptomoneda(Cryptocurrency criptomoneda, double cantidad) {
        criptomonedas.put(criptomoneda, criptomonedas.getOrDefault(criptomoneda, 0.0) + cantidad);
    }

    // Método para obtener el balance de una criptomoneda
    public double obtenerBalance(Cryptocurrency criptomoneda) {
        return criptomonedas.getOrDefault(criptomoneda, 0.0);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "criptomonedas=" + criptomonedas +
                '}';
    }
}
