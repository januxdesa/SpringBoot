<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>


	<div class="container">
		<h1>You have visited <a href="http://localhost:8080">http://localhost:8080</a> <c:out value="${count}"/> times </h1>
		
		<h2><a href="http://localhost:8080">Test Another Visit</a>  </h2>
		<h2><a href="http://localhost:8080/acceso2">Test Another Visit 2</a>  </h2>
		
	</div>
	
</body>
</html>