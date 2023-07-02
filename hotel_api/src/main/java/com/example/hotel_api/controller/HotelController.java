package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Hotel;
import com.example.hotel_api.entitiesDTO.CustomerDTO;
import com.example.hotel_api.entitiesDTO.HotelDTO;
import com.example.hotel_api.entitiesDTO.HotelListRoomName;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    public ArrayList<HotelDTO> arrayList = new ArrayList<>();

    @GetMapping()
    public List<HotelDTO> getHotel1() {
        return arrayList;
    }

    @GetMapping("/{id}")
    public HotelDTO getHotel2(@PathVariable String id) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (id.equals(arrayList.get(i).getId())) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    @PostMapping
    public HotelDTO create(@RequestBody HotelDTO hotel) {
        arrayList.add(hotel);
        return hotel;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }


}
