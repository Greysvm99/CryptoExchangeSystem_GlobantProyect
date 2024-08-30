package com.crypto.exchange.view;

import com.crypto.exchange.controller.CryptoExchangeController;
import com.crypto.exchange.model.Cryptocurrency;
import com.crypto.exchange.model.User;

import java.util.Scanner;

public class MainMenu {
    private final CryptoExchangeController controller;
    private final Scanner scanner;

    public MainMenu() {
        controller = new CryptoExchangeController();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido al Sistema de Exchange de Criptomonedas");
        // Lógica para mostrar opciones y capturar entradas del usuario
    }

    public void registrarUsuario() {
        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese nombre: ");
        String name = scanner.next();
        System.out.print("Ingrese email: ");
        String email = scanner.next();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.next();
        User user = controller.registrarUsuario(id, name, email, password);
        System.out.println("Usuario registrado: " + user);
    }

    public void loginUsuario() {
        // Lógica para login
    }

    public void realizarTransaccion(User usuario) {
        System.out.print("Ingrese nombre de la criptomoneda: ");
        String nombreCripto = scanner.next();
        System.out.print("Ingrese símbolo de la criptomoneda: ");
        String simboloCripto = scanner.next();
        System.out.print("Ingrese cantidad: ");
        double cantidad = scanner.nextDouble();
        Cryptocurrency criptomoneda = new Cryptocurrency(nombreCripto, simboloCripto);
        controller.realizarTransaccion(usuario, criptomoneda, cantidad);
    }

    // Más métodos para diferentes funcionalidades...
}
