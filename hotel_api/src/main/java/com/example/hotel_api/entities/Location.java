package com.example.hotel_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    // tinh
    private String province;
    // huyen
    private String district;
    // dia chi cu the
    private String address;
}
