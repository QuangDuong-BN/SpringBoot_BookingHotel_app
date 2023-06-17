package com.example.hotel_api.entities;
import java.sql.Date;
public class Bankcard {
    private String id;
    private String id_customer;
    private java.sql.Date date_end;
    private String cvv;
    private String name_customer;
    private String card_number;

    public Bankcard() {
    }

    public Bankcard(String id, String id_customer, Date date_end, String cvv, String name_customer, String card_number) {
        this.id = id;
        this.id_customer = id_customer;
        this.date_end = date_end;
        this.cvv = cvv;
        this.name_customer = name_customer;
        this.card_number = card_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
