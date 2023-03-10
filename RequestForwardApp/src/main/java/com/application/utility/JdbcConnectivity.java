package com.application.utility;

import java.sql.*;
import java.io.*;
import java.util.*;

public class JdbcConnectivity {

	private JdbcConnectivity() {
		
	}
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql:///enterprise_java_course";
			String userName = "root";
			String password = "root123";
			
			connection = DriverManager.getConnection(url, userName, password);
		
	       return connection;
			
	}
	
	
	public static void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet resultSet) throws SQLException {
		if(connection != null)
			connection.close();
		
		if(pstmt != null)
			pstmt.close();
		
		if(resultSet != null)
			resultSet.close();
	}
}
