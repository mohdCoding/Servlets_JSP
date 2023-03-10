package com.haroon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = super.getServletContext();
		String clubName = context.getInitParameter("Club");
		PrintWriter out = response.getWriter();
		context.setAttribute("jdbc", "Java Database Connectivity");
		context.setAttribute("Servlet", "Used to accept/send request and response");
		
		String jdbc =String.valueOf(context.getAttribute("jdbc")); 
		out.write("<h1><center>jdbc :: " + jdbc + "</center></h1>");
		
		
	   Enumeration<String> attrNames = context.getAttributeNames();
	   
	   while(attrNames.hasMoreElements()) {
		   String aname = attrNames.nextElement();
		   String avalue =String.valueOf(context.getAttribute(aname)); 
		   out.write("<h1>" + aname + " :: " + avalue + "</h1>");
		   out.write("<br><br>");
	   }
		
		out.write("<h1> CLUB NAME ::: " + clubName + "</h1>");
		out.println("<br><br>");
		
		Enumeration<String> cd = context.getInitParameterNames();
		
		while(cd.hasMoreElements()) {
			String cname = cd.nextElement();
			String cvalue = context.getInitParameter(cname);
			out.write("<h1>" + cname + " :: " + cvalue + "</h1>");
		}
		
	}

}
