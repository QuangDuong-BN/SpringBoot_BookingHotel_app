package com.example.hotel_api.entities;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Các phương thức truy vấn cơ sở dữ liệu sẽ được tự động tạo ra bởi Spring Data JPA
}
