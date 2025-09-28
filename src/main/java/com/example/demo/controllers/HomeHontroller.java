package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.CreateTables;

@Controller
public class HomeHontroller {
	
	@GetMapping("/")
	public String home() {
		//CreateTables.run();
		return "home";
	}

}
