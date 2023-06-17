package com.example.hotel_api;

import com.example.hotel_api.controller.*;
import com.example.hotel_api.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication ()
public class HotelApiApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(HotelApiApplication.class, args);

		HotelController hotelController =context.getBean(HotelController.class);
		hotelController.arrayList.add(new Hotel("ks01","SMARANA Hanoi","Ha Noi",5,8.0,50));
		hotelController.arrayList.add(new Hotel("ks02","Pullman Hanoi","Ha Noi",5,8.0,50));
		hotelController.arrayList.add(new Hotel("ks03","The oriental Jade Hotel","Ha Noi",5,8.0,50));
		hotelController.arrayList.add(new Hotel("ks04","Alula Sweet Home","Ha Noi",5,8.0,50));
		hotelController.arrayList.add(new Hotel("ks05","Melia Hanoi","Ha Noi",5,8.0,50));

		CustomerController customerController= context.getBean(CustomerController.class);
		customerController.arrayListCustomer.add(new Customer("kh1","Duong","duong@gmail.com","0344381904","111111"));
		customerController.arrayListCustomer.add(new Customer("kh2","Huyen","sss@gmail.com","0344381904","111111"));
		customerController.arrayListCustomer.add(new Customer("kh3","Hai","aaaaa@gmail.com","0344381904","111111"));
		customerController.arrayListCustomer.add(new Customer("kh4","Hoan","ddd@gmail.com","0344381904","111111"));
		customerController.arrayListCustomer.add(new Customer("kh5","Tu","duorrrng@gmail.com","0344381904","111111"));
		customerController.arrayListCustomer.add(new Customer("kh6","Lien","wwwww@gmail.com","0344381904","111111"));

		RoomController roomController =context.getBean(RoomController.class);
		roomController.arrayList.add(new Room("1","ks01",2,0,5,500000));
		roomController.arrayList.add(new Room("2","ks01",1,0,5,600000));
		roomController.arrayList.add(new Room("3","ks01",0,1,6,700000));
		roomController.arrayList.add(new Room("4","ks01",2,2,7,1000000));

		roomController.arrayList.add(new Room("5","ks02",2,0,5,500000));
		roomController.arrayList.add(new Room("6","ks02",1,0,5,600000));




		BookingController bookingController=context.getBean(BookingController.class);
		java.sql.Date date1 = java.sql.Date.valueOf("2023-06-15");
		java.sql.Date date2 = java.sql.Date.valueOf("2023-06-20");
		bookingController.arrayListBooking.add(new Booking("1","kh1","ks01","1",date1,date2,3000000));

		date1 = java.sql.Date.valueOf("2023-06-19");
		date2 = java.sql.Date.valueOf("2023-06-22");
		bookingController.arrayListBooking.add(new Booking("2","kh2","ks01","4",date1,date2,4000000));


		FileDownloadController downloadFileController=context.getBean(FileDownloadController.class);
		downloadFileController.arrayListImageData.add(new ImageData("1","ks01","h1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks01","h2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","ks01","h3.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("1","ks02","h1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks02","h2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","ks02","h3.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("1","ks03","h1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks03","h2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","ks03","h3.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("1","ks04","h1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks04","h2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","ks04","h3.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("1","ks05","h1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks05","h2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","ks05","h3.jpg"));


		downloadFileController.arrayListImageData.add(new ImageData("6","1","room1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room3.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room4.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room5.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room6.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","1","room7.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("6","2","room1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room3.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room4.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room5.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room6.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","2","room7.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("6","3","room1.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room2.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room3.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room4.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room5.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room6.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","3","room7.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("6","4","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","4","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","4","room7.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("6","5","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","5","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","5","room7.jpg"));

		downloadFileController.arrayListImageData.add(new ImageData("6","6","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","6","room7.jpg"));
		downloadFileController.arrayListImageData.add(new ImageData("6","6","room7.jpg"));






	}

}
