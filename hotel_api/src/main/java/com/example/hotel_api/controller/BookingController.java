package com.example.hotel_api.controller;

import com.example.hotel_api.entitiesDTO.BookingDTO;
import com.example.hotel_api.entitiesDTO.HotelDTO;
import com.example.hotel_api.entitiesDTO.RoomDTO;
import com.example.hotel_api.entitiesDTO.StatisticDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.hotel_api.controller.HotelController.arrayListHotel;

@RestController
@RequestMapping("/booking")
public class BookingController {
    public ArrayList<BookingDTO> arrayListBooking = new ArrayList<>();

    @GetMapping("/list")
    public List<BookingDTO> get1() {
        return arrayListBooking;
    }

    @GetMapping()
    public BookingDTO get2(@RequestParam("id") String id) {
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (id.equals(arrayListBooking.get(i).getId()))
                return arrayListBooking.get(i);
        }
        return new BookingDTO();
    }

    @PostMapping
    public BookingDTO create(@RequestBody BookingDTO booking) {
        for (int i = 0; i < arrayListHotel.size(); i++) {
            HotelDTO hotel = arrayListHotel.get(i);
            if (hotel.getId().equals(booking.getHotel_id())) {
                List<RoomDTO> rooms = hotel.getRooms();
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
    public String delete(@RequestParam("id") String id) {

        BookingDTO bookingDTO = null;
        for (int i = 0; i < arrayListBooking.size(); i++) {
            if (arrayListBooking.get(i).getId().equals(id)) {
                bookingDTO = arrayListBooking.get(i);
            }
        }
        for (int i = 0; i < arrayListHotel.size(); i++) {
            HotelDTO hotel = arrayListHotel.get(i);
            if (hotel.getId().equals(bookingDTO.getHotel_id())) {
                List<RoomDTO> rooms = hotel.getRooms();
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
    public List<StatisticDTO> statisticBookByMonth() {
        List<StatisticDTO> statisticDTOList = new ArrayList<>();
        arrayListBooking.sort((o1, o2) -> {
            if (o1.getEnd_date().before(o2.getEnd_date()))
                return 1;
            return 0;
        });
        String month = null;
        StatisticDTO statisticDTO = new StatisticDTO();
        for (BookingDTO booking : arrayListBooking) {
            String formattedEndDate = formatDate(booking.getEnd_date());
            if (month == null) {
                month = formattedEndDate;
                statisticDTO = new StatisticDTO(month, booking.getPrice());
            } else {
                if (formattedEndDate.equals(month)) {
                    statisticDTO.setMoney(statisticDTO.getMoney() + booking.getPrice());
                } else {
                    month = formatDate(booking.getEnd_date());
                    statisticDTOList.add(statisticDTO);
                    statisticDTO = new StatisticDTO(formattedEndDate, booking.getPrice());
                }
            }
        }
        statisticDTOList.add(statisticDTO);
        return statisticDTOList;
    }

    @GetMapping("/bookingByCustomerId")
    public ArrayList<BookingDTO> getById(@RequestParam("customer_id") String id) {
        ArrayList<BookingDTO> newArrayList = new ArrayList<>();
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
