package com.example.hotel_api.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getUserById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

}
