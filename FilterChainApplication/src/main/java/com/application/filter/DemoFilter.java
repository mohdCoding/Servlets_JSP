package com.application.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter("/test1")
public class DemoFilter extends HttpFilter implements Filter {
       
	private FilterConfig config;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public DemoFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 ServletContext context = config.getServletContext();
		 PrintWriter out = response.getWriter();
		 out.write("<h1>This is demofilter preprocessing logic</h1>");
		 HttpServletRequest req1 = (HttpServletRequest) request;
	
		 context.log("A request is coming from :: " + 
		 req1.getRemoteHost() + " for URL :: " + req1.getRequestURL() + " at the date :: " + 
				 new java.util.Date());
		chain.doFilter(request, response);
		out.write("<h1>This is demofilter post processing logic</h1>");
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}
	

}
