<%@ page import = 'java.util.Date' %>

<%! 
    Date d = null;
    String date = "";
%>
<!-- Hey this is html comments -->
<%
  
   d = new Date();
   date = d.toString();
   
%>

<h1>
  Today's Date in tamilnadu in madurai is :: <%= date %>
</h1>