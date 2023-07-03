package com.example.hotel_api;

import com.example.hotel_api.controller.*;
import com.example.hotel_api.entities.*;
import com.example.hotel_api.entitiesDTO.BookingDTO;
import com.example.hotel_api.entitiesDTO.CustomerDTO;
import com.example.hotel_api.entitiesDTO.HotelDTO;
import com.example.hotel_api.entitiesDTO.RoomDTO;
import com.example.hotel_api.staticmethod.ConvertoBase64;
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

        BankcardController bankcardController = context.getBean(BankcardController.class);

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

        roomController.arrayList.add(new RoomDTO("1", "ks01", "P124", "Executive", 1, 3, (double) 5000000, false, des, listUrl));
        roomController.arrayList.add(new RoomDTO("2", "ks01", "P125", "Executive", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("3", "ks01", "P126", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDTO("4", "ks01", "P127", "DoubleRoom", 1, 2, 500000, false, des, listUrl));
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

        List<RoomDTO> list_room_ks01 = new ArrayList<>();
        List<String> listimageRoom1 = new ArrayList<>();
        listimageRoom1.add(ConvertoBase64.convertoBase64_method("room1.jpg"));
        listimageRoom1.add(ConvertoBase64.convertoBase64_method("room2.jpg"));
        list_room_ks01.add(new RoomDTO("1", "ks01", "P124", "Executive", 1, 3, (double) 5000000, false, des, listimageRoom1));
        List<String> listimageRoom2 = new ArrayList<>();
        listimageRoom2.add(ConvertoBase64.convertoBase64_method("room3.jpg"));
        listimageRoom2.add(ConvertoBase64.convertoBase64_method("room4.jpg"));
        list_room_ks01.add(new RoomDTO("2", "ks01", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        List<String> listimageRoom3 = new ArrayList<>();
        listimageRoom3.add(ConvertoBase64.convertoBase64_method("room5.jpg"));
        listimageRoom3.add(ConvertoBase64.convertoBase64_method("room6.jpg"));
        list_room_ks01.add(new RoomDTO("3", "ks01", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        List<String> listimageRoom4 = new ArrayList<>();
        listimageRoom4.add(ConvertoBase64.convertoBase64_method("room7.jpg"));
        listimageRoom4.add(ConvertoBase64.convertoBase64_method("room8.jpg"));
        list_room_ks01.add(new RoomDTO("4", "ks01", "P127", "DoubleRoom", 1, 2, 500000, false, des, listimageRoom4));
        List<String> listimageRoom5 = new ArrayList<>();
        listimageRoom5.add(ConvertoBase64.convertoBase64_method("room9.jpg"));
        listimageRoom5.add(ConvertoBase64.convertoBase64_method("room10.jpg"));
        list_room_ks01.add(new RoomDTO("5", "ks01", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));


        List<RoomDTO> list_room_ks02 = new ArrayList<>();
        list_room_ks02.add(new RoomDTO("6", "ks02", "P124", "Executive", 1, 3, (double) 5000000, true, des, listimageRoom1));
        list_room_ks02.add(new RoomDTO("7", "ks02", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        list_room_ks02.add(new RoomDTO("8", "ks02", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        list_room_ks02.add(new RoomDTO("9", "ks02", "P127", "SingleRoom", 1, 1, 500000, true, des, listimageRoom4));
        list_room_ks02.add(new RoomDTO("10", "ks02", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));

        List<RoomDTO> list_room_ks03 = new ArrayList<>();
        list_room_ks03.add(new RoomDTO("10", "ks03", "P124", "Executive", 1, 3, (double) 5000000, true, des, listimageRoom1));
        list_room_ks03.add(new RoomDTO("11", "ks03", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        list_room_ks03.add(new RoomDTO("12", "ks03", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        list_room_ks03.add(new RoomDTO("13", "ks03", "P127", "SingleRoom", 1, 1, 500000, true, des, listimageRoom4));
        list_room_ks03.add(new RoomDTO("14", "ks03", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));

        List<RoomDTO> list_room_ks04 = new ArrayList<>();
        String des1 = "Khách sạn XXX là một điểm đến tuyệt vời cho du khách muốn tận hưởng sự tiện nghi và không gian sang trọng. // Với nội thất hiện đại và phòng ngủ rộng rãi, khách sạn XYZ đảm bảo bạn có một trải nghiệm lưu trú thoải mái và tiện nghi.";
        String des2 = "Khách sạn XXX nằm trong khu vực trung tâm, mang đến sự thuận tiện cho việc khám phá các điểm tham quan, nhà hàng và cửa hàng mua sắm. // Đội ngũ nhân viên thân thiện và chuyên nghiệp tại khách sạn XXX sẽ đảm bảo bạn nhận được dịch vụ tận tâm và hài lòng";
        String des3 = "Khách sạn XXX cam kết mang đến sự hài lòng và trải nghiệm lưu trú đáng nhớ cho du khách, với dịch vụ chất lượng và không gian ấm cúng. // Với không gian nghỉ ngơi thoải mái và view đẹp, khách sạn XXX là nơi lý tưởng để thưởng thức không gian yên tĩnh và tận hưởng không khí thư giãn.";


        List<String> listImageHotel1=new ArrayList<>();
        listImageHotel1.add(ConvertoBase64.convertoBase64_method("h4.jpg"));
        listImageHotel1.add(ConvertoBase64.convertoBase64_method("h5.jpg"));

        List<String> listImageHotel2=new ArrayList<>();
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h6.jpg"));
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h7.jpg"));

        List<String> listImageHotel3=new ArrayList<>();
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h1.jpg"));
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h2.jpg"));

        hotelController.arrayListHotel.add(new HotelDTO("ks01", "SMARANA Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 95 đường 16"), 500000, 5, 8.0, 50, des1, listImageHotel1, list_room_ks01));
        hotelController.arrayListHotel.add(new HotelDTO("ks02", "Pullman Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 9 đường 16"), 500000, 5, 8.0, 50, des2, listImageHotel2, list_room_ks02));
        hotelController.arrayListHotel.add(new HotelDTO("ks03", "Alula Sweet Home", new Location("Hà Nội", "Hoàn Kiếm", "Số 97 đường 16"), 500000, 5, 8.0, 50, des3, listImageHotel3, list_room_ks03));
        hotelController.arrayListHotel.add(new HotelDTO("ks04", "Melia Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 10 đường 16"), 500000, 5, 8.0, 50, des2, listImageHotel2, list_room_ks01));
        hotelController.arrayListHotel.add(new HotelDTO("ks05", "Mường Thanh", new Location("Hà Nội", "Hoàn Kiếm", "Số 5 đường 16"), 500000, 5, 8.0, 50, des3, listImageHotel3, list_room_ks02));


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
        bookingController.arrayListBooking.add(new BookingDTO("1", "952", "Dương", "0344381904", "123", "975", "Executive", "987", date1, date2, 3000000));

        date1 = java.sql.Date.valueOf("2023-06-19");
        date2 = java.sql.Date.valueOf("2023-06-22");
        bookingController.arrayListBooking.add(new BookingDTO("2", "258", "Huyền", "0944381904", "524", "852", "SingleRoom", "654", date1, date2, 4000000));

        date1 = java.sql.Date.valueOf("2023-01-19");
        date2 = java.sql.Date.valueOf("2023-01-23");
        bookingController.arrayListBooking.add(new BookingDTO("3", "456", "Hoàn", "0944381904", "265", "654", "SingleRoom", "357", date1, date2, 5000000));

        date1 = java.sql.Date.valueOf("2023-01-19");
        date2 = java.sql.Date.valueOf("2023-01-23");
        bookingController.arrayListBooking.add(new BookingDTO("4", "987", "Hải", "0944399904", "789", "456", "DoubleRoom", "987", date1, date2, 5000000));

        date1 = java.sql.Date.valueOf("2023-01-10");
        date2 = java.sql.Date.valueOf("2023-01-10");
        bookingController.arrayListBooking.add(new BookingDTO("5", "123", "Duy", "787894488", "654", "654", "Executive", "147", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-02-10");
        date2 = java.sql.Date.valueOf("2023-02-20");
        bookingController.arrayListBooking.add(new BookingDTO("6", "252", "Minh", "0943581904", "753", "464648", "SingleRoom", "369", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-03-10");
        date2 = java.sql.Date.valueOf("2023-03-20");
        bookingController.arrayListBooking.add(new BookingDTO("7", "654", "Huyen", "7414381904", "654", "155651", "DoubleRoom", "258", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-03-10");
        date2 = java.sql.Date.valueOf("2023-03-21");
        bookingController.arrayListBooking.add(new BookingDTO("8", "753", "Huyen", "3694381904", "123", "151561", "Executive", "654", date1, date2, 12000000));

        date1 = java.sql.Date.valueOf("2023-03-01");
        date2 = java.sql.Date.valueOf("2023-03-11");
        bookingController.arrayListBooking.add(new BookingDTO("9", "654", "Huyen", "0966681904", "852", "789774", "DoubleRoom", "357", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-04-10");
        date2 = java.sql.Date.valueOf("2023-04-20");
        bookingController.arrayListBooking.add(new BookingDTO("10", "147", "Huyen", "099381904", "125", "18511", "SingleRoom", "159", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-05-10");
        date2 = java.sql.Date.valueOf("2023-05-20");
        bookingController.arrayListBooking.add(new BookingDTO("11", "987", "Huyen", "0944381904", "951", "15111", "DoubleRoom", "753", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-05-01");
        date2 = java.sql.Date.valueOf("2023-05-09");
        bookingController.arrayListBooking.add(new BookingDTO("12", "456", "Huyen", "0944381904", "753", "12561", "SingleRoom", "852", date1, date2, 9000000));


        date1 = java.sql.Date.valueOf("2023-06-10");
        date2 = java.sql.Date.valueOf("2023-06-17");
        bookingController.arrayListBooking.add(new BookingDTO("13", "357", "Huyen", "0944381904", "654", "4", "DoubleRoom", "P127", date1, date2, 8000000));

        date1 = java.sql.Date.valueOf("2023-06-01");
        date2 = java.sql.Date.valueOf("2023-06-09");
        bookingController.arrayListBooking.add(new BookingDTO("14", "852", "Huyen", "0944381904", "852", "4", "DoubleRoom", "P127", date1, date2, 9000000));

        date1 = java.sql.Date.valueOf("2023-06-01");
        date2 = java.sql.Date.valueOf("2023-06-09");
        bookingController.arrayListBooking.add(new BookingDTO("15", "654", "Huyen", "0944381904", "654", "4", "DoubleRoom", "P127", date1, date2, 9000000));

        date1 = java.sql.Date.valueOf("2023-06-01");
        date2 = java.sql.Date.valueOf("2023-06-09");
        bookingController.arrayListBooking.add(new BookingDTO("16", "123", "Huyen", "0944381904", "475", "4", "DoubleRoom", "P127", date1, date2, 9000000));

        date1 = java.sql.Date.valueOf("2023-07-01");
        date2 = java.sql.Date.valueOf("2023-07-09");
        bookingController.arrayListBooking.add(new BookingDTO("17", "654", "Huyen", "0944381904", "ks01", "4", "DoubleRoom", "P127", date1, date2, 9000000));


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
