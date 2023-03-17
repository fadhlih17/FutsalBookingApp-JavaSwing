package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Admin;
import org.example.repositories.AdminRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AdminRepositoryImpl implements AdminRepository {
    private AppDbContext context;
    public AdminRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
    }

    public Admin createAdmin(Admin admin) {

        String query = "insert into admin values ('"+ admin.getId() +"', '"+ admin.getUsername()+"', '"+ admin.getPassword() +"')";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e.getMessage());
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return admin;
    }

    public Admin findAdminByUsername(String usernameInput){
        Admin admin = null;
        ResultSet resultSet = null;
        try{
            String query = "select * from admin where username = '"+usernameInput+"'";
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                admin = new Admin(id, username, password);
            }
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e.getMessage());
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return admin;
    }
}
