<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<style>
   body {
      background-color:blue;
      color: red;
   }
   
   h1 {
      background-color:yellow;
      padding:10px;
      font-size:28px;
      margin:30px;
    }
</style>
</head>
<body>
    <h1>The error occured is :: <%= exception %></h1>
</body>
</html>