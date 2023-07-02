package com.example.hotel_api;

import com.example.hotel_api.controller.*;
import com.example.hotel_api.entities.*;
import com.example.hotel_api.entitiesDTO.BookingDTO;
import com.example.hotel_api.entitiesDTO.CustomerDTO;
import com.example.hotel_api.entitiesDTO.HotelDTO;
import com.example.hotel_api.entitiesDTO.RoomDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;


@SpringBootApplication()
public class HotelApiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HotelApiApplication.class, args);

        HotelController hotelController = context.getBean(HotelController.class);

        // setup room
        RoomController roomController = context.getBean(RoomController.class);
        String des = "Phòng Có Giường Cỡ King này được trang trí theo phong cách hiện đại với tầm nhìn ra quang cảnh thành phố. Có TV màn hình phẳng 32 inch và minibar. Phòng tắm riêng được trang bị bồn tắm và nắp rửa điện tử tiên tiến.";
        List<String> listUrl = new ArrayList<>();
        listUrl.add("room1.jpg");
        listUrl.add("room2.jpg");
        listUrl.add("room3.jpg");
        listUrl.add("room4.jpg");
        listUrl.add("room5.jpg");
        listUrl.add("room6.jpg");
        listUrl.add("room7.jpg");

        roomController.arrayList.add(new RoomDTO("1", "ks01", "P124", "Executive", 1, 3, (double) 5000000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("2", "ks01", "P125", "Executive", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("3", "ks01", "P126", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("4", "ks01", "P127", "DoubleRoom", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("5", "ks01", "P129", "DoubleRoom", 1, 2, 500000, true, des, listUrl));

        roomController.arrayList.add(new RoomDTO("6", "ks02", "P124", "Executive", 1, 3, (double) 5000000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("7", "ks02", "P125", "Executive", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("8", "ks02", "P126", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("9", "ks02", "P127", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("10", "ks02", "P129", "DoubleRoom", 1, 2, 500000, true, des, listUrl));

        List<String> listImageHotel = new ArrayList<>();

        String imagePath1 = System.getProperty("user.dir") + "/Files-Upload/" + "h1.jpg";
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


        String imagePath2 = System.getProperty("user.dir") + "/Files-Upload/" + "h2.jpg";
        File file2 = new File(imagePath2);
        byte[] fileBytes2 = new byte[(int) file2.length()];

        try (FileInputStream fis2 = new FileInputStream(file2)) {
            fis2.read(fileBytes2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String base64Image2 = Base64.getEncoder().encodeToString(fileBytes2);


        String imagePath3 = System.getProperty("user.dir") + "/Files-Upload/" + "h3.jpg";
        File file3 = new File(imagePath3);
        byte[] fileBytes3 = new byte[(int) file3.length()];

        try (FileInputStream fis3 = new FileInputStream(file3)) {
            fis3.read(fileBytes3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String base64Image3 = Base64.getEncoder().encodeToString(fileBytes3);
        listImageHotel.add(base64Image1);
        listImageHotel.add(base64Image2);
        listImageHotel.add(base64Image3);

        hotelController.arrayList.add(new HotelDTO("ks01", "SMARANA Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 95 đường 16"), 5, 8.0, 50, listImageHotel, roomController.arrayList));
        hotelController.arrayList.add(new HotelDTO("ks02", "Pullman Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 9 đường 16"), 5, 8.0, 50, listImageHotel, roomController.arrayList));
        hotelController.arrayList.add(new HotelDTO("ks03", "Alula Sweet Home", new Location("Hà Nội", "Hoàn Kiếm", "Số 97 đường 16"), 5, 8.0, 50, listImageHotel, roomController.arrayList));
        hotelController.arrayList.add(new HotelDTO("ks04", "Melia Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 10 đường 16"), 5, 8.0, 50, listImageHotel, roomController.arrayList));
        hotelController.arrayList.add(new HotelDTO("ks05", "Mường Thanh", new Location("Hà Nội", "Hoàn Kiếm", "Số 5 đường 16"), 5, 8.0, 50, listImageHotel, roomController.arrayList));


        CustomerController customerController = context.getBean(CustomerController.class);
        List<Card> listCard = new ArrayList<>();
        listCard.add(new Card("1", "kh1", "9982415569", "Duong", java.sql.Date.valueOf("2023-06-19"), "993", "MB Bank"));

        customerController.arrayListCustomer.add(new CustomerDTO("kh1", "Duong", "duong@gmail.com", "0344381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDTO("kh2", "Huyen", "sss@gmail.com", "0944381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDTO("kh3", "Hai", "aaaaa@gmail.com", "0844381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDTO("kh4", "Hoan", "ddd@gmail.com", "0744381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDTO("kh5", "Tu", "duorrrng@gmail.com", "0644381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDTO("kh6", "Lien", "wwwww@gmail.com", "0544381904", "111111", listCard));


        BookingController bookingController = context.getBean(BookingController.class);
        java.sql.Date date1 = java.sql.Date.valueOf("2023-06-15");
        java.sql.Date date2 = java.sql.Date.valueOf("2023-06-20");
        bookingController.arrayListBooking.add(new BookingDTO("1", "kh1","Duong","0344381904", "ks01", "1","Executive", date1, date2, 3000000));

        date1 = java.sql.Date.valueOf("2023-06-19");
        date2 = java.sql.Date.valueOf("2023-06-22");
        bookingController.arrayListBooking.add(new BookingDTO("2","kh2","Huyen","0944381904","ks01" , "4", "DoubleRoom", date1, date2, 4000000));


        FileDownloadController downloadFileController = context.getBean(FileDownloadController.class);
        downloadFileController.arrayListImageData.add(new ImageData("1", "ks01", "h1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("5", "ks01", "h2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "ks01", "h3.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("1", "ks02", "h1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("5", "ks02", "h2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "ks02", "h3.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("1", "ks03", "h1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("5", "ks03", "h2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "ks03", "h3.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("1", "ks04", "h1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("5", "ks04", "h2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "ks04", "h3.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("1", "ks05", "h1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("5", "ks05", "h2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "ks05", "h3.jpg"));


        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room3.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room4.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room5.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room6.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "1", "room7.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room3.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room4.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room5.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room6.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "2", "room7.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room1.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room2.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room3.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room4.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room5.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room6.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "3", "room7.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("6", "4", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "4", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "4", "room7.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("6", "5", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "5", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "5", "room7.jpg"));

        downloadFileController.arrayListImageData.add(new ImageData("6", "6", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "6", "room7.jpg"));
        downloadFileController.arrayListImageData.add(new ImageData("6", "6", "room7.jpg"));


    }

}
