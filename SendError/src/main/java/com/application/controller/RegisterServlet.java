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


@WebServlet(urlPatterns = {"/test"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	private PreparedStatement pstmt;
	
	public void init() {
		
		try {
			connection = JdbcConnectivity.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		PrintWriter out = response.getWriter();
		String status;
		
		if(age < 18 || age > 30) {
			response.sendError(504, "User age is not match the requirment");
		} else {
			if(connection != null) {
				String query = "insert into register_db(name, age, email, mobile) values (?, ?, ?, ?)";
				try {
					pstmt = connection.prepareStatement(query);
					
					if(pstmt != null) {
						pstmt.setString(1, name);
						pstmt.setInt(2, age);
						pstmt.setString(3, email);
						pstmt.setString(4, mobile);
						
						int rowsAff = pstmt.executeUpdate();
						 out.println("<table border='2'>");
					      out.println("<tr>");
					      out.println("<td>Name</td><td>" + name + "</td>");
					      out.println("</tr>");
					      out.println("<tr>");
					      out.println("<td>Age</td><td>" + age + "</td>");
					      out.println("</tr>");
					      out.println("<tr>");
					      out.println("<td>eamil</td><td>" + email + "</td>");
					      out.println("</tr>");
					      out.println("<tr>");
					      out.println("<td>mobile</td><td>" + mobile + "</td>");
					      out.println("</tr>");
					     
						if(rowsAff == 1) {
						  status = "Succesfully Registered";
						  out.println("<tr>");
					      out.println("<td>status</td><td>" + status + "</td>");
					      out.println("</tr>");
					      out.println("</table>");
						} else {
							  status = "Register Failed";
							  out.println("<tr>");
						      out.println("<td>status</td><td>" + status + "</td>");
						      out.println("</tr>");
						      out.println("</table>");
						      out.println("<a href='index.html'>Click Here to try Again</a>");
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					out.flush();
					out.close();
				}
			}
		}
				
		
		
	}
	
	public void destroy() {
		
		try {
			JdbcConnectivity.closeConnection(connection, pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
