package com.example.demo.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	
	public ResultSet getList() {
		String sql = "SELECT * from categories";
		return MyJDBC.executeQuery(sql);
		
	}
	public ResultSet getCategory(String id) {
		String sql = "SELECT * from categories where categoryId='" + id + "'";
		return MyJDBC.executeQuery(sql);
		
	}
	public ResultSet getCategory1(String id) {
		String sql = "SELECT c.categoryId, c.categoryName, p.productId, p.productName from categories c inner join "
				+ "Product p on c.categoryId = p.CategoryId where c.categoryId='" + id + "'";
		return MyJDBC.executeQuery(sql);
		
	}
}
