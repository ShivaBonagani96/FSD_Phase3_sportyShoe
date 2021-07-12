<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="/register" method="post" >
  
   <label for="name">Username:</label><br> <input type="text" id="name" name="name"><br>
  <label for="email">Email:</label><br>  <input type="text" id="email" name="email" ><br>
  <label for="password">Password:</label><br> <input type="password" id="password" name="password" ><br> 
  <br>
  <input type="submit" value="Submit">
	<a href="/" >Already Have an Account ? login Here</a>
	
	
	</form>
</body>
</html>