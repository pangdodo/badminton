package com.badminton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BadmintonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadmintonApplication.class, args);
	}
}
