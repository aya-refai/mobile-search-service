package com.axiom.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SearchApplication {

	public static void main(String[] args) {
		System.out.println("Application is Running...");
		SpringApplication.run(SearchApplication.class, args);
	}

}
