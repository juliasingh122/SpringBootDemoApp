package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.print(SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8().encode("Puru"));
		SpringApplication.run(DemoApplication.class, args);
	}

}