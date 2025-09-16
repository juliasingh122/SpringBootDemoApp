package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.CustomerDao;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Product;

public class CustomerService {
	public List<Customer> getList(){
		List<Customer> customers = new ArrayList<Customer>();
		CustomerDao cd = new CustomerDao();
		ResultSet rs = cd.getList();
		
		try {
			while(rs.next()) {
				//check later if its really 1 and 2
				Customer c = new Customer(rs.getString("customerName"),rs.getString("customerNumber"));
				customers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
	public Customer getCustomerById(String id) {
		CustomerDao cd = new CustomerDao();
		ResultSet rs = cd.getCustomer(id);
		Customer c = null;
		
		try {
			rs.next();
			c = new Customer(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
