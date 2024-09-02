package com.crypto.exchange.model;

public class Transaction {
    private String type;  // buy or sell
    private Cryptocurrency cryptocurrency;
    private double amount;
    private double price;

    public Transaction(String type, Cryptocurrency cryptocurrency, double amount, double price) {
        this.type = type;
        this.cryptocurrency = cryptocurrency;
        this.amount = amount;
        this.price = price;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", cryptocurrency=" + cryptocurrency.getName() +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
