package com.axiom.search;

import com.axiom.search.api.control.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SearchApplication implements CommandLineRunner{

	@Autowired
	private SearchService searchService;

	public static void main(String[] args) {
		SpringApplication.run(SearchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		searchService.initDatabase();
	}
}
