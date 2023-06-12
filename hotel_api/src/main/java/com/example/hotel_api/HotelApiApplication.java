package com.example.hotel_api;

import com.example.hotel_api.controller.DownloadFileController;
import com.example.hotel_api.entities.Customer;
import com.example.hotel_api.entities.ImageData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication ()
public class HotelApiApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(HotelApiApplication.class, args);

		DownloadFileController downloadFileController=context.getBean(DownloadFileController.class);
		downloadFileController.arrayListImageData.add(new ImageData("1","ks01","heh.png"));
		downloadFileController.arrayListImageData.add(new ImageData("2","ks02","heh.png"));
		downloadFileController.arrayListImageData.add(new ImageData("3","ks03","heh.png"));
		downloadFileController.arrayListImageData.add(new ImageData("4","ks04","heh.png"));
		downloadFileController.arrayListImageData.add(new ImageData("5","ks01","mamama.png"));



	}

}
