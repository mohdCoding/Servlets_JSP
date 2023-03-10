

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qual = request.getParameter("qual");
		String design = request.getParameter("design");
		
		HttpSession session = request.getSession();
		session.setAttribute("qual", qual);
		session.setAttribute("design", design);
		
		 RequestDispatcher rd = request.getRequestDispatcher("./Form3.html");
		 rd.forward(request, response);
		 
		
	}

}
