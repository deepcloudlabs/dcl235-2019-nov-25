package com.example;

import java.sql.SQLException;

public class FacadeClient {

	public static void main(String[] args) throws SQLException {
		DatabaseTableFacade.getTableNames("jdbc:mysql://localhost:3306/world?useSSL=false", "root", "Secret_123")
		                   .forEach(System.out::println); 
	}

}
