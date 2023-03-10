package com.haroon.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = super.getServletContext();
		PrintWriter out = response.getWriter();
	Enumeration<String> cd = context.getInitParameterNames();
		
		while(cd.hasMoreElements()) {
			String cname = cd.nextElement();
			String cvalue = context.getInitParameter(cname);
			out.write("<h1>" + cname + " :: " + cvalue + "</h1>");
		}
		
		out.write("<p>==========================<h1><atttributes></h1>==================</p><br><br>");
		
		  Enumeration<String> attrNames = context.getAttributeNames();
		   
		  out.write("<table border='2' align = 'center' font-size='14px' >");
		   while(attrNames.hasMoreElements()) {
			   out.write("<tr>");
			   String aname = attrNames.nextElement();
			   String avalue =String.valueOf(context.getAttribute(aname)); 
			   out.write("<td>" + aname + "</td>");
			   out.write("<td>" + avalue + "</td>");
			   out.write("</tr>");
			   
		   }
		  out.write("</table>");
		
		
		
	}

	
}
