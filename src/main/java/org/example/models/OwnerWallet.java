package org.example.models;

public class OwnerWallet {
    private String id;
    private long balance;

    public OwnerWallet() {
    }

    public OwnerWallet(String id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
