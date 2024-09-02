package com.crypto.exchange.controller;

import com.crypto.exchange.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CryptoExchangeController {
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<Cryptocurrency> cryptocurrencies;

    public CryptoExchangeController() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
        cryptocurrencies = new ArrayList<>();
        initializePrices();
    }

    public void initializePrices() {
        cryptocurrencies.add(new Cryptocurrency("BTC", "Bitcoin", 50000, 100));
        cryptocurrencies.add(new Cryptocurrency("ETH", "Ethereum", 3000, 500));
    }

    public Account registerAccount(String name, String email, String password, boolean isAdmin) {
        String userId = "U" + (accounts.size() + 1);
        Account account;
        if (isAdmin) {
            account = new AdminAccount(userId, name, email, password);
        } else {
            account = new RegularAccount(userId, name, email, password);
        }
        accounts.add(account);
        return account;
    }

    public Account loginUser(String email, String password) {
        for (Account account : accounts) {
            if (account.checkCredentials(email, password)) {
                return account;
            }
        }
        return null;
    }

    public void depositMoney(Account account, double amount) {
        Wallet wallet = new Wallet(amount, null);
        account.setWallet(wallet);
    }

    public List<Cryptocurrency> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public void buyCryptocurrency(Account account, String symbol, double amount) {
        Cryptocurrency crypto = findCryptocurrencyBySymbol(symbol);
        if (crypto != null && account.getWallet().getBalance() >= crypto.getPrice() * amount) {
            account.getWallet().withdrawMoney(crypto.getPrice() * amount);
            crypto.setQuantityAvailable(crypto.getQuantityAvailable() - amount);
            account.getWallet().setCryptocurrency(crypto);
            transactions.add(new Transaction("buy", crypto, amount, crypto.getPrice()));
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Insufficient funds or cryptocurrency not available.");
        }
    }

    public void sellCryptocurrency(Account account, String symbol, double amount) {
        Cryptocurrency crypto = findCryptocurrencyBySymbol(symbol);
        if (crypto != null && account.getWallet().getCryptocurrency() != null &&
                account.getWallet().getCryptocurrency().getSymbol().equals(symbol) &&
                account.getWallet().getCryptocurrency().getQuantityAvailable() >= amount) {

            account.getWallet().depositMoney(crypto.getPrice() * amount);
            crypto.setQuantityAvailable(crypto.getQuantityAvailable() + amount);
            account.getWallet().setCryptocurrency(null);
            transactions.add(new Transaction("sell", crypto, amount, crypto.getPrice()));
            System.out.println("Sale successful!");
        } else {
            System.out.println("Insufficient cryptocurrency or wrong type.");
        }
    }

    private Cryptocurrency findCryptocurrencyBySymbol(String symbol) {
        return cryptocurrencies.stream()
                .filter(c -> c.getSymbol().equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public List<Transaction> viewTransactionHistory(Account account) {
        return transactions.stream()
                .filter(t -> t.getCryptocurrency().equals(account.getWallet().getCryptocurrency()))
                .collect(Collectors.toList());
    }

    public void fluctuateMarketPrices() {
        Random rand = new Random();
        for (Cryptocurrency crypto : cryptocurrencies) {
            double fluctuation = 1 + (rand.nextDouble() - 0.5) / 10;
            crypto.setPrice(crypto.getPrice() * fluctuation);
        }
    }
}
