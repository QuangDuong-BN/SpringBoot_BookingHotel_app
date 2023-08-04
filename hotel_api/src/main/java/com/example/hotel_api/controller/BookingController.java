package com.example.hotel_api.controller;

import com.example.hotel_api.entitiesDTO.BookingDto;
import com.example.hotel_api.entitiesDTO.HotelDto;
import com.example.hotel_api.entitiesDTO.RoomDto;
import com.example.hotel_api.entitiesDTO.StatisticDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotel_api.controller.HotelController.arrayListHotel;

@RestController
@RequestMapping("/booking")
public class BookingController {

    public ArrayList<BookingDto> arrayListBooking = new ArrayList<>();

    @GetMapping("/list")
    @Operation(tags = "API booking")
    public List<BookingDto> get1() {
        return arrayListBooking;
    }

    @GetMapping()
    @Operation(tags = "API booking")
    public BookingDto get2(@RequestParam("id") String id) {
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (id.equals(arrayListBooking.get(i).getId()))
                return arrayListBooking.get(i);
        }
        return new BookingDto();
    }

    @PostMapping
    @Operation(tags = "API booking")
    public BookingDto create(@RequestBody BookingDto booking) {
        for (int i = 0; i < arrayListHotel.size(); i++) {
            HotelDto hotel = arrayListHotel.get(i);
            if (hotel.getId().equals(booking.getHotel_id())) {
                List<RoomDto> rooms = hotel.getRooms();
                for (int j = 0; j < rooms.size(); j++) {
                    if (rooms.get(j).equals(booking.getRoom_id())) {
                        rooms.get(j).setStatus(!rooms.get(j).isStatus());
                    }
                }
            }
        }
        arrayListBooking.add(booking);
        return booking;
    }

    @DeleteMapping()
    @Operation(tags = "API booking")
    public String delete(@RequestParam("id") String id) {

        BookingDto bookingDTO = null;
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (arrayListBooking.get(i).getId().equals(id)) {
                bookingDTO = arrayListBooking.get(i);
            }
        }
        for (int i = 0; i < arrayListHotel.size(); i++) {
            HotelDto hotel = arrayListHotel.get(i);
            if (hotel.getId().equals(bookingDTO.getHotel_id())) {
                List<RoomDto> rooms = hotel.getRooms();
                for (int j = 0; j < rooms.size(); j++) {
                    if (rooms.get(j).equals(bookingDTO.getRoom_id())) {
                        rooms.get(j).setStatus(!rooms.get(j).isStatus());
                    }
                }
            }
        }

        arrayListBooking.removeIf(arrayListBooking -> arrayListBooking.getId().equals(id));
        return "success";
}
    @GetMapping("/month")
    @Operation(tags = "API booking")
    public List<StatisticDto> statisticBookByMonth() {
        List<StatisticDto> statisticDTOList = new ArrayList<>();
        arrayListBooking.sort((o1, o2) -> {
            if (o1.getEnd_date().before(o2.getEnd_date()))
                return 1;
            return 0;
        });
        String month = null;
        StatisticDto statisticDTO = new StatisticDto();
        for (BookingDto booking : arrayListBooking) {
            String formattedEndDate = formatDate(booking.getEnd_date());
            if (month == null) {
                month = formattedEndDate;
                statisticDTO = new StatisticDto(month, booking.getPrice());
            } else {
                if (formattedEndDate.equals(month)) {
                    statisticDTO.setMoney(statisticDTO.getMoney() + booking.getPrice());
                } else {
                    month = formatDate(booking.getEnd_date());
                    statisticDTOList.add(statisticDTO);
                    statisticDTO = new StatisticDto(formattedEndDate, booking.getPrice());
                }
            }
        }
        statisticDTOList.add(statisticDTO);
        return statisticDTOList;
    }

    @GetMapping("/bookingByCustomerId")
    @Operation(tags = "API booking ",
            description = "Lấy thông ra list thông tin phòng mà khách hàng đặt theo id của khách hàng. ")
    public ArrayList<BookingDto> getById(@RequestParam("customer_id") String id) {
        ArrayList<BookingDto> newArrayList = new ArrayList<>();
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (arrayListBooking.get(i).getCustomer_id().equals(id)) {
                newArrayList.add(arrayListBooking.get(i));
            }
        }
        return newArrayList;
    }

    private String formatDate(Date date) {
        return date.toLocalDate()
                .format(DateTimeFormatter
                        .ofPattern("MM/yyyy")
                );
    }
}
