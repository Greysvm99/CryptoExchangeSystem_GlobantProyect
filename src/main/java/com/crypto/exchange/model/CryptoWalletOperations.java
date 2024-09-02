package com.crypto.exchange.model;

public interface CryptoWalletOperations {
    void depositMoney(double amount);
    void withdrawMoney(double amount);
    double getBalance();
}
