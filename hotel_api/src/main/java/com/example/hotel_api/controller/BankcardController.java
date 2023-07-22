package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Card;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bankcard")
public class BankcardController {
    public ArrayList<Card> arrayList = new ArrayList<>();

    @GetMapping("/list")
    public List<Card> get1() {
        return arrayList;
    }

    @GetMapping
    public Card get2(@RequestParam("id") String id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (id.equals(arrayList.get(i).getId()))
                return arrayList.get(i);
        }
        return new Card();
    }

    @PostMapping
    public Card create(@RequestBody Card bankcard) {
        arrayList.add(bankcard);
        return bankcard;
    }

    @DeleteMapping
    public void delete(@RequestParam("id") String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
