package com.example.demo.dao;

import java.sql.ResultSet;

public class ModuleDao {
	
	public ResultSet getList() {
		String sql = "SELECT * from Modules";
		return MyJDBC.executeQuery(sql);
		
	}
	public ResultSet getById(String id) {
		String sql = "Select * from modules where id='"+ id + "'";
		return MyJDBC.executeQuery(sql);
		
	}

	
}
