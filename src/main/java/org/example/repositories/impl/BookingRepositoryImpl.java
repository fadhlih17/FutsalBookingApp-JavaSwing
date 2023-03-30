package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Booking;
import org.example.repositories.BookingRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private AppDbContext context;
    public BookingRepositoryImpl(AppDbContext context) {
        this.context = context;
    }
    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e.getMessage());
    }

    public Booking createBooking(Booking book){
        String query = "insert into bookings values ('"+book.getId()+"', '"+book.getUserId()+"', '"+book.getVenueId()+"', '"+book.getDateOrder()+"', " +
                "'"+book.getDateBooked()+"', '"+book.getStartTime()+"', '"+book.getEndTime()+"', "+book.getPrice()+", " +
                ""+book.isConfirmed()+", '"+book.getImageUrl()+"')";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return book;
    }

    public Booking findBookingTransaction(String venueId, Date dateBooking, Time startTime, Time endTime){
        String query = "select * from Booking where venue_id = '"+venueId+"' and dateBooked = '"+dateBooking+"' and ((start_time >= '"+startTime+"' and end_time < '"+endTime+"')" +
                "or (start_time > '"+startTime+"' and end_time <= '"+endTime+"'))";
        Booking book = new Booking();
        ResultSet resultSet = null;
        try{
            resultSet = context.getStatement().executeQuery(query);
            while (resultSet.next()){
                book.setId(resultSet.getString("id"));
                book.setUserId(resultSet.getString("user_id"));
                book.setVenueId(resultSet.getString("venue_id"));
                book.setDateOrder(resultSet.getDate("dateOrder"));
                book.setDateBooked(resultSet.getDate("dateBooked"));
                book.setStartTime(resultSet.getTime("start_time"));
                book.setEndTime(resultSet.getTime("end_time"));
                book.setPrice(resultSet.getLong("price"));
                book.setConfirmed(resultSet.getBoolean("isConfirmed"));
                book.setImageUrl(resultSet.getString("image"));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return book;
    }

    public List<Booking> findAllBooking(){
        String query = "select * from booking";
        ResultSet resultSet = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            resultSet = context.getStatement().executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userId = resultSet.getString("user_id");
                String venueId = resultSet.getString("venue_id");
                Date dateOrder = resultSet.getDate("dateOrder");
                Date dateBooked = resultSet.getDate("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                Long price = resultSet.getLong("price");
                boolean isConfirmed = resultSet.getBoolean("isConfirmed");
                String imageUrl = resultSet.getString("image");
                bookings.add(new Booking(id, userId, venueId, dateOrder, dateBooked, startTime, endTime, price, isConfirmed, imageUrl));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return bookings;
    }

    public List<Booking> findAllBookingByUserId(String userIdReq){
        String query = "select * from booking where user_id = '"+userIdReq+"'";
        ResultSet resultSet = null;
        List<Booking> bookings = new ArrayList<>();
        try {
            resultSet = context.getStatement().executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userId = resultSet.getString("user_id");
                String venueId = resultSet.getString("venue_id");
                Date dateOrder = resultSet.getDate("dateOrder");
                Date dateBooked = resultSet.getDate("dateBooked");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                Long price = resultSet.getLong("price");
                boolean isConfirmed = resultSet.getBoolean("isConfirmed");
                String imageUrl = resultSet.getString("image");
                bookings.add(new Booking(id, userId, venueId, dateOrder, dateBooked, startTime, endTime, price, isConfirmed, imageUrl));
            }
        } catch (Exception e){
            error(e);
        } finally{
            context.closeResources();
        }
        return bookings;
    }

}
