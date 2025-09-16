package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.CategoryDao;
import com.example.demo.domain.Category;

public class CategoryService {
	
	public List<Category> getList(){
		List<Category> categories = new ArrayList<Category>();
		CategoryDao cd = new CategoryDao();
		ResultSet rs = cd.getList();
		
		try {
			while(rs.next()) {
				Category c = new Category(rs.getString(1), rs.getString(2));
				categories.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
	
	public Category getCategoryById(String id) {
		CategoryDao cd = new CategoryDao();
		ResultSet rs = cd.getCategory(id);
		Category c = null;
		try {
			rs.next();
			c=new Category(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	
}
