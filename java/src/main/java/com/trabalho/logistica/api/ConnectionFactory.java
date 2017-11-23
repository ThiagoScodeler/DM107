package com.trabalho.logistica.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/dblogistica", "adminlogistica", "adminlogistica");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}