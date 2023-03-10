package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.utility.JdbcConnectivity;

import java.sql.*;
@WebServlet("/userDetails")
public class UserDetails extends HttpServlet {
	
	Connection connection;
	PreparedStatement pstmt;
	ResultSet resultSet;

	
	public void init() {
		try {
			connection = JdbcConnectivity.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		if(connection != null) {
			String query = "select name, email, mobile from user_db";
			try {
				pstmt = connection.prepareStatement(query);
				
			     if(pstmt != null) {
			    	 resultSet = pstmt.executeQuery();
			    	 
			    	 if(resultSet != null) {
			    		
			    		 out.println("<html><head><title>User List</title></head><body><h1 text-align='center'>Users List</h1>");
			             out.println("<table border='2'><tr><th>Name</th><th>Email</th><th>Mobile</th></tr>");
			    		 while(resultSet.next()) {
			    			 String name = resultSet.getString("name");
			    			 String email = resultSet.getString("email");
			    			 String mobile = resultSet.getString("mobile");
			    			 
			    			 out.print("<tr><td>" + name + "</td><td>" + email + "</td><td>" + 
			    			            mobile + "</td>");
			    			 
			    		 }
			    		 out.println("</table></body></html>");		 
			    	 } 
			     }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		out.flush();
		out.close();
	}
	
	public void destroy() {
		try {
			JdbcConnectivity.closeConnection(connection, pstmt, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
