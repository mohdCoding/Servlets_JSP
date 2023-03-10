import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedServletRequest extends  HttpServletRequestWrapper {
	
	public CustomizedServletRequest(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public String getParameter(String word) {
		
		word = super.getParameter(word);
		
		if(word.equalsIgnoreCase("Java") || 
				word.equalsIgnoreCase("JEE") || 
				  word.equalsIgnoreCase("Navin reddy"))  {
			 
			return "Telusko";
		}
			          
		
		return word;
		
	}
	
	

}
