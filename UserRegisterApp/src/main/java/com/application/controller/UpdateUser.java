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

@WebServlet("/update")
public class UpdateUser extends HttpServlet {

	Connection connection;
	PreparedStatement pstmt;
	
	
	

	public void init() {
		
		
		try {
			
			connection = JdbcConnectivity.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(connection != null) {
			
			String query = "update user_db set name = ?, email = ?, mobile = ? where name = ?";
			try {
				pstmt = connection.prepareStatement(query);
				if(pstmt != null) {
					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, mobile);
					pstmt.setString(4, ename);
					
					int rowsAff = pstmt.executeUpdate();
					if(rowsAff == 1) {
						out.println("<html><head><title>Update Success</title></head>");
						out.println("<body><h1 text-align='center'>Succesfully Updated</h1>");
						out.println("</body></html>");
					} else {
						out.println("<html><head><title>Update Failed</title></head>");
						out.println("<body><h1 text-align='center'>Updation failed</h1>");
						out.println("<h4>Please enter the correct existing name</h4>");
						out.println("<p><a href='Update.html'>Click Here to try again</a></p>");
						out.println("</body></html>");
					}
				}
				
				out.flush();
				out.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
public void destroy() {
		
		try {
			
			JdbcConnectivity.closeConnection(connection, pstmt, null);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
