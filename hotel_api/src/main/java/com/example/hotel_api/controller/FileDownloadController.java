package com.example.hotel_api.controller;

import com.example.hotel_api.entities.ImageData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/listpathimage")
public class FileDownloadController {
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
    // code lay file_path cua tat ca cac anh.
    @GetMapping()
    public ArrayList<ImageData> getImage2() {
        return arrayListImageData;
    }
}
