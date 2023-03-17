package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;
import org.example.models.OwnerWallet;
import org.example.models.OwnerWallet;
import org.example.models.OwnerWallet;
import org.example.repositories.OwnerWalletRepository;

import java.sql.ResultSet;

public class OwnerWalletRepositoryImpl implements OwnerWalletRepository {
    private AppDbContext context;
    public OwnerWalletRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    public OwnerWallet createOwnerWallet(OwnerWallet ownerWallet){
        String query = "insert into owner_wallet values ('"+ ownerWallet.getId() +"', '"+ ownerWallet.getBalance() +"')";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            try {
                throw new ErrorException(e.getMessage());
            } catch (ErrorException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return ownerWallet;
    }

    public OwnerWallet updateOwnerWallet(OwnerWallet ownerWallet){
        String query = "update owner_wallet set balance = "+ownerWallet.getBalance();
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            try {
                throw new ErrorException(e.getMessage());
            } catch (ErrorException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return ownerWallet;
    }

    public OwnerWallet findOwnerWallet(){
        String query = "select * from owner_wallet";
        ResultSet resultSet = null;
        OwnerWallet ownerWallet = null;
        try{
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                long balance = Long.parseLong(resultSet.getString("balance"));
                ownerWallet = new OwnerWallet(id, balance);
            }
        } catch (Exception e){
            try {
                throw new ErrorException(e.getMessage());
            } catch (ErrorException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return ownerWallet;
    }
}
