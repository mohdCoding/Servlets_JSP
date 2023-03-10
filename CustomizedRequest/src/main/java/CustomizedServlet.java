

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedServlet extends HttpServletRequestWrapper {

	public CustomizedServlet(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String word) {
		
		String word1 = super.getParameter(word);
		System.out.println(word1);
		
		if (word1.equalsIgnoreCase("JAVA")|| word1.equalsIgnoreCase("JEE")||word1.equalsIgnoreCase("SpringBoot")) 
			return "iNeuron";
		else
			return word1;
	}
	
	
	
}
