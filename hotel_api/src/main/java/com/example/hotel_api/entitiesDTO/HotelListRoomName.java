package com.example.hotel_api.entitiesDTO;

import com.example.hotel_api.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelListRoomName {
    private String hotel_id;
    private List<String> room_number_list;
    private String room_name;
    private String room_number;
    private int number_bed;
    private int maximum_quantity;
    private double price;
    private boolean status;
    private String description;
    private List<String> listURL;
}
