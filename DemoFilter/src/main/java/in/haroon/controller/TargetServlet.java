package in.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static {
		System.out.println("Loading......");
	}
	
	
    public TargetServlet() {
       System.out.println("Initializing....");
    }
    
    public void init() {
    	System.out.println("Instantiation.....");
    }
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		out.write("<h1>THis is a response from Target Servlet");
		
	}
	
	public void destroy() {
		System.out.println("The servlet is destroyed");
	}

}
