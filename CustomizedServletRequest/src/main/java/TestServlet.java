

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// HttpServletRequest request = new CustomizedServletRequest();
		String word = request.getParameter("word");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hey This is the word you have typed :: " + word + "</h1>");
		
	}

}
