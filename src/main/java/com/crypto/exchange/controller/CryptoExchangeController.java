package com.crypto.exchange.controller;

import com.crypto.exchange.model.*;

public class CryptoExchangeController {

    public User registrarUsuario(int id, String name, String email, String password) {
        return User.registrar(id, name, email, password);
    }

    public boolean loginUsuario(User user, String email, String password) {
        return user.login(email, password);
    }

    public void realizarTransaccion(User usuario, Cryptocurrency criptomoneda, double cantidad) {
        usuario.getCartera().agregarCriptomoneda(criptomoneda, cantidad);
        Transaction transaccion = new Transaction(usuario, criptomoneda, cantidad, new java.util.Date());
        // Lógica para registrar la transacción, por ejemplo, almacenarla en una lista o base de datos
        System.out.println("Transacción realizada: " + transaccion);
    }
}
