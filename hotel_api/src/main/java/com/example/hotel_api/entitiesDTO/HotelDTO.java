package com.example.hotel_api.entitiesDTO;

import com.example.hotel_api.entities.Location;
import com.example.hotel_api.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HotelDTO {
    private String id;
    private String name;
    private Location location;
    private double absPrice;
    private int start;
    private double vote;
    private int vote_total;
    private String description;
    private List<String> images;
    private List<RoomDTO> rooms;
}
