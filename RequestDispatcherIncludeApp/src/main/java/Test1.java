

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  PrintWriter out	= response.getWriter();
	   
	  request.setAttribute("HELLO", "JAVA");
	  
	  out.println("<h1>Hello THis is firstServlet</h1>");
	  RequestDispatcher rd = request.getRequestDispatcher("./test2");
	  rd.include(request, response);
	  out.flush();
	  
	  System.out.println("request object     :: " + request.hashCode());
	  System.out.println("response object    :: " + response.hashCode());
	  System.out.println("PrintWriter Object :: " + out.hashCode());
	  
	  out.println("<h1>Control coming to first Servlet again</h1>");
	  
	 
	  
	}

}
