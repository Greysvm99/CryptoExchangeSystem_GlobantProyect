package com.crypto.exchange.model;

public abstract class Account {
    private String userId;
    private String name;
    private String email;
    private String password;
    private Wallet wallet;

    public Account(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean checkCredentials(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public abstract void accessAccount();
}
