package com.example.hotel_api.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Các phương thức truy vấn cơ sở dữ liệu sẽ được tự động tạo ra bởi Spring Data JPA
}
