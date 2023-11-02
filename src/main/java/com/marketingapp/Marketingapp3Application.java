package com.marketingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"controller"})
@ComponentScan(basePackages= {"com.marketingapp.services"})
public class Marketingapp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Marketingapp3Application.class, args);
	}

}
