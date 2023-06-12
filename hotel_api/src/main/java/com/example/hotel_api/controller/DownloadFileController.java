package com.example.hotel_api.controller;

import com.example.hotel_api.entities.ImageData;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/downloadfile")
public class DownloadFileController {
    public ArrayList<ImageData> arrayListImageData = new ArrayList<>();

    @GetMapping("/{id}")
    public ArrayList<ImageData> getImage1(@PathVariable String id) {
        int size = arrayListImageData.size();
        ArrayList<ImageData> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (id.equals(arrayListImageData.get(i).getId_khoa_ngoai())){
                array.add(arrayListImageData.get(i));
            }
        }
        return array;
    }

    @GetMapping()
    public ArrayList<ImageData> getImage2() {
        return arrayListImageData;
    }
}
