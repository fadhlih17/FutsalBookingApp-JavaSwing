package org.example.models;

import java.math.*;

public class UserWallet {

    public String id, userId;
    public long balance;

    public UserWallet() {
    }

    public UserWallet(String id, String userId, long balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
