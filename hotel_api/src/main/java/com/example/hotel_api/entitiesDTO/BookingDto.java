package com.example.hotel_api.entitiesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDto {
    private String id;
    private String customer_id;
    private String customer_name;
    private String customer_phone;
    private String hotel_id;
    private String room_id;
    private String room_name;
    private String room_number;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private double price;
}