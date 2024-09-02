package com.crypto.exchange.model;

public class RegularAccount extends Account {

    public RegularAccount(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public void accessAccount() {
        System.out.println("Accessing regular account for user: " + getName());
    }
}
