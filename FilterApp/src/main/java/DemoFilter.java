

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/test")
public class DemoFilter implements Filter {
       
    
	static {
		System.out.println("Filter is loading...");
	}
	public DemoFilter() {
		System.out.println("Filter Object is instantiated...");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialization....");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//filter prepocesing logic is coded
		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by Demo Filter before procesing the request...</h1>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		//filter postprocessing logic is coded
		out.println("<h1>This line is added by Demo Filter after procesing the request...</h1>");
	}
	
	public void destroy() {
		System.out.println("Filter Object is deInstantiated...");
	}
	

}
