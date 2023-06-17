package com.example.hotel_api.entities;
import java.sql.Date;
public class Booking {
    private String id;
    private String customer_id;
    private String hotel_id;
    private String room_id;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private double price;

    public Booking(String id, String customer_id, String hotel_id, String room_id, Date start_date, Date end_date, double price) {
        this.id = id;
        this.customer_id = customer_id;
        this.hotel_id = hotel_id;
        this.room_id = room_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
    }

    public Booking() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
