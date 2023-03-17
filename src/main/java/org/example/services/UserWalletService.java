package org.example.services;

import org.example.models.UserWallet;

public interface UserWalletService {
    UserWallet createUserWallet(UserWallet request);
    UserWallet findUserWalletByUserId(String userId);
    UserWallet updateUserWalletBooked(String userId, long balance);
    UserWallet updateUserWalletTopUp(String userId, long balancce);
}
