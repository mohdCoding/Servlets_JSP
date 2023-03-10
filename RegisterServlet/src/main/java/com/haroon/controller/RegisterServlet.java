package com.haroon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;


@WebServlet(urlPatterns = {"/register"}, loadOnStartup = 0)
public class RegisterServlet extends HttpServlet  {

   
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	 
    	 response.setContentType("text/html");
    	 
    	 PrintWriter out = response.getWriter();
    	 
    	 String name = request.getParameter("name");
    	 String contact = request.getParameter("contact");
    	 String email = request.getParameter("email");
    	 String[] courses = request.getParameterValues("courses");
    	 
    	 out.println("<html><head><title>Details Page</title></head>");
    	 out.println("<body><h1>Student Register Details</h1>");
    	 out.println("<table border='2'>");
    	 out.println("<tr><th>Name</th>");
    	 out.println("<td>" + name + "</td></tr>");
    	 out.println("<tr><th>Contact Number</th>");
    	 out.println("<td>" + contact + "</td></tr>");
    	 out.println("<tr><th>Email</th>");
    	 out.println("<td>" + email + "</td></tr>");
    	 out.println("<tr><th>Courses</th>");
    	 out.println("<td>");
    	 for(String course:courses) {
    		 out.println(course + "<br>");
    	 }
    	 out.println("</td></tr>");
    	 out.println("</table></body></html>");
    	 
     }
}
