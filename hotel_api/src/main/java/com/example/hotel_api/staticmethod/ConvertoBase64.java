package com.example.hotel_api.staticmethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class ConvertoBase64 {
    public static String convertoBase64_method(String name_image) {
        String imagePath1 = System.getProperty("user.dir") + "/Files-Upload/" + name_image;
        File file1 = new File(imagePath1);
        byte[] fileBytes1 = new byte[(int) file1.length()];

        try (FileInputStream fis1 = new FileInputStream(file1)) {
            fis1.read(fileBytes1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String base64Image1 = Base64.getEncoder().encodeToString(fileBytes1);
        return base64Image1;
    }
}
