package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.domain.Product;

public class ProductDao {
	
	public ResultSet getList() {
		String sql = "SELECT * from products";
		return MyJDBC.executeQuery(sql);
	}
	public ResultSet getListByCategoryId(String categoryId) {
		String sql = "SELECT * from products where categoryId='" + categoryId + "'";
		return MyJDBC.executeQuery(sql);
		
	}
	
	public ResultSet getProduct(String productCode) {
		String sql = "SELECT * from products where productCode='" + productCode + "'";
		return MyJDBC.executeQuery(sql);
		
	}
	
	public void updateProduct(Product product) {
		String sql = "UPDATE productName='" + product.getProductName() + "', categoryId=" + product.getCategoryId() + " WHERE productCode="+ product.getProductCode();
		MyJDBC.executeQuery(sql);
		return;
	}

}
