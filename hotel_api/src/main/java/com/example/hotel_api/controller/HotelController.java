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

    @GetMapping("/list")
    public List<HotelDTO> getHotel1() {
        return arrayList;
    }

    @GetMapping("/listnamehotel")
    public List<String> getNameHotel() {
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            listName.add(arrayList.get(i).getName());
        }
        return listName;
    }

    @GetMapping()
    public HotelDTO getHotel2(@RequestParam("id") String id) {
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

    @DeleteMapping()
    public void delete(@RequestParam("id") String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }


}
