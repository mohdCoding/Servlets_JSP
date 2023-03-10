

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		 System.out.println("Request Object  :: " + request.hashCode());
		 System.out.println("Response Object :: " + response.hashCode());
		 PrintWriter out = response.getWriter();
		 
	     Cookie c1 = new Cookie("AGE", "19");
	     response.addCookie(c1);
		 
		 request.setAttribute("name", "Haroon");
		 System.out.println("PrintWriter OBj :: " + out.hashCode());
		 RequestDispatcher rd = request.getRequestDispatcher("./test2");
		 
		 // request object will be send to the servlet without any change
		 // but the data of response obj will be flushed and sent with respect to servlet to servlet
		 rd.forward(request, response);
		 
		 
	}

}
