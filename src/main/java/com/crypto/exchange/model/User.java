package com.crypto.exchange.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Wallet cartera;

    // Constructor
    public User(int id, String name, String email, String password, Wallet cartera) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cartera = cartera;
    }

    // Métodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getCartera() {
        return cartera;
    }

    public void setCartera(Wallet cartera) {
        this.cartera = cartera;
    }

    // Método para registrar un usuario
    public static User registrar(int id, String name, String email, String password) {
        Wallet cartera = new Wallet(); // Inicializar una nueva cartera vacía para el usuario
        return new User(id, name, email, password, cartera);
    }

    // Método para hacer login
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name+ '\'' +
                ", email='" + email + '\'' +
                ", cartera=" + cartera +
                '}';
    }
}
