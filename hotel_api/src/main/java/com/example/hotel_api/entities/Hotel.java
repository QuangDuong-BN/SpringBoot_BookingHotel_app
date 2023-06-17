package com.example.hotel_api.entities;

public class Hotel {
    private String id;
    private String name;
    private String address;
    private int start;
    private double vote;
    private int vote_total;

    public Hotel() {
    }

    public Hotel(String id, String name, String address, int start, double vote, int vote_total) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.start = start;
        this.vote = vote;
        this.vote_total = vote_total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public int getVote_total() {
        return vote_total;
    }

    public void setVote_total(int vote_total) {
        this.vote_total = vote_total;
    }
}
