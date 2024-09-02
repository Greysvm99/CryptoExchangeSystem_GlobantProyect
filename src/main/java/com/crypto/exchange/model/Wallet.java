package com.crypto.exchange.model;

public class Wallet implements CryptoWalletOperations {
    private double fiatBalance;
    private Cryptocurrency cryptocurrency;

    public Wallet(double fiatBalance, Cryptocurrency cryptocurrency) {
        this.fiatBalance = fiatBalance;
        this.cryptocurrency = cryptocurrency;
    }

    @Override
    public void depositMoney(double amount) {
        this.fiatBalance += amount;
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount <= fiatBalance) {
            this.fiatBalance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return fiatBalance;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }
}
