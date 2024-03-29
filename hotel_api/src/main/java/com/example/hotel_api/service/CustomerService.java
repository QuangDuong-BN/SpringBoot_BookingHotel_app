package com.example.hotel_api.service;

import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.repository.CustomerRepository;
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

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }

    public Customer getCustomerByIdAndName(Long id, String name) {
        return customerRepository.findByIdAndName(id, name);
    }

    // cau lenh sql lay ra danh sach customer co name giong nhau
    // select * from customer where name like '%name%'
    public List<Customer> getCustomerByNameLike(String name) {
        return customerRepository.findByNameLike(name);
    }
}
