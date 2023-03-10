

import java.io.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class Third
 */
@WebServlet("/Third")
public class Third extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		 Cookie[] cookies = request.getCookies();
		 System.out.println("Hey dude :: " + cookies[1].getValue());
		 System.out.println("Request Object  :: " + request.hashCode());
		 System.out.println("Response Object :: " + response.hashCode());
	     System.out.println("PrintWriter OBj :: " + out.hashCode());
	     
	     
	}

}
