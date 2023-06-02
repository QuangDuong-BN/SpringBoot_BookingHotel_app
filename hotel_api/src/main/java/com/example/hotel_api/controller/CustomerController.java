package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    List<Customer> arrayListCustomer = new ArrayList<Customer>();

    @GetMapping
    public List<Customer> getCustomer() {
        return arrayListCustomer;
    }

    @PostMapping
    public Customer createUser(@RequestBody Customer customer) {
        arrayListCustomer.add(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        arrayListCustomer.removeIf(arrayListCustomer -> arrayListCustomer.getId().equals(id));
    }
}
