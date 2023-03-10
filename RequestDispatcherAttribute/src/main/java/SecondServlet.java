

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		

		Object name = request.getAttribute("name");
		Object age = request.getAttribute("age");
		Object fav = request.getAttribute("fav");
		out.println("<h1>name :: " + name + "</h1><br><br>");
		out.println("<h1>age :: " + age + "</h1><br><br>");
		out.println("<h1>fav :: " + fav + "</h1><br><br>");
		
		Enumeration<String> attr = request.getAttributeNames();
		
		out.println("<table border='2' >");
		while(attr.hasMoreElements()) {
			out.println("<tr>");
			String attrName = attr.nextElement();
			String attrValue = (String) request.getAttribute(attrName);
			out.println("<td>" + attrName + "</td><td>" + attrValue +"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		
		
	}

}
