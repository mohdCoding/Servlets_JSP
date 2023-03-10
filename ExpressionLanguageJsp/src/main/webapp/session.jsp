<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = 'true' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      session.setAttribute("Name", "Haroon");
      session.setAttribute("Age", 19);
   %>
   
   <h1>My name is :: <%= session.getAttribute("Name") %></h1>
   <h1>My age  is :: <%= session.getAttribute("Age") %></h1>
</body>
</html>