package com.example.hotel_api;

import com.example.hotel_api.controller.*;
import com.example.hotel_api.entities.Card;
import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entities.Location;
import com.example.hotel_api.entitiesDTO.BookingDto;
import com.example.hotel_api.entitiesDTO.CustomerDto;
import com.example.hotel_api.entitiesDTO.HotelDto;
import com.example.hotel_api.entitiesDTO.RoomDto;
import com.example.hotel_api.service.CustomerService;
import com.example.hotel_api.staticmethod.ConvertoBase64;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@SpringBootApplication()
@OpenAPIDefinition(
        info = @Info(
                title = "API app hotel",
                version = "1.0.0",
                description = "Api sử dụng trong app khách sạn.",
                contact = @Contact(
                        name = "QuangDuong",
                        email = "quangduong19992001@gmail.com"
                ),
                license = @License(
                        name = "Link: license ",
                        url = "https://www.youtube.com/watch?v=m1M1V9hdL3c"
                )
        )
)
public class HotelApiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HotelApiApplication.class, args);

        //
        System.out.println("ket quan truy van:");
        CustomerService customerService = context.getBean(CustomerService.class);
        Customer customer = customerService.getUserById((long) 1);
        System.out.println(customer.toString());

        System.out.println("ket quan truy van:");
        System.out.println(customer.toString());


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

        roomController.arrayList.add(new RoomDto("1", "ks01", "P124", "Executive", 1, 3, (double) 5000000, false, des, listUrl));
        roomController.arrayList.add(new RoomDto("2", "ks01", "P125", "Executive", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("3", "ks01", "P126", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("4", "ks01", "P127", "DoubleRoom", 1, 2, 500000, false, des, listUrl));
        roomController.arrayList.add(new RoomDto("5", "ks01", "P129", "DoubleRoom", 1, 2, 500000, true, des, listUrl));

        roomController.arrayList.add(new RoomDto("6", "ks02", "P124", "Executive", 1, 3, (double) 5000000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("7", "ks02", "P125", "Executive", 1, 2, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("8", "ks02", "P126", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("9", "ks02", "P127", "SingleRoom", 1, 1, 500000, true, des, listUrl));
        roomController.arrayList.add(new RoomDto("10", "ks02", "P129", "DoubleRoom", 1, 2, 500000, true, des, listUrl));

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

        List<RoomDto> list_room_ks01 = new ArrayList<>();
        List<String> listimageRoom1 = new ArrayList<>();
        listimageRoom1.add(ConvertoBase64.convertoBase64_method("room1.jpg"));
        listimageRoom1.add(ConvertoBase64.convertoBase64_method("room2.jpg"));
        list_room_ks01.add(new RoomDto("1", "123852", "P124", "Executive", 1, 3, (double) 5000000, false, des, listimageRoom1));
        List<String> listimageRoom2 = new ArrayList<>();
        listimageRoom2.add(ConvertoBase64.convertoBase64_method("room3.jpg"));
        listimageRoom2.add(ConvertoBase64.convertoBase64_method("room4.jpg"));
        list_room_ks01.add(new RoomDto("2", "123852", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        List<String> listimageRoom3 = new ArrayList<>();
        listimageRoom3.add(ConvertoBase64.convertoBase64_method("room5.jpg"));
        listimageRoom3.add(ConvertoBase64.convertoBase64_method("room6.jpg"));
        list_room_ks01.add(new RoomDto("3", "123852", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        List<String> listimageRoom4 = new ArrayList<>();
        listimageRoom4.add(ConvertoBase64.convertoBase64_method("room7.jpg"));
        listimageRoom4.add(ConvertoBase64.convertoBase64_method("room8.jpg"));
        list_room_ks01.add(new RoomDto("4", "123852", "P127", "DoubleRoom", 1, 2, 500000, false, des, listimageRoom4));
        List<String> listimageRoom5 = new ArrayList<>();
        listimageRoom5.add(ConvertoBase64.convertoBase64_method("room9.jpg"));
        listimageRoom5.add(ConvertoBase64.convertoBase64_method("room10.jpg"));
        list_room_ks01.add(new RoomDto("5", "123852", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));


        List<RoomDto> list_room_ks02 = new ArrayList<>();
        list_room_ks02.add(new RoomDto("6", "654853", "P124", "Executive", 1, 3, (double) 5000000, true, des, listimageRoom1));
        list_room_ks02.add(new RoomDto("7", "654853", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        list_room_ks02.add(new RoomDto("8", "654853", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        list_room_ks02.add(new RoomDto("9", "654853", "P127", "SingleRoom", 1, 1, 500000, true, des, listimageRoom4));
        list_room_ks02.add(new RoomDto("10", "654853", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));

        List<RoomDto> list_room_ks03 = new ArrayList<>();
        list_room_ks03.add(new RoomDto("10", "951258", "P124", "Executive", 1, 3, (double) 5000000, true, des, listimageRoom1));
        list_room_ks03.add(new RoomDto("11", "951258", "P125", "Executive", 1, 2, 500000, true, des, listimageRoom2));
        list_room_ks03.add(new RoomDto("12", "951258", "P126", "SingleRoom", 1, 1, 500000, true, des, listimageRoom3));
        list_room_ks03.add(new RoomDto("13", "951258", "P127", "SingleRoom", 1, 1, 500000, true, des, listimageRoom4));
        list_room_ks03.add(new RoomDto("14", "951258", "P129", "DoubleRoom", 1, 2, 500000, true, des, listimageRoom5));

        List<RoomDto> list_room_ks04 = new ArrayList<>();
        String des1 = "Khách sạn XXX là một điểm đến tuyệt vời cho du khách muốn tận hưởng sự tiện nghi và không gian sang trọng. // Với nội thất hiện đại và phòng ngủ rộng rãi, khách sạn XYZ đảm bảo bạn có một trải nghiệm lưu trú thoải mái và tiện nghi.";
        String des2 = "Khách sạn XXX nằm trong khu vực trung tâm, mang đến sự thuận tiện cho việc khám phá các điểm tham quan, nhà hàng và cửa hàng mua sắm. // Đội ngũ nhân viên thân thiện và chuyên nghiệp tại khách sạn XXX sẽ đảm bảo bạn nhận được dịch vụ tận tâm và hài lòng";
        String des3 = "Khách sạn XXX cam kết mang đến sự hài lòng và trải nghiệm lưu trú đáng nhớ cho du khách, với dịch vụ chất lượng và không gian ấm cúng. // Với không gian nghỉ ngơi thoải mái và view đẹp, khách sạn XXX là nơi lý tưởng để thưởng thức không gian yên tĩnh và tận hưởng không khí thư giãn.";


        List<String> listImageHotel1 = new ArrayList<>();
        listImageHotel1.add(ConvertoBase64.convertoBase64_method("h4.jpg"));
        listImageHotel1.add(ConvertoBase64.convertoBase64_method("h5.jpg"));

        List<String> listImageHotel2 = new ArrayList<>();
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h6.jpg"));
        listImageHotel2.add(ConvertoBase64.convertoBase64_method("h7.jpg"));

        List<String> listImageHotel3 = new ArrayList<>();
        listImageHotel3.add(ConvertoBase64.convertoBase64_method("h1.jpg"));
        listImageHotel3.add(ConvertoBase64.convertoBase64_method("h2.jpg"));

        List<String> listImageHotel4 = new ArrayList<>();
        listImageHotel4.add(ConvertoBase64.convertoBase64_method("h11.jpg"));

        List<String> listImageHotel5 = new ArrayList<>();
        listImageHotel5.add(ConvertoBase64.convertoBase64_method("h12.jpg"));

        hotelController.arrayListHotel.add(new HotelDto("123852", "SMARANA Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 95 đường 16"), 500000, 5, 8.0, 50, des1, listImageHotel1, list_room_ks01));
        hotelController.arrayListHotel.add(new HotelDto("654853", "Pullman Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 9 đường 16"), 500000, 5, 8.0, 50, des2, listImageHotel2, list_room_ks02));
        hotelController.arrayListHotel.add(new HotelDto("951258", "Alula Sweet Home", new Location("Hà Nội", "Hoàn Kiếm", "Số 97 đường 16"), 500000, 5, 8.0, 50, des3, listImageHotel3, list_room_ks03));
        hotelController.arrayListHotel.add(new HotelDto("854632", "Melia Hanoi", new Location("Hà Nội", "Hoàn Kiếm", "Số 10 đường 16"), 500000, 5, 8.0, 50, des2, listImageHotel4, list_room_ks01));
        hotelController.arrayListHotel.add(new HotelDto("741546", "Mường Thanh", new Location("Hà Nội", "Hoàn Kiếm", "Số 5 đường 16"), 500000, 5, 8.0, 50, des3, listImageHotel5, list_room_ks02));

        hotelController.arrayListHotel.add(new HotelDto("665841", "SMARANA DaNang", new Location("Đà Nẵng", "Bãi biển Mỹ Khê", "Số 95 đường 16"), 500000, 5, 8.0, 50, des1, listImageHotel1, list_room_ks01));
        hotelController.arrayListHotel.add(new HotelDto("987258", "Pullman DaNang", new Location("Đà Nẵng", "Bãi biển Non Nước", "Số 9 đường 16"), 500000, 5, 8.0, 50, des2, listImageHotel2, list_room_ks02));
        hotelController.arrayListHotel.add(new HotelDto("332198", "Alula Sweet Home DaNang", new Location("Đà Nẵng", "Bãi biển Mỹ Khê", "Số 97 đường 16"), 500000, 5, 8.0, 50, des3, listImageHotel3, list_room_ks03));


        CustomerController customerController = context.getBean(CustomerController.class);
        List<Card> listCard = new ArrayList<>();
        listCard.add(new Card("1", "kh1", "9982415569", "Duong", java.sql.Date.valueOf("2023-06-19"), "993", "MB Bank"));

        customerController.arrayListCustomer.add(new CustomerDto("kh1", "Duong", "duong@gmail.com", "0344381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDto("kh2", "Huyen", "jiwjdidwn@gmail.com", "0944381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDto("kh3", "Hai", "aaaaa@gmail.com", "0844381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDto("kh4", "Hoan", "awdwsds@gmail.com", "0744381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDto("kh5", "Tu", "duorarrng@gmail.com", "0644381904", "111111", listCard));
        customerController.arrayListCustomer.add(new CustomerDto("kh6", "Lien", "wwwww@gmail.com", "0544381904", "111111", listCard));


        BookingController bookingController = context.getBean(BookingController.class);
        java.sql.Date date1 = java.sql.Date.valueOf("2023-06-15");
        java.sql.Date date2 = java.sql.Date.valueOf("2023-06-20");
        bookingController.arrayListBooking.add(new BookingDto("1", "952", "Dương", "0344381904", "123", "975", "Executive", "987", date1, date2, 3000000));

        date1 = java.sql.Date.valueOf("2023-06-19");
        date2 = java.sql.Date.valueOf("2023-06-22");
        bookingController.arrayListBooking.add(new BookingDto("2", "258", "Huyền", "0944381904", "524", "852", "SingleRoom", "654", date1, date2, 4000000));

        date1 = java.sql.Date.valueOf("2023-01-19");
        date2 = java.sql.Date.valueOf("2023-01-23");
        bookingController.arrayListBooking.add(new BookingDto("3", "456", "Hoàn", "0944381904", "265", "654", "SingleRoom", "357", date1, date2, 5000000));

        date1 = java.sql.Date.valueOf("2023-01-19");
        date2 = java.sql.Date.valueOf("2023-01-23");
        bookingController.arrayListBooking.add(new BookingDto("4", "987", "Hải", "0944399904", "789", "456", "DoubleRoom", "987", date1, date2, 5000000));

        date1 = java.sql.Date.valueOf("2023-01-10");
        date2 = java.sql.Date.valueOf("2023-01-10");
        bookingController.arrayListBooking.add(new BookingDto("5", "123", "Duy", "787894488", "654", "654", "Executive", "147", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-02-10");
        date2 = java.sql.Date.valueOf("2023-02-20");
        bookingController.arrayListBooking.add(new BookingDto("6", "252", "Minh", "0943581904", "753", "464648", "SingleRoom", "369", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-03-10");
        date2 = java.sql.Date.valueOf("2023-03-20");
        bookingController.arrayListBooking.add(new BookingDto("7", "654", "Trang", "7414381904", "654", "155651", "DoubleRoom", "258", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-03-10");
        date2 = java.sql.Date.valueOf("2023-03-21");
        bookingController.arrayListBooking.add(new BookingDto("8", "753", "Nhung", "3694381904", "123", "151561", "Executive", "654", date1, date2, 12000000));

        date1 = java.sql.Date.valueOf("2023-03-01");
        date2 = java.sql.Date.valueOf("2023-03-11");
        bookingController.arrayListBooking.add(new BookingDto("9", "654", "Hoan", "0966681904", "852", "789774", "DoubleRoom", "357", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-04-10");
        date2 = java.sql.Date.valueOf("2023-04-20");
        bookingController.arrayListBooking.add(new BookingDto("10", "147", "Hai", "099381904", "125", "18511", "SingleRoom", "159", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-05-10");
        date2 = java.sql.Date.valueOf("2023-05-20");
        bookingController.arrayListBooking.add(new BookingDto("11", "987", "Xuyen", "0944381904", "951", "15111", "DoubleRoom", "753", date1, date2, 11000000));

        date1 = java.sql.Date.valueOf("2023-05-01");
        date2 = java.sql.Date.valueOf("2023-05-09");
        bookingController.arrayListBooking.add(new BookingDto("12", "456", "Mien", "0944381904", "753", "12561", "SingleRoom", "852", date1, date2, 9000000));

        date1 = java.sql.Date.valueOf("2023-07-01");
        date2 = java.sql.Date.valueOf("2023-07-09");
        bookingController.arrayListBooking.add(new BookingDto("17", "654", "Tuyer", "0944381904", "ks01", "987524", "DoubleRoom", "P127", date1, date2, 9000000));

    }

}
