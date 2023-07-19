package com.example.hotel_api.controller;

import com.example.hotel_api.entitiesDTO.HotelDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    public static ArrayList<HotelDto> arrayListHotel = new ArrayList<>();

    @GetMapping("/list")
    public List<HotelDto> getHotel1() {
        return arrayListHotel;
    }

    @GetMapping("/listnamehotel")
    public List<String> getNameHotel() {
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < arrayListHotel.size(); i++) {
            listName.add(arrayListHotel.get(i).getName());
        }
        return listName;
    }

    @GetMapping("/listidhotel")
    public List<String> getIdHotel() {
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < arrayListHotel.size(); i++) {
            listName.add(arrayListHotel.get(i).getId());
        }
        return listName;
    }

    @GetMapping()
    public HotelDto getHotel2(@RequestParam("id") String id) {
        int size = arrayListHotel.size();
        for (int i = 0; i < size; i++) {
            if (id.equals(arrayListHotel.get(i).getId())) {
                return arrayListHotel.get(i);
            }
        }
        return null;
    }

    @GetMapping("/namehotel")
    public String getNameHotel(@RequestParam("id") String id) {
        int size = arrayListHotel.size();
        for (int i = 0; i < size; i++) {
            if (id.equals(arrayListHotel.get(i).getId())) {
                return arrayListHotel.get(i).getName();
            }
        }
        return null;
    }

    @PostMapping
    public HotelDto create(@RequestBody HotelDto hotel) {
        arrayListHotel.add(hotel);
        return hotel;
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") String id) {
        arrayListHotel.removeIf(arrayList -> arrayList.getId().equals(id));
    }


}
