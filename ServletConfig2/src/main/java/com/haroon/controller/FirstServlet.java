package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = super.getServletConfig();
		
	     PrintWriter out = response.getWriter();
	     
	     String country = config.getInitParameter("Country");
	     out.write("<h1 text-align='center'>Country :::: " + country + "</h1>");
	     out.write("<br>");
	     
	     
	     
	     Enumeration<String> cf = config.getInitParameterNames();
	     
	     out.write("<table border='2' align = 'center' font-size='14px' >");
	     while(cf.hasMoreElements()) {
	    	 String name = cf.nextElement();
	    	 String value = config.getInitParameter(name);
	    	 out.write("<td>" + name + "</td>");
			   out.write("<td>" + value + "</td>");
			   out.write("</tr>");
	     }
	     out.write("</table>");
	     
	}

}
