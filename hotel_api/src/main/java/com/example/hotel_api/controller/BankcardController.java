package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Bankcard;
import com.example.hotel_api.entities.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/bankcard")
public class BankcardController {
    public ArrayList<Bankcard> arrayList = new ArrayList<>();

    @GetMapping
    public List<Bankcard> get1() {
        return arrayList;
    }

    @GetMapping("/{id}")
    public Bankcard get2(@PathVariable String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new Bankcard();
    }

    @PostMapping
    public Bankcard create(@RequestBody Bankcard bankcard) {
        arrayList.add(bankcard);
        return bankcard;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
