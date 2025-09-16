package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.CustomerService;

@Controller
@RequestMapping("/Customers")
public class CustomerController {
	
	//@Autowired
	//CustomerService cs;
	
	@GetMapping("")
	public String customers(Model model) {
		CustomerService cs = new CustomerService();
		model.addAttribute("customers", cs.getList());
		return "customer";
	}
	
	@GetMapping("/{id}")
	public String customerdetails(@PathVariable("id") String id, Model model) {
		CustomerService cs = new CustomerService();
		model.addAttribute("customer", cs.getCustomerById(id));
		return "customerdetails";
	}

}
