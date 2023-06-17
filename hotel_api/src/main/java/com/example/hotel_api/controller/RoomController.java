package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Room;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    public ArrayList<Room> arrayList = new ArrayList<>();

    @GetMapping
    public List<Room> get1() {
        return arrayList;
    }

    @GetMapping("/{id}")
    public Room get2(@PathVariable String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new Room();
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        arrayList.add(room);
        return room;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
