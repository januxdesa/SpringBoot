<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-4 offset-sm-4">
				<h4>Welcome to Lookify!!!</h4>
			</div>
			<div class="col-sm-4 offset-sm-4">
				<a href="/dashboard" > Start Looking!!</a>
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