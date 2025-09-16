package com.example.demo.domain;

public class Product {
	
	String productCode;
	String productName;
	String categoryId;
	
	public Product(String productCode, String productName, String categoryId){
		this.productCode = productCode;
		this.productName = productName;
		this.categoryId = categoryId;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	

}
