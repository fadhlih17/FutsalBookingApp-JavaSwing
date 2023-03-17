package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.exceptions.ErrorException;
import org.example.models.UserWallet;
import org.example.repositories.UserWalletRepository;

import javax.swing.*;
import java.math.BigInteger;
import java.sql.ResultSet;

public class UserWalletRepositoryImpl implements UserWalletRepository {
    private AppDbContext context;

    public UserWalletRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    public UserWallet createUserWallet(UserWallet userWallet){
        String query = "insert into user_wallet values ('"+ userWallet.getId() +"', '"+ userWallet.getBalance() +"', '"+ userWallet.getUserId() +"')";
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
        return userWallet;
    }

    public UserWallet updateUserWallet(UserWallet userWallet){
        String query = "update user_wallet set balance = "+userWallet.getBalance()+" where user_id = '"+userWallet.getUserId()+"'";
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
        return userWallet;
    }

    public UserWallet findUserWalletByUserId(String userId){
        String query = "select * from user_wallet where user_id = '"+userId+"'";
        ResultSet resultSet = null;
        UserWallet wallet = null;
        try{
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                long balance = Long.parseLong(resultSet.getString("balance"));
                String userId1 = resultSet.getString("user_id");
                wallet = new UserWallet(id, userId1, balance);
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
        return wallet;
    }
}
