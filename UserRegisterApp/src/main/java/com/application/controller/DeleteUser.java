package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.utility.JdbcConnectivity;


@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

	private Connection connection;
	private PreparedStatement pstmt;

	
	public void init() {
		
		
		try {
			
			connection = JdbcConnectivity.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}
  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	    String name = request.getParameter("name");
		
		if(connection != null) {
			try {
				String query = "delete from user_db where name = ?";
				pstmt = connection.prepareStatement(query);
				
				if(pstmt != null) {
					pstmt.setString(1, name);
					int rowsAff = pstmt.executeUpdate();
					if(rowsAff == 1) {
						out.println("<html><head><title>Update Success</title></head>");
						out.println("<body><h1 text-align='center'>Succesfully Deleted</h1>");
						out.println("</body></html>");
					} else {
						out.println("<html><head><title>Deletion Failed</title></head>");
						out.println("<body><h1 text-align='center'>Deletion failed</h1>");
						out.println("<h4>Please enter the correct existing name</h4>");
						out.println("<p><a href='Register.html'>Click Here to try again</a></p>");
						out.println("</body></html>");
					}
					
					out.flush();
					out.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
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
