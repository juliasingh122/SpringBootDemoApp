package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.CreateTables;
import com.example.demo.domain.Product;

@Controller
public class HomeHontroller {
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}

	@PostMapping("/")
	public String run11(@ModelAttribute("qry") String qry, Model model) {
		
		return "home";
		
	}
}
