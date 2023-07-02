package com.example.hotel_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    /*
    @PostMapping()
    public ResponseEntity<String> login(@RequestBody User user) {
        // Kiểm tra thông tin đăng nhập
        if (authenticate(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Đăng nhập thành công");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại");
        }
    }

    private boolean authenticate(String username, String password) {
        // Kiểm tra thông tin đăng nhập với cơ sở dữ liệu người dùng
        // Trả về true nếu đúng, ngược lại trả về false
    }*/
}
