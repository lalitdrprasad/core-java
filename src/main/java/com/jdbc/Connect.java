package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {
	static Connection con = null;
	public static Connection getConnection() {
		
		try {
			//Driver Loading 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connection Establishment
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv","root","root");
			
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
