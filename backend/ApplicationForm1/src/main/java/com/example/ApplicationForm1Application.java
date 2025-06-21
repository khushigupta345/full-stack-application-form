package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan(basePackages = "com.example.model") // ✅ This is must
public class ApplicationForm1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationForm1Application.class, args);
	}

}
