package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@Controller
@RequestMapping("/Products")
public class ProductsController {

	@Autowired
	ProductService ps;
	
	@GetMapping("")
	public String products(Model model) {
		//ProductService ps = new ProductService();
		model.addAttribute("products", ps.getList());
		return "products";
	}
	
	@GetMapping("/{id}")
	public String productdetails(@PathVariable("id") String id, Model model) {
		//ProductService ps = new ProductService();
		model.addAttribute("product", ps.getProductById(id));
		CategoryService cs = new CategoryService();
		model.addAttribute("categories", cs.getList());
		return "productdetails";
	}
	
	@PostMapping("/{id}")
	public String postProductdetails(@PathVariable("id") String id, @ModelAttribute("product") Product product, Model model) {
		return "productdetails";
	}
}
