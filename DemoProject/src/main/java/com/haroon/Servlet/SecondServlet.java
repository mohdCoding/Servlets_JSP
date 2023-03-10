package com.haroon.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
       
      public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	  response.setContentType("text/html");
    	  PrintWriter out = response.getWriter();
    	  out.println("<body><h1>HttpServlet Class</h1></body>");
    	  
      }
      
}
