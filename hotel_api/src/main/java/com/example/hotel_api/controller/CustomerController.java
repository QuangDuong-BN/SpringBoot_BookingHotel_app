package com.example.hotel_api.controller;

import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entitiesDTO.CusLogin;
import com.example.hotel_api.entitiesDTO.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public List<CustomerDTO> arrayListCustomer = new ArrayList<>();

    @GetMapping("/list")
    public List<CustomerDTO> getCustomer() {
        arrayListCustomer.sort(Comparator.comparing(CustomerDTO::getId));
        return arrayListCustomer;
    }

    @GetMapping()
    public CustomerDTO getUser(@RequestParam("id") String id) {
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

    @Operation(
            summary = "api đăng nhập",
            description = "trả về null nếu đăng nhập thất bại , trả về id của tài khoản đăng nhập \nnếu đăng nhập thành công"

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
        CustomerDTO customerDTO = new CustomerDTO();
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


}
