package com.haroon.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.html.HTMLFieldSetElement;


@WebServlet("/calma")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("Loading...........");
	}

    public ImageServlet() {
       System.out.println("Initializing........");
    }
    
    @Override
    public void init() {
    	System.out.println("Instantiation..........");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// "C:\\Users\\ADMIN\\Desktop\\Calma calma.jpg"
		response.setContentType("image/jpg");
		
		// ServletOutputStream sos = response.getOutputStream();
		// String path = getServletContext().getRealPath("nitin.JPG");
		File file = new File("C:\\Users\\ADMIN\\Desktop\\Calma calma.jpg");
		FileInputStream fis = new FileInputStream(file);
	    FileOutputStream fos = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\ronaldo.jpg");
		byte[] buffer = new byte[(int) file.length()];
		
		while(fis.read(buffer) != 0 ) {
			fos.write(buffer);
		}
		

		
		
//		sos.flush();
//		sos.close();
		fis.close();
		fos.flush();
		fos.close();
		
		
	
	}
	
	
	@Override
	public void destroy() {
		System.out.println("DeInstantiation");
	}



}
