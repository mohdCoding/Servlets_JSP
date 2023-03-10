

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		 System.out.println("Request Object  :: " + request.hashCode());
		 System.out.println("Response Object :: " + response.hashCode());
		 System.out.println("name            :: " + request.getAttribute("name"));
		  Cookie[] cookies = request.getCookies();
		  for(Cookie c : cookies) {
			  System.out.println(c.getValue());
		  }
		 PrintWriter out = response.getWriter();
		 System.out.println("PrintWriter OBj :: " + out.hashCode());
		 
	}

}
