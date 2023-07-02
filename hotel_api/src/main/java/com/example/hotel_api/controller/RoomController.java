package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Room;
import com.example.hotel_api.entitiesDTO.RoomDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    public List<RoomDTO> arrayList = new ArrayList<>();

    @GetMapping("/list")
    public List<RoomDTO> get1() {
        return arrayList;
    }

    @GetMapping()
    public RoomDTO get2(@RequestParam("id") String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new RoomDTO();
    }
    @GetMapping("/room_name/")
    public List<RoomDTO> get3(@RequestParam("id") String id) {
        List<RoomDTO> outputData = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getRoom_name()))
                outputData.add(arrayList.get(i));
        }
        return outputData;
    }

    @GetMapping("/roomstatus")
    public List<RoomDTO> get4(@RequestParam("status") boolean status) {
        List<RoomDTO> outputData = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (status == arrayList.get(i).isStatus()){
                outputData.add(arrayList.get(i));
            }

        }
        return outputData;
    }

    @PostMapping
    public RoomDTO create(@RequestBody RoomDTO room) {
        arrayList.add(room);
        return room;
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
