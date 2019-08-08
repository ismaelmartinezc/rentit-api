package com.example.rentit;

import com.example.rentit.models.AuditModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RentitApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentitApplication.class, args);
	}

}
