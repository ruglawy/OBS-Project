package com.example.testingcourseproject;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private double balance;
    private Account account;
    private List<Transaction> transactions = new ArrayList<>();
    private final boolean isAdmin = false;

    public Client(String id, String name, String address, String phoneNumber, String email, double balance, String username, String password){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        this.createAccount(username, password);
    }
    public boolean createAccount(String username, String password){
        this.account = new Account(username, password);
        return true;
    }

    public boolean addTransaction(String type, double amount){
        transactions.add(new Transaction(type, amount));
        return true;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
