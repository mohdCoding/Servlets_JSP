

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mdate = request.getParameter("mdate");
		String edate = request.getParameter("edate");
		
	    
		 Cookie[] cookies = request.getCookies();
		 
		 PrintWriter out = response.getWriter();
		 
		 out.println("<table border='2' ");
		 
		 for(Cookie cookie: cookies) {
			 out.println("<tr>");
			 out.println("<td>" + cookie.getName() + "</td>");
			 out.println("<td>" + cookie.getValue() + "</td>");
			 out.println("</tr>");
		 }
		 out.println("<tr>");
		 out.println("<td>Manufacture Date</td>" + "<td>" + mdate + "</td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<td>Expiry Date</td>" + "<td>" + edate + "</td>");
		 out.println("</tr>");
		 out.println("</table>");
		 out.flush();
		 out.close();
		 
		 }

}
