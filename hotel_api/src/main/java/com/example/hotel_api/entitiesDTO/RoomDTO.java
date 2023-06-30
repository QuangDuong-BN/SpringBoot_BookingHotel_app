package com.example.hotel_api.entitiesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomDTO {
    private String id;
    private String hotel_id;
    private String room_number;
    private String room_name;
    private int number_bed;
    private int maximum_quantity;
    private double price;
    private boolean status;
    private String description;
    private List<String> listURL;
}
