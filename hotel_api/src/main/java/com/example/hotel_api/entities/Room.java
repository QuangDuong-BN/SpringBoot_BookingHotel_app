package com.example.hotel_api.entities;

public class Room {
    private String id;
    private String hotel_id;
    private int single_bed;
    private int double_bed;
    private int maximum_quantity;
    private double price;

    public Room(String id, String hotel_id, int single_bed, int double_bed, int maximum_quantity, double price) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.single_bed = single_bed;
        this.double_bed = double_bed;
        this.maximum_quantity = maximum_quantity;
        this.price = price;
    }

    public Room() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getSingle_bed() {
        return single_bed;
    }

    public void setSingle_bed(int single_bed) {
        this.single_bed = single_bed;
    }

    public int getDouble_bed() {
        return double_bed;
    }

    public void setDouble_bed(int double_bed) {
        this.double_bed = double_bed;
    }

    public int getMaximum_quantity() {
        return maximum_quantity;
    }

    public void setMaximum_quantity(int maximum_quantity) {
        this.maximum_quantity = maximum_quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
