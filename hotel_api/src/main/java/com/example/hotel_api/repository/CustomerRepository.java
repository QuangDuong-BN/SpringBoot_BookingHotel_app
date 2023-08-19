package com.example.hotel_api.repository;

import com.example.hotel_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // tim kiem theo ten
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);

    //
    @Query("SELECT u.name FROM Customer u ")
    List<String> findListHotel();

    @Query("Select u from Customer u where u.email= :email and u.name= :name")
    List<Customer> findUserByEmailAndName(@Param("email") String email, @Param("name") String name);

    //
    Customer findByIdAndName(Long id, String name);

    // tim kiem theo ten
    List<Customer> findByNameLike(String name);
}
