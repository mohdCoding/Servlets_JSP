

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
         String email = request.getParameter("email");
         String mobile = request.getParameter("mobile");
         
         PrintWriter out = response.getWriter();
         
         HttpSession session = request.getSession(true);
         session.setAttribute("email", email);
         session.setAttribute("mobile", mobile);
         
         Enumeration<String> attrNames = session.getAttributeNames();
         
         out.println("<table border = '2' >");
         while(attrNames.hasMoreElements()) {
        	 out.println("<tr>");
        	 String attrName = attrNames.nextElement();
        	 String attrValue = (String) session.getAttribute(attrName);
        	 out.println("<td>" + attrName + "</td><td>" + attrValue + "</td>");
        	 out.println("</tr>");
         }
         out.println("</table>");
         
	}

}
