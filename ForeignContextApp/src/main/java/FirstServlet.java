

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	ServletContext context = getServletContext();
	ServletContext fc = context.getContext("/DemoProject");
	RequestDispatcher rd =fc.getRequestDispatcher("/FirstServlet");
	rd.forward(request, response);
	
		
		
		
		
		
	}

}
