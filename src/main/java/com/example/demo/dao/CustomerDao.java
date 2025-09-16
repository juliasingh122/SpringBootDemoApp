package com.example.demo.dao;

import java.sql.ResultSet;

public class CustomerDao {
	
	public ResultSet getList() {
		String sql = "SELECT * from customers";
		return MyJDBC.executeQuery(sql);
		
	}
	public ResultSet getCustomer(String customerNumber) {
		String sql = "Select * from customers where customerNumber='"+ customerNumber + "'";
		return MyJDBC.executeQuery(sql);
		
	}

}
