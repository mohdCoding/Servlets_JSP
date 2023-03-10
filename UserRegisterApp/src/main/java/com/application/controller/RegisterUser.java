package com.application.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.utility.JdbcConnectivity;

import java.util.*;
import java.io.*;
import java.sql.*;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	
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
		String email = request.getParameter("email");
		String mobile =  request.getParameter("mobile1") + 
				         request.getParameter("mobile2") +
				         request.getParameter("mobile3");
		
		if(connection != null) {
			String query = "insert into user_db(name, email, mobile) values(?, ?, ?)";
			try {
				pstmt = connection.prepareStatement(query);
				
				if(pstmt != null) {
					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, mobile);
					
					int rowsAff = pstmt.executeUpdate();
					
					if(rowsAff == 1) {
						out.print("<html><head><title>Register Sucess</title></head>");
						out.print("<body><h1 align = 'center' >Registration Successfull</h1></body></html>");
					} else {
						out.print("<html><head><title>Register Failed</title></head>");
						out.print("<body><h1 align='center'>Registration Failed</h1>");
						out.print("<p align='center' font-size ='20px' ><a href='register.html'>Click Here to try again</a></p>");
						out.print("</body></html>");
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
