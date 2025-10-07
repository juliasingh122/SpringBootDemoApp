package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MyJDBC {
	
	final static String DB_URL = "jdbc:mysql://192.168.86.45:3306/jproject";
	
	public static ResultSet executeQuery(String query) {
		ResultSet resultset = null;

		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, "julia2", "j");

			
			Statement statement = con.createStatement();

			
			
			resultset = statement.executeQuery(query);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultset;
	}
	public static int executeUpdate(String query) {
	    try (Connection con = DriverManager.getConnection(DB_URL, "julia2", "j");
	         Statement stmt = con.createStatement()) {
	        return stmt.executeUpdate(query);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

}
