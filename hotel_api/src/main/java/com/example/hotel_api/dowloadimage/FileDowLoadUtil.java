package com.example.hotel_api.dowloadimage;

import org.springframework.core.io.Resource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDowLoadUtil {
    private Path foundFile;
    /*public Resource getFileAsResource(String fileCode) throws IOException {
        Path uploadDirectory= Paths.get("File-Upload");
        Files.list(uploadDirectory).forEach(file ->{
           if(file.getFileName().toString().startsWith(fileCode)){
               foundFile=file;
               return;
           }

        });
    }*/
}
