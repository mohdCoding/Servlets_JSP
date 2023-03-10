package com.haroon.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/FirstServlet"}, loadOnStartup = 10)
public class FirstServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FirstServlet() {
        System.out.println("Initializing");
    }
    
    public void service(ServletRequest request, ServletResponse response) throws IOException {
    	
    	PrintWriter out = response.getWriter();
    	out.write("<html><head><title>FirstWebAppp</title><style>h1{background:red;color:yellow;text-align:center;}</style></head>");
    	out.write("<body><h1 bgcolor =' " + "red' >HI Java Servlet</h1></body></html>");
    	out.close();
    }




}
