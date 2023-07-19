package com.example.hotel_api.entitiesDTO;

import com.example.hotel_api.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Card> cards;
}
