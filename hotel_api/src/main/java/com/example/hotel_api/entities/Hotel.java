package com.example.hotel_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
    private String id;
    private String name;
    private Location location;
    private int start;
    private double vote;
    private int vote_total;


}
