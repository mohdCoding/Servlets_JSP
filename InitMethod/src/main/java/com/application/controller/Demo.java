package com.application.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class Demo extends HttpServlet {
	
	public void init(ServletConfig config) {
		System.out.println("config init method");
		init();
		
	}
  
	public void init() {
		System.out.println("developer init method");
	}
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	System.out.println("Inside service method");
    	
    	ServletConfig config = getServletConfig();
    	System.out.println("COnfig object :: " + config);
    }
	 
    public void destroy() {
    	System.out.println("inside destroy method");
    }
	

}
