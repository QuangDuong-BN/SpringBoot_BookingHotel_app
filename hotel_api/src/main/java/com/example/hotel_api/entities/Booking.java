package com.example.hotel_api.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String id;
    private String customer_id;
    private String hotel_id;
    private String room_id;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private double price;

}
