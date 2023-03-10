

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getAttribute("HELLO"));
		out.println("<h1>This is Second Servlet</h1>");
		
		  System.out.println("request object     :: " + request.hashCode());
		  System.out.println("response object    :: " + response.hashCode());
		  System.out.println("PrintWriter Object :: " + out.hashCode());
	}

}
