

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/test1")
public class LogFilter implements Filter {

	private FilterConfig config;

	static {
		System.out.println("LogFilter Loading...");
	}

	public LogFilter() {
		System.out.println("LogFilter instantiation...");
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("LogFilter initialization...");
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by the Log filter before processing the request</h1>");

		ServletContext context = config.getServletContext();
		HttpServletRequest req1 = (HttpServletRequest) request;
		System.out.println(config);
		
		context.log("A request is coming from :: " + req1.getRemoteHost() + " for URL :: " + req1.getRequestURL()
				+ " at date  :: " + new Date());

		// pass the request along the filter chain
		chain.doFilter(request, response);

		out.println("<h1>This line is added by Log filter after processing the request....</h1>");

	}

	public void destroy() {
		config= null;
		System.out.println("LogFilter DeInstantiation...");
	}
}
