package com.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockServiceRegistry1Application {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceRegistry1Application.class, args);
	   
	}

}
