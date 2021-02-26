<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TIME</title>
<script src="js/script.js"></script>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<div class="blue">
			<h1><c:out value="${time}"  /></h1>
		</div>
	</div>
</body>
</html>