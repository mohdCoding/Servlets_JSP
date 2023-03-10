

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.utility.JdbcConnectivity;

import java.sql.*;

@WebServlet("/test1")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public void init() {
		
		try {
			connection = JdbcConnectivity.getConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aname = request.getParameter("aname");
		String apwd = request.getParameter("apwd");
		
		if(connection != null) {
			String query = "select name, password from admin_db";
			try {
				pstmt = connection.prepareStatement(query);
			     if(pstmt != null) {
			    	 resultSet = pstmt.executeQuery();
			    	 
			    	 if(resultSet != null) {
			    		 
			    		 if(resultSet.next()) {
			    			 String dbName = resultSet.getString(1);
			    			 String dbPassword = resultSet.getString(2);
			    			 
			    			 if(aname.equals(dbName) && apwd.equals(dbPassword)) {
			    				 //navigate to inbox.jsp
			    				 
			    				 ServletContext context = getServletContext();
			    				 RequestDispatcher rd = context.getRequestDispatcher("/inbox.jsp");
			    				 rd.forward(request, response);
			    			 } else {
			    				 // navigate error.jsp
			    				 RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			    				 rd.forward(request, response);
			    				 System.out.println("HEllo");
			    			 }
			    		 }
			    	 }
			     }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	public void destroy() {
		
		try {
			JdbcConnectivity.closeConnection(connection, pstmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
