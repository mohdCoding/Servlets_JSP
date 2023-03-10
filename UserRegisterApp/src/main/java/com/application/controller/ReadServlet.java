package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.utility.JdbcConnectivity;


@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

   public void init() {
		
		try {
			connection = JdbcConnectivity.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			 e.printStackTrace();
		}
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name = request.getParameter("search");
		
		if(connection != null) {
			String query = "select name, email, mobile from user_db where name = ?";
			try {
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, name);
				resultSet = pstmt.executeQuery();
				
				if(resultSet != null) {
					if(resultSet.next()) {
						String uname = resultSet.getString(1);
						String uemail = resultSet.getString(2);
						String umobile = resultSet.getString(3);
						out.println("<html><head><title>User page</title><style>");
						out.println("h1 { font-size:23px; color:red; } table th{border:2px solid black; color:red; font-size:19px;} table td{border:2px solid black; color:red; font-size:19px;}");
						out.println("</style></head><body><h1 align='center'>User Detail</h1>");
						out.println("<table align='center'><tr><th>Name</th><th>Email</th><th>Mobile</th></tr>");
						out.println("<tr><td>" + uname + "</td><td>" + uemail + "</td><td>" + umobile + "</td></tr>");
						out.println("</table></body></html>");
						
					} else {
						out.println("<html><head><title>No User Page</title><style>h1{font-size:20px; color:red;}" + 
					               "h4 a {text-align:center; color:red;}</style></head>");
					    out.println("<body><h1>No User Found by this name</h1>");
					    out.println("<h4><a href='Register.html'>Click here to try again</a></h4>");
					    out.println("</body></html>");
					}
					out.flush();
					out.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void destroy() {
		try {
			JdbcConnectivity.closeConnection(connection, pstmt, resultSet);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
