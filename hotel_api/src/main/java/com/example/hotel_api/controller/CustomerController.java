package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entities.CustomerRepository;
import com.example.hotel_api.entities.CustomerService;
import com.example.hotel_api.entitiesDTO.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public List<CustomerDto> arrayListCustomer = new ArrayList<>();
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/list")
    public List<CustomerDto> getCustomer() {
        arrayListCustomer.sort(Comparator.comparing(CustomerDto::getId));
        return arrayListCustomer;
    }

    @GetMapping()
    public CustomerDto getUser(@RequestParam("id") String id) {
        Customer customer;
        for (int i = 0; i < arrayListCustomer.size(); i++) {
            if (id.equals(arrayListCustomer.get(i).getId())) {
                return arrayListCustomer.get(i);
            }
        }
        return new CustomerDto();
    }

    @PostMapping
    public CustomerDto createUser(@RequestBody CustomerDto customer) {
        arrayListCustomer.add(customer);
        return customer;
    }

    @Operation(
            summary = "api đăng nhập",
            description = "trả về null nếu đăng nhập thất bại , trả về id của tài khoản đăng nhập nếu đăng nhập thành công"
    )
    @GetMapping("/login")
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password) {

        for (int i = 0; i < arrayListCustomer.size(); i++) {
            if (phone.equals(arrayListCustomer.get(i).getPhone())) {
                if (password.equals(arrayListCustomer.get(i).getPassword()))
                    return arrayListCustomer.get(i).getId();
            }
        }
        return null;
    }

    @PostMapping("/register")
    public boolean register(@RequestParam("id") String id,
                            @RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam("password") String password) {
        CustomerDto customerDTO = new CustomerDto();
        customerDTO.setId(id);
        customerDTO.setName(name);
        customerDTO.setPhone(phone);
        customerDTO.setEmail(email);
        customerDTO.setPassword(password);
        arrayListCustomer.add(customerDTO);
        return true;
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        arrayListCustomer.removeIf(arrayListCustomer -> arrayListCustomer.getId().equals(id));
    }

    @GetMapping("/test")
    @Operation(
            tags = "test nè"
    )
    public String getTest() {
        Customer customer = customerRepository.findById((long) 1).orElse(null);
        customerService.getUserById((long) 1);
        return customer.toString();
    }


}
