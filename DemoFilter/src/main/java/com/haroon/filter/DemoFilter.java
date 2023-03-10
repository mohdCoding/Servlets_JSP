package com.haroon.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/test")
public class DemoFilter extends HttpFilter implements Filter {
   
	static {
		System.out.println("Loading...");
	}
    public DemoFilter() {
       System.out.println("Initializing...");
    }

     public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Instantiation....");
	 }
	
		
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
    	PrintWriter out = response.getWriter();
    	out.write("<h1>THis is filter request preprocessiong logic</h1>");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.write("<h1>THis is the request postprocession logic</h1>");
	}

	public void destroy() {
		System.out.println("Destroyed....");
	}
	
	

}
