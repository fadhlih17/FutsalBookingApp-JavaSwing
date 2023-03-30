package org.example.models;

import java.sql.Time;
import java.util.Date;

public class Booking {
    private String id, userId, venueId;
    private Date dateOrder, dateBooked;
    private Time startTime, endTime;
    private long price;
    private boolean isConfirmed;
    private String imageUrl;

    public Booking() {
    }

    public Booking(String id, String userId, String venueId, Date dateOrder, Date dateBooked, Time startTime, Time endTime, long price, boolean isConfirmed, String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.venueId = venueId;
        this.dateOrder = dateOrder;
        this.dateBooked = dateBooked;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isConfirmed = isConfirmed;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
