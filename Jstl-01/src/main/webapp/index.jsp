<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="mytag" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <!-- 
 <h1><mytag:out value="Welcome to Jstl coding..." /></h1>
 <h1>The user name is <mytag:out value="${param.name}"/></h1>
 <h1>The Password is <mytag:out value="${param.password}" default="Coding"/></h1>
 -->
 
 <mytag:set var='x' value='20' scope='request'/>
 <mytag:set var='y' value='30' scope='request'/>
 <mytag:set var='sum' value='${x+y}' scope='session'/>
 
 <mytag:out value='The result is:: ${sum}'/>
 
 <mytag:remove var='x'/>
 <mytag:remove var='y'/>
 <mytag:remove var='sum' />
 
 <h1>
    The result is :: <mytag:out value='${sum}' default="1000" />
 </h1>
</body>
</html>