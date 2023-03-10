package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/test"}, loadOnStartup = 20)
public class BrowserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static {
    	System.out.println("Loading..........");
    }
    
    
    public BrowserDetails() {
       System.out.println("Initialization........");
    }
    
    public void init() {
    	System.out.println("Instatiating.............");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
	    Enumeration<String> headerNames = request.getHeaderNames();
	    
	    out.println("<html><head><title>BrowserDetails</title></head>");
	    out.println("<body><h1><center>Browser Header Details</center></h1>");
	    out.println("<table border='2' align='center'>");
	    out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
	    String headerName;
	    while(headerNames.hasMoreElements()) {
	    	headerName = headerNames.nextElement();
	    	String headerValue = request.getHeader(headerName);
	    	out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
	    }
	    out.println("</table></body></html>");
	    
	   
	    
	    
	}
	
	
	public void destroy() {
		System.out.println("DeInstatiation............");
	}

}
