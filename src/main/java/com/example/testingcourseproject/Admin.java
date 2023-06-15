package com.example.testingcourseproject;

public class Admin {
    private String id;
    private Account account;
    private final boolean isAdmin = true;

    public Admin(String id, String username, String password){
        this.id = id;
        this.createAccount(username, password);
    }
    public boolean createAccount(String username, String password){
        this.account = new Account(username, password);
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
