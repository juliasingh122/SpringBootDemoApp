package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeHontroller {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
