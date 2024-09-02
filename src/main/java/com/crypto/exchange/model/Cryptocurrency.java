package com.crypto.exchange.model;

public class Cryptocurrency {
    private String symbol;
    private String name;
    private double price;
    private double quantityAvailable;

    public Cryptocurrency(String symbol, String name, double price, double quantityAvailable) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(double quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
