package com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableFacade {
	public static List<String> getTableNames(String jdbcUrl, String user, String password) throws SQLException {
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection.getClass());
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getClass());
		ResultSet rs = metaData.getTables(null, null, null, null);
		System.out.println(rs.getClass());
		List<String> names = new ArrayList<>();
		while (rs.next()) {
			names.add(rs.getString("TABLE_NAME"));
		}
		return names;
	}

}
