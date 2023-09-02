package com.example.hotel_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Card {
    private String id;
    private String id_customer;
    private String card_number;
    private String name_customer;
    private java.sql.Date date_end;
    private String pin_code;
    private String bank_name;

}
