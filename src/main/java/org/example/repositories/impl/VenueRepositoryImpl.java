package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.dtos.ECategory;
import org.example.models.Venue;
import org.example.repositories.VenueRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class VenueRepositoryImpl implements VenueRepository {
    private AppDbContext context;
    public VenueRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e.getMessage());
    }

    public Venue createVenue(Venue venue) {
        String query = "insert into venue values ('"+venue.getId()+"', '"+venue.getName()+"', '"+venue.getDescription()+"', " +
                "'"+venue.getOpen()+"', '"+venue.getClose()+"', "+venue.getPrice()+", '"+venue.getCategory()+"', "+venue.isActive()+")";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            context.closeResources();
        }
        return venue;
    }

    public List<Venue> findAllVenue(){
        ResultSet resultSet = null;
        List<Venue> venues = new ArrayList<>();
        String query = "select * from venue";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category");
                ECategory category = ECategory.valueOf(categoryString);
                boolean isActive = resultSet.getBoolean("isActive");
                venues.add(new Venue(id, name, description, open, close, price, category, isActive));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return venues;
    }

    public boolean updateVenue(Venue venue){
        String query = "update venue set name = '"+venue.getName()+"', description = '"+venue.getDescription()+"', open = '"+venue.getOpen()+"', " +
                "close = '"+venue.getClose()+"', price = "+venue.getPrice()+", category = '"+venue.getCategory()+"', isActive = "+venue.isActive()+" where id = '"+venue.getId()+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch(Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return true;
    }

    public Venue findVenueById(String venueId){
        ResultSet resultSet = null;
        Venue venue = null;
        String query = "select * from venue where id = '"+venueId+"'";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category");
                ECategory category = ECategory.valueOf(categoryString);
                boolean isActive = resultSet.getBoolean("isActive");
                venue = new Venue(id, name, description, open, close, price, category, isActive);
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return venue;
    }

    public List<Venue> findVenueByCategory(ECategory categorySearch){
        ResultSet resultSet = null;
        List<Venue> venues = new ArrayList<>();
        String query = "select * from venue where category = '"+categorySearch+"'";
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Time open = resultSet.getTime("open");
                Time close = resultSet.getTime("close");
                Long price = resultSet.getLong("price");
                String categoryString = resultSet.getString("category");
                ECategory category = ECategory.valueOf(categoryString);
                boolean isActive = resultSet.getBoolean("isActive");
                venues.add(new Venue(id, name, description, open, close, price, category, isActive));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return venues;
    }


}
