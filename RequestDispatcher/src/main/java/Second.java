

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class Second
 */
@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		 
		 System.out.println("Request Object  :: " + request.hashCode());
		 System.out.println("Response Object :: " + response.hashCode());
	     System.out.println("PrintWriter OBj :: " + out.hashCode());
	     
	     request.setAttribute("Hello", "World");
		Cookie c1 = new Cookie("Hello", "Java");
		response.addCookie(c1);
		RequestDispatcher rd = request.getRequestDispatcher("./input.html");
		rd.forward(request, response);
		
	
	}

}
