package org.example.repositories;

import org.example.models.OwnerWallet;

public interface OwnerWalletRepository {
    OwnerWallet createOwnerWallet(OwnerWallet ownerWallet);
    OwnerWallet updateOwnerWallet(OwnerWallet ownerWallet);
    OwnerWallet findOwnerWallet();
}
