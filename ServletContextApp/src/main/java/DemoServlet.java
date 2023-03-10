import javax.servlet.ServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;
public class DemoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ServletContext context= super.getServletContext();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		context.setAttribute("Mohammed Haroon", "Love For Java");
		context.setAttribute("Haroon", "I Write Code");
		context.setAttribute("Cristiano Ronaldo Dos Santos Aveiro", "The GOAT no:7");
		
		out.write("<html><head><title>ContextDetails</title><style>table tr td {font-size:20px;color:red; }</style></head>");
		out.write("<body><h1><center>ServletContext Details</center></h1>");
		out.write("<table align='center' border='2'><tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
		
		Enumeration<String> parameterNames = context.getInitParameterNames();
		
		while(parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			String parameterValue = context.getInitParameter(parameterName);
			out.write("<tr><td>" + parameterName + "</td><td>" + parameterValue + "</td></tr>");
		}
		out.write("<tr><th>Attribute Value</th><th>Attribute Value</th></tr>");
		Enumeration<String> attrNames = context.getAttributeNames();
		
		while(attrNames.hasMoreElements()) {
			String attrName  = attrNames.nextElement();
			String attrValue = String.valueOf(context.getAttribute(attrName));
			out.write("<tr><td>" + attrName + "</td><td>" + attrValue + "</td></tr>");
		}
		
		out.write("</table></body></html>");
		
		out.flush();
		out.close();
	}
}
