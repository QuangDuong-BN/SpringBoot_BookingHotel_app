package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Booking;
import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entitiesDTO.BookingDTO;
import com.example.hotel_api.entitiesDTO.StatisticDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        arrayListBooking.add(booking);
        return booking;
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") String id) {
        arrayListBooking.removeIf(arrayListBooking -> arrayListBooking.getId().equals(id));
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

    private String formatDate(Date date) {
        return date.toLocalDate()
                .format(DateTimeFormatter
                        .ofPattern("MM/yyyy")
                );
    }
}
