package com.azevedo.gowapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GowApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GowApiApplication.class, args);
	}

}
