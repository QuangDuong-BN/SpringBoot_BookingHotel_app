package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Card;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/bankcard")
public class BankcardController {
    public ArrayList<Card> arrayList = new ArrayList<>();

    @GetMapping
    public List<Card> get1() {
        return arrayList;
    }

    @GetMapping("/{id}")
    public Card get2(@PathVariable String id) {
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        arrayList.removeIf(arrayList -> arrayList.getId().equals(id));
    }
}
