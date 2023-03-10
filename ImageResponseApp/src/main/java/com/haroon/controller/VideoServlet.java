package com.haroon.controller;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		 response.setContentType("video/mp4");
		 
		 ServletOutputStream sos= response.getOutputStream();
		 
		 File file=new File("G:\\Walpapers\\ronaldo_status.mp4");
		 FileInputStream fis=new FileInputStream(file);
		 
		 byte b[] = new byte[(int)file.length()];
		 
		 fis.read(b);
		 
		 sos.write(b);
		 
		 fis.close();
		 sos.close();
		 
		 
	}

	
}
