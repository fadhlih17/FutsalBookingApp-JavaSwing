package org.example.services.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.WarningException;
import org.example.models.UserWallet;
import org.example.repositories.OwnerWalletRepository;
import org.example.repositories.UserWalletRepository;
import org.example.repositories.impl.UserWalletRepositoryImpl;
import org.example.services.OwnerWalletService;
import org.example.services.UserWalletService;

import javax.swing.*;
import java.util.UUID;

public class UserWalletServiceImpl implements UserWalletService {
    private UserWalletRepository walletRepository;
    private OwnerWalletService ownerWalletService;
    public UserWalletServiceImpl(UserWalletRepository userWalletRepository, OwnerWalletService ownerWalletService){
        this.walletRepository = userWalletRepository;
        this.ownerWalletService = ownerWalletService;
    }

    public UserWallet createUserWallet(UserWallet request){
        request.setId(UUID.randomUUID().toString());
        UserWallet userWallet = walletRepository.createUserWallet(request);
        return userWallet;
    }

    public UserWallet findUserWalletByUserId(String userId){
        UserWallet userWallet = walletRepository.findUserWalletByUserId(userId);
        return userWallet;
    }

    public UserWallet updateUserWalletBooked(String userId, long balance){
        UserWallet userWallet = findUserWalletByUserId(userId);

        if (userWallet.getBalance() < balance){
            try {
                throw new WarningException("Maaf, saldo tidak cukup. Silahkan top-up terlebih dahulu");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        var min = userWallet.getBalance() - balance;
        userWallet.setBalance(min);

        ownerWalletService.updateBalanceOwnerPlus(balance);

        return walletRepository.updateUserWallet(userWallet);
    }

    public UserWallet updateUserWalletTopUp(String userId, long balancce){
        UserWallet userWallet = findUserWalletByUserId(userId);
        var wallet = userWallet.getBalance() + balancce;
        userWallet.setBalance(wallet);
        return walletRepository.updateUserWallet(userWallet);
    }
}
