package com.crypto.exchange.view;

import com.crypto.exchange.controller.CryptoExchangeController;
import com.crypto.exchange.model.Account;
import com.crypto.exchange.model.Transaction;

import java.util.List;
import java.util.Scanner;

public class CryptoExchangeView {
    private CryptoExchangeController controller;
    private Account loggedInUser;
    private Scanner scanner;

    public CryptoExchangeView() {
        controller = new CryptoExchangeController();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void register() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Is this an admin account? (true/false): ");
        boolean isAdmin = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline

        loggedInUser = controller.registerAccount(name, email, password, isAdmin);
        System.out.println("Registration successful! Your user ID: " + loggedInUser.getUserId());
    }

    private void login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loggedInUser = controller.loginUser(email, password);
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome, " + loggedInUser.getName());
            showMainMenu();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("1. Deposit Money");
            System.out.println("2. View Wallet Balance");
            System.out.println("3. Buy Cryptocurrency");
            System.out.println("4. Sell Cryptocurrency");
            System.out.println("5. View Transaction History");
            System.out.println("6. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    viewWalletBalance();
                    break;
                case 3:
                    buyCryptocurrency();
                    break;
                case 4:
                    sellCryptocurrency();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        controller.depositMoney(loggedInUser, amount);
        System.out.println("Money deposited successfully!");
    }

    private void viewWalletBalance() {
        if (loggedInUser.getWallet() != null) {
            System.out.println("Fiat balance: " + loggedInUser.getWallet().getBalance());
            if (loggedInUser.getWallet().getCryptocurrency() != null) {
                System.out.println("Cryptocurrency: " + loggedInUser.getWallet().getCryptocurrency().getName() +
                        " Amount: " + loggedInUser.getWallet().getCryptocurrency().getQuantityAvailable());
            } else {
                System.out.println("No cryptocurrencies in your wallet.");
            }
        } else {
            System.out.println("No wallet found. Please deposit money first.");
        }
    }

    private void buyCryptocurrency() {
        System.out.print("Enter cryptocurrency symbol (e.g., BTC, ETH): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter amount to buy: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        controller.buyCryptocurrency(loggedInUser, symbol, amount);
    }

    private void sellCryptocurrency() {
        System.out.print("Enter cryptocurrency symbol (e.g., BTC, ETH): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter amount to sell: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        controller.sellCryptocurrency(loggedInUser, symbol, amount);
    }

    private void viewTransactionHistory() {
        List<Transaction> history = controller.viewTransactionHistory(loggedInUser);
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            history.forEach(System.out::println);
        }
    }
}
