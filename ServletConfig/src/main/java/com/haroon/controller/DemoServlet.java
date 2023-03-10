package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletConfig config= super.getServletConfig();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		out.write("<html><head><title>ContextDetails</title><style>table tr td {font-size:20px;color:red; }</style></head>");
		out.write("<body><h1><center>ServletContext Details</center></h1>");
		out.write("<table align='center' border='2'><tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
		
		Enumeration<String> parameterNames = config.getInitParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			String parameterValue = config.getInitParameter(parameterName);
			out.write("<tr><td>" + parameterName + "</td><td>" + parameterValue + "</td></tr>");
		}
		
	
		
	    ServletContext context= super.getServletContext();
		String com = config.getInitParameter("Company");
		out.write("<tr><td>Company</td><td>" + com + "</td></tr>");
		
Enumeration<String> contextParameterNames = config.getInitParameterNames();
out.write("<tr><th>Context Parameter Name</th><th>Context Parameter Value</th></tr>");
		while(contextParameterNames.hasMoreElements()) {
			String cparameterName = contextParameterNames.nextElement();
			String cparameterValue = config.getInitParameter(cparameterName);
	
			out.write("<tr><td>" + cparameterName + "</td><td>" + cparameterValue + "</td></tr>");
		}
		
		out.write("<tr><td>Company</td><td>" + com + "</td></tr>");
		
		
		
	  
		
		out.write("</table></body></html>");
		
		out.flush();
		out.close();
	}

}
