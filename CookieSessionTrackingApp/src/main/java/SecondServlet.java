

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String cost = request.getParameter("cost");
		String quantity = request.getParameter("quantity");
		
		Cookie c3 = new Cookie("cost", cost);
		Cookie c4 = new Cookie("quantity", quantity);
		
		response.addCookie(c3);
		response.addCookie(c4);
		
		RequestDispatcher rd = request.getRequestDispatcher("./Form3.html");
		rd.forward(request, response);
		
		
	}

}
