package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/demo"}, loadOnStartup = 20)
public class DemoServlet extends HttpServlet{
	
	
	static {
    	System.out.println("Loading DemoServlet..........");
    }
    
    
    public DemoServlet() {
       System.out.println("Initialization DemoServlet........");
    }
    
    public void init() {
    	System.out.println("Instatiating DemoServlet.............");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println("<html><head><title>DemoApp</title></head><body><table border='2' align='center'>");
    	out.println("<tr><th>Client Ip Addr</th><td>"+ request.getRemoteAddr() +"</td></tr>");
    	out.println("<tr><th>Client Host</th><td>"+ request.getRemoteHost() +"</td></tr>");
    	out.println("<tr><th>Client Por</th><td>"+ request.getRemotePort()  +"</td></tr>");
    	out.println("<tr><th>Server Name</th><td>"+ request.getServerName() +"</td></tr>");
    	out.println("<tr><th>Server Port</th><td>"+ request.getServerPort() +"</td></tr>");
    	out.println("<tr><th>Remote User</th><td>"+ request.getRemoteUser() +"</td></tr>");
    	out.println("</table></body></html>");
    	
    	System.out.println("Hello world");
    	
    	out.flush();
    	out.close();
    	
 
 
    }
    
    

}
