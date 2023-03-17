package org.example.repositories;

import org.example.models.UserWallet;

public interface UserWalletRepository {
    UserWallet createUserWallet(UserWallet userWallet);
    UserWallet updateUserWallet(UserWallet userWallet);
    UserWallet findUserWalletByUserId(String userId);
}
