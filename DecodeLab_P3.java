
package com.mycompany.decodelab_p3;

import java.util.ArrayList;
import java.util.Scanner;
class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private int pin;

    public BankAccount(int accountNumber, String accountHolderName,
                       double balance, int pin) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public boolean deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return true;
        }

        return false;
    }
}

class Bank {

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(int accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public BankAccount authenticate(int accountNumber, int pin) {

        BankAccount account = findAccount(accountNumber);

        if (account != null && account.validatePin(pin)) {
            return account;
        }

        return null;
    }
}

class ATM {

    private Scanner sc;
    private Bank bank;
    private BankAccount currentAccount;

    private static final int MAX_ATTEMPTS = 3;

    public ATM(Bank bank, Scanner sc) {
        this.bank = bank;
        this.sc = sc;
    }

    public void run() {

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        boolean exit = false;

        while (!exit) {

            if (login()) {
                showMenu();
            }
            else {
                System.out.println("Too many failed attempts.");
                exit = true;
            }

            if (!exit && currentAccount == null) {

                System.out.print("Login with another account? (Y/N): ");
                String choice = sc.nextLine();

                if (!choice.equalsIgnoreCase("Y")) {
                    exit = true;
                }
            }
        }

        System.out.println("Thank you for using the ATM.");
    }

    private boolean login() {

        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {

            System.out.print("Enter Account Number: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid account number: ");
                sc.next();
            }

            int accountNumber = sc.nextInt();

            System.out.print("Enter PIN: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid PIN: ");
                sc.next();
            }

            int pin = sc.nextInt();
            sc.nextLine();

            BankAccount account =
                    bank.authenticate(accountNumber, pin);

            if (account != null) {

                currentAccount = account;

                System.out.println(
                    "Login successful. Welcome, "
                    + account.getAccountHolderName()
                );

                return true;
            }

            attempts++;

            System.out.println(
                "Invalid account number or PIN."
            );

            System.out.println(
                "Attempts remaining: "
                + (MAX_ATTEMPTS - attempts)
            );
        }

        return false;
    }


    private void showMenu() {

        boolean logout = false;

        while (!logout) {

            System.out.println("\n--------- ATM MENU ---------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int choice = getChoice();

            switch (choice) {

                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Logging out...");
                    currentAccount = null;
                    logout = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private int getChoice() {

        while (!sc.hasNextInt()) {

            System.out.print("Enter a number from 1-4: ");
            sc.next();
        }

        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }


    private double getAmount() {

        System.out.print("Enter amount: ");

        while (!sc.hasNextDouble()) {

            System.out.print("Enter a valid amount: ");
            sc.next();
        }

        double amount = sc.nextDouble();
        sc.nextLine();

        return amount;
    }


    private void deposit() {

        double amount = getAmount();

        if (currentAccount.deposit(amount)) {

            System.out.printf(
                "Deposit successful. New balance: %.2f%n",
                currentAccount.getBalance()
            );

        } else {

            System.out.println(
                "Deposit failed. Amount must be greater than zero."
            );
        }
    }


    private void withdraw() {

        double amount = getAmount();

        if (currentAccount.withdraw(amount)) {

            System.out.printf(
                "Withdrawal successful. New balance: %.2f%n",
                currentAccount.getBalance()
            );

        } else {

            System.out.println(
                "Withdrawal failed. Insufficient balance or invalid amount."
            );
        }
    }


    private void checkBalance() {

        System.out.printf(
            "Current balance: %.2f%n",
            currentAccount.getBalance()
        );
    }
}


// Main class
public class DecodeLab_P3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        bank.addAccount(
            new BankAccount(1001, "Ali Khan", 5000, 1234)
        );

        bank.addAccount(
            new BankAccount(1002, "Sara Ahmed", 12000, 4321)
        );

        bank.addAccount(
            new BankAccount(1003, "Bilal Raza", 750, 1111)
        );

        ATM atm = new ATM(bank, sc);

        atm.run();

        sc.close();
    }
}
