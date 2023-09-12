package com.example.hicardi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HiCardiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiCardiApplication.class, args);
	}


	

}
