

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet loading....");
	}

	public TestServlet() {
		System.out.println("Servlet Instantiation...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialization....");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request processing phase.....");
		PrintWriter out = response.getWriter();
		out.println("<h1>This is the response from Target Servlet</h1>");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet De-Instantiation...");
	}
}
