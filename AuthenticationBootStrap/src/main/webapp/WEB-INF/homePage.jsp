<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet"  href="css/bootstrap.min.css">
	
</head>
<body>
	<div class="container">
		<div class="row p-4">
			<div class="col-sm-9">
				<h3>Welcome, <c:out value="${user.email}" /></h3>
			</div>
			<div class="col-sm-3">
				<a href="/logout">Logout</a>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>