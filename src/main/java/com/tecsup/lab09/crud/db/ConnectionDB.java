package com.tecsup.lab09.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
	
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/findbank";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
		}
		return con;
	}


}
