package com.example.hotel_api;

import com.example.hotel_api.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication ()
public class HotelApiApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(HotelApiApplication.class, args);
		/*Customer customer1= context.getBean(Customer.class);
		Customer customer2= context.getBean(Customer.class);
		customer1.setId("CT040213");
		customer1.setName("Duong");
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());*/

	}

}
