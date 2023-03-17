package org.example.services;

import org.example.models.OwnerWallet;

public interface OwnerWalletService {
    OwnerWallet createWalletOwner(OwnerWallet ownerWallet);
    OwnerWallet findOwnerWallet();
    OwnerWallet updateBalanceOwnerPlus(long balance);
}
