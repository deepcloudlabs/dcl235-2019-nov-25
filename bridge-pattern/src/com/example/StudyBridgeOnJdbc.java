package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudyBridgeOnJdbc {

	public static void main(String[] args) throws Exception {
		String jdbcUrl = "jdbc:mysql://localhost:3306/world?useSSL=false";
		String user = "root";
		String password = "Secret_123";
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.err.println(connection.getClass());
		PreparedStatement stmnt = connection.prepareStatement("select * from city where countrycode=?");
		stmnt.setString(1, "TUR");
		System.err.println(stmnt.getClass());
		ResultSet rs = stmnt.executeQuery();
		System.err.println(rs.getClass());
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
	}

}
