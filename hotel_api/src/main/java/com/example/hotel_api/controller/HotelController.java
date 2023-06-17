package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    public ArrayList<Hotel> arrayList = new ArrayList<>();

    @GetMapping()
    public ArrayList<Hotel> getHotel1() {
        return arrayList;
    }
    @GetMapping("/{id}")
    public ArrayList<Hotel> getHotel2(@PathVariable String id) {
        int size = arrayList.size();
        ArrayList<Hotel> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (id.equals(arrayList.get(i).getId())){
                array.add(arrayList.get(i));
            }
        }
        return array;
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        arrayList.add(hotel);
        return hotel;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }


}
