package com.example.hotel_api.controller;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class ViewImageController {

    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        try {
            String imagePath = System.getProperty("user.dir") + "/Files-Upload/" + imageName;
            File imageFile = new File(imagePath);

            if (imageFile.exists()) {
                Resource resource = new FileSystemResource(imageFile);

                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

