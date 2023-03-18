package org.example.services.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.NotFoundException;
import org.example.models.OwnerWallet;
import org.example.repositories.OwnerWalletRepository;
import org.example.services.OwnerWalletService;

import java.util.UUID;

public class OwnerWalletServiceImpl implements OwnerWalletService {
    private OwnerWalletRepository repository;
    public OwnerWalletServiceImpl(OwnerWalletRepository repository){
        this.repository = repository;
    }

    public OwnerWallet createWalletOwner(OwnerWallet ownerWallet){
        ownerWallet.setId(UUID.randomUUID().toString());
        return repository.createOwnerWallet(ownerWallet);
    }

    public OwnerWallet findOwnerWallet(){
        OwnerWallet find = repository.findOwnerWallet();
        return find;
    }

    public OwnerWallet updateBalanceOwnerPlus(long balance){
        var findWallet = findOwnerWallet();
        long plus = findWallet.getBalance() + balance;
        findWallet.setBalance(plus);
        return repository.updateOwnerWallet(findWallet);
    }
}
