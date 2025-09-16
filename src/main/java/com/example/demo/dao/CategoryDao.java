package com.example.demo.dao;

import java.sql.ResultSet;

public class CategoryDao {
	
	public ResultSet getList() {
		String sql = "SELECT * from categories";
		return MyJDBC.executeQuery(sql);
		
	}
	public ResultSet getCategory(String id) {
		String sql = "SELECT * from categories where categoryId='" + id + "'";
		return MyJDBC.executeQuery(sql);
		
	}
}
