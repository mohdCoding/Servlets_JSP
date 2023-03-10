<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>
    <c:forEach begin="1" end="10" var="count" step="2">
      Welcome to Jstl Coding :: ${count}<br>
    </c:forEach>  
  </h1>
  
  <%
    String[] names = {"Hello","Java","Python","Javascript"};
    pageContext.setAttribute("names", names);
    
    ArrayList<String> al = new ArrayList<String>();
    al.add("Cristiano Ronaldo");
    al.add("MR.UCL");
    al.add("Ronaldo Rocket");
    al.add("TOO far for ronaldo to think about it");
    al.add("HE is simply the GOAT");
    pageContext.setAttribute("al", al);
    
  %>
  
  <c:forEach items="${names}" var="name">
     <h1>The current value is :: ${name}</h1>
     
  </c:forEach>
  
  <c:forTokens items="Cristiano|Ronaldo|Dos|Santos|Aveiro" delims="|" var='name'> 
     <h1>The Name is :: ${name}</h1>
  </c:forTokens>
  
  <c:forTokens items="Karim, Benzema, Mesut Ozil, Sergio Ramos" delims="," var='name'>
     <h1>The Value is :: ${name}</h1>
  </c:forTokens>
   <br>
   <br>
   <br>
 
 <c:forTokens items="one,two,three,four,five,six,seven" delims="," var="data" begin="2" end="5" step="2">
    <h1>The data is ${data}</h1>
 </c:forTokens>
 
  <c:forEach items="${al}" var="data">
    <h1>The Goat things ::  ${data}</h1>
 </c:forEach>
 
 
  
  
</body>
</html>