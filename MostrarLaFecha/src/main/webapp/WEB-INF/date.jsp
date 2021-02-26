<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATE</title>
<script src="js/script.js"></script>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<div class="green">
			<h1><c:out value="${date}"  /></h1>
		</div>
	</div>

</body>
</html>