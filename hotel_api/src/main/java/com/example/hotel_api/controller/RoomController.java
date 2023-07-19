package com.example.hotel_api.controller;

import com.example.hotel_api.entitiesDTO.RoomDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    public List<RoomDto> arrayList = new ArrayList<>();

    @GetMapping("/list")
    public List<RoomDto> get1() {
        return arrayList;
    }

    @GetMapping()
    public RoomDto get2(@RequestParam("id") String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new RoomDto();
    }
    @GetMapping("/room_name/")
    public List<RoomDto> get3(@RequestParam("id") String id) {
        List<RoomDto> outputData = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getRoom_name()))
                outputData.add(arrayList.get(i));
        }
        return outputData;
    }

    @GetMapping("/roomstatus")
    public List<RoomDto> get4(@RequestParam("status") boolean status) {
        List<RoomDto> outputData = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (status == arrayList.get(i).isStatus()){
                outputData.add(arrayList.get(i));
            }

        }
        return outputData;
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto room) {
        arrayList.add(room);
        return room;
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
