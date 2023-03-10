package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/first", "/zero"}, initParams = {
		
		@WebInitParam(name = "Mentor", value = "Nithin Manjunath"),
		@WebInitParam(name = "Age", value = "28"),
		@WebInitParam(name = "Expert", value = "Java FullStack")
})
public class FirstServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletConfig config= getServletConfig();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			
			out.write("<html><head><title>ConfigDetails</title><style>table tr td {font-size:20px;color:red; }</style></head>");
			out.write("<body><h1><center>ServletConfig Details</center></h1>");
			out.write("<table align='center' border='2'><tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
			
			Enumeration<String> parameterNames = config.getInitParameterNames();
			
			while(parameterNames.hasMoreElements()) {
				String parameterName = parameterNames.nextElement();
				String parameterValue = config.getInitParameter(parameterName);
				out.write("<tr><td>" + parameterName + "</td><td>" + parameterValue + "</td></tr>");
			}
		
			 ServletContext context= getServletContext();
				String jdbc = config.getInitParameter("jdbc");
				out.write("<tr><td>Jdbc</td><td>" + jdbc + "</td></tr>");
		
			
			out.write("</table></body></html>");
			
			out.flush();
			out.close();
	}
}
