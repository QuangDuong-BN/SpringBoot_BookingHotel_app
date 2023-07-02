package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entitiesDTO.CusLogin;
import com.example.hotel_api.entitiesDTO.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public List<CustomerDTO> arrayListCustomer = new ArrayList<>();

    @GetMapping
    public List<CustomerDTO> getCustomer() {
        return arrayListCustomer;
    }

    @GetMapping("/{id}")
    public CustomerDTO getUser(@PathVariable String id) {
        for (int i = 0; i < arrayListCustomer.size(); i++) {
            if (id.equals(arrayListCustomer.get(i).getId()))
                return arrayListCustomer.get(i);
        }
        return new CustomerDTO();
    }

    @PostMapping
    public CustomerDTO createUser(@RequestBody CustomerDTO customer) {
        arrayListCustomer.add(customer);
        return customer;
    }

    @PostMapping("/login")
    public String createUser(@RequestBody CusLogin cusLogin) {

        for (int i = 0; i < arrayListCustomer.size(); i++) {
            if (cusLogin.getPhone().equals(arrayListCustomer.get(i).getPhone())){
                if (cusLogin.getPassword().equals(arrayListCustomer.get(i).getPassword()))
                    return arrayListCustomer.get(i).getId();
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        arrayListCustomer.removeIf(arrayListCustomer -> arrayListCustomer.getId().equals(id));
    }

}
