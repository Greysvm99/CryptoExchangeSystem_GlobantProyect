package com.crypto.exchange.model;

public class AdminAccount extends Account {

    public AdminAccount(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public void accessAccount() {
        System.out.println("Accessing admin account for user: " + getName());
    }
}
