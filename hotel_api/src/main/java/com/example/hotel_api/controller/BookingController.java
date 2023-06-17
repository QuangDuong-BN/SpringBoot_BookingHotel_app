package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    public ArrayList<Booking> arrayListBooking = new ArrayList<>();

    @GetMapping
    public List<Booking> get1() {
        return arrayListBooking;
    }

    @GetMapping("/{id}")
    public Booking get2(@PathVariable String id) {
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (id.equals(arrayListBooking.get(i).getId()))
                return arrayListBooking.get(i);
        }
        return new Booking();
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        arrayListBooking.add(booking);
        return booking;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayListBooking.removeIf(arrayListBooking -> arrayListBooking.getId().equals(id));
    }
}
