

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name", "Mohammed Haroon");
		request.setAttribute("age", 19);
		request.setAttribute("Favourite", "Football");
		
		PrintWriter out = response.getWriter();
		
	
		RequestDispatcher rd = request.getRequestDispatcher("./test2");
		rd.forward(request, response);
		
		
		
	}

}
