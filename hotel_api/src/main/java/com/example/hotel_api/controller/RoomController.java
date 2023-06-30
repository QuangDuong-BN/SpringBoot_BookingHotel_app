package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Room;
import com.example.hotel_api.entitiesDTO.RoomDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    public List<RoomDTO> arrayList = new ArrayList<>();

    @GetMapping
    public List<RoomDTO> get1() {
        return arrayList;
    }

    @GetMapping("/{id}")
    public RoomDTO get2(@PathVariable String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new RoomDTO();
    }
    @GetMapping("/room_name/{id}")
    public List<RoomDTO> get3(@PathVariable String id) {
        List<RoomDTO> outputData = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getRoom_name()))
                outputData.add(arrayList.get(i));
        }
        return outputData;
    }

    @PostMapping
    public RoomDTO create(@RequestBody RoomDTO room) {
        arrayList.add(room);
        return room;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
