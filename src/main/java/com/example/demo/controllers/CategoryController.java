package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Category;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@Controller
@RequestMapping("/Categories")
public class CategoryController {
	
	@GetMapping("")
	public String category(Model model) {
		CategoryService cs = new CategoryService();
		model.addAttribute("categories", cs.getList());
		return "categories";
	}
	
	/*@GetMapping("/{id}")
	public String categorydetails(@PathVariable("id")String id, Model model) {
		CategoryService cs = new CategoryService();
		model.addAttribute("category", cs.getCategoryById(id));
		ProductService ps = new ProductService();
		model.addAttribute("products", ps.getListbyCategoryId(id));
		return "categorydetails";
		
	}*/
	
	@GetMapping("/{id}")
	public String categorydetails(@PathVariable("id")String id, Model model) {
		CategoryService cs = new CategoryService();
		ProductService ps = new ProductService();
		Category category = cs.getCategoryById(id);
		category.setProducts(ps.getListbyCategoryId(id));
		model.addAttribute("category", category);
		return "categorydetails";
		
	}
	
	
}
