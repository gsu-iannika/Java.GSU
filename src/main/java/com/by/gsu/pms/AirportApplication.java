package com.by.gsu.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AirportApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
