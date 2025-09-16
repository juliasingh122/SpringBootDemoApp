package com.example.demo.domain;

public class Customer {
	String customerNumber;	
	String customerName;
	
	public Customer(String customerName, String customerNumber) {
		this.customerName=customerName;
		this.customerNumber=customerNumber;
	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
}
