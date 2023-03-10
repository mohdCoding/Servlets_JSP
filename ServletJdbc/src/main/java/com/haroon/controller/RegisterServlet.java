package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql:///enterprise_java_course"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root123")
		})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig config= getServletConfig();
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			String sqlInsertQuery = "insert into student_details (name, email, city, country)" + 
			 "values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sqlInsertQuery);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, city);
			pstmt.setString(4, country);
			
			int noOfRows = pstmt.executeUpdate();
			noOfRows = 10;
			if(noOfRows  == 1) {
				out.print("<html><head><title>Result Page</title></head><body>");
				out.print("<h1 bgColor='cyan' color='white' align='center'>Registered Successfully</h1>");
				out.print("</body></html>");
			} else {
				out.print("<html><head><title>Result Page</title></head><body>");
				out.print("<h1 bgColor='cyan' color='white' align='center'>Register Failed</h1>");
				out.print("<a href = './Register.html'>Click Here to try again</a>");
				out.print("</body></html>");
			}
			
			out.flush();
			out.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
