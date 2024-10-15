package com.JDBCdemo;
import java.sql.*;

public class Callable {

	public static void main(String[] args) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
			CallableStatement cs = con.prepareCall("call add_data(?,?)");
			cs.setInt(1, 101);
			cs.setString(2, "lalit");
			cs.executeUpdate();
			System.out.println("Done");
	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}