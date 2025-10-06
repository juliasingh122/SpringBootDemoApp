package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;


@Controller
@RequestMapping("/Users")
public class UserController {

	@Autowired
	UserService ps;
	
	@Autowired
	RoleService rs;
	
	@GetMapping("")
	public String users(Model model) {
		model.addAttribute("users", ps.getUsers());
		return "users";
	}
	
	@GetMapping("/{id}")
	public String productdetails(@PathVariable("id") String id, Model model) {
		//ProductService ps = new ProductService();
		//User user = new User("12","!2");
		
		model.addAttribute("user", ps.getUserById(id));
		model.addAttribute("allroles", rs.getRoles());
		return "userdetail";
	}
	
	@PostMapping("/{id}")
	public String postProductdetails(@PathVariable("id") String id, @ModelAttribute("user") User user, Model model) {
		return "userdetails";
	}
}
