package com.example.demo.services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;

@Service
public class ProductService {
	

	
	public List<Product>  getList() {
		
		List<Product> products = new ArrayList<Product>();
		ProductDao pd = new ProductDao();
		ResultSet rs = pd.getList();
		try {
			while(rs.next()) {
				Product p = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Product p = new Product("1", "apple");
		//products.add(p);
		//p=new Product ("2", "banana");
		//products.add(p);
		return products;
		
	}
	
	public List<Product> getListbyCategoryId (String categoryId) {
		List<Product> products = new ArrayList<Product>();
		ProductDao pd = new ProductDao();
		ResultSet rs = pd.getListByCategoryId(categoryId);
		try {
			while(rs.next()) {
				Product p = new Product(rs.getString(1), rs.getString(2), rs.getString(3));
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}
	
	public Product getProductById(String id) {
		ProductDao pd = new ProductDao();
		ResultSet rs = pd.getProduct(id);
		
		Product p = null;
		try {
			rs.next();
			p = new Product(rs.getString(1),rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
