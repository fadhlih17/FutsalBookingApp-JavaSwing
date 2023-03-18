package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Item;
import org.example.repositories.ItemRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    private AppDbContext context;
    public ItemRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
    }
    public Item createItem(Item item){
        String query = "insert into item values id = '"+item.getId()+"', name = '"+item.getName()+"', total = "+item.getTotal()+", unit = '"+item.getUnit()+"'";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return item;
    }

    public boolean updateItem(Item item){
        String query = "update item set name = '"+item.getName()+"', total = '"+item.getTotal()+"', unit = '"+item.getUnit()+"'";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return true;
    }

    public List<Item> findAllItem(){
        String query = "select * from item";
        ResultSet resultSet = null;
        List<Item> items = new ArrayList<>();
        try{
            context.getStatement().executeQuery(query);
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int total = Integer.parseInt(resultSet.getString("total"));
                String unit = resultSet.getString("unit");
                items.add(new Item(id, name, unit, total));
            }
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return items;
    }

    public Item findItemByName(String name){
        String query = "select * from item where name = '"+name+"'";
        ResultSet resultSet = null;
        Item item = null;
        try{
            context.getStatement().executeQuery(query);
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String nameItem = resultSet.getString("name");
                int total = Integer.parseInt(resultSet.getString("total"));
                String unit = resultSet.getString("unit");
                item = new Item(id, nameItem, unit, total);
            }
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(resultSet, context.getStatement(), context.getConnection());
        }
        return item;
    }

    public boolean deleteItem(String name){
        String query = "delete from item wher name = '"+name+"'";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources(context.getResultSet(), context.getStatement(), context.getConnection());
        }
        return true;
    }
}
