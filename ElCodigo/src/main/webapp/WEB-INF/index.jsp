<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Código</title>
<link rel="stylesheet" href="css/styles.css" />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>

	<div class="container  text-center">
		<div class="row">
			<div class="col-sm-4 offset-sm-4">
				
				
					<h1 class="bg-danger text-white rounded-pill "><c:out value="${ error }" />
				</h1>
			
					<h4>What is the code ?</h4>
				
				<form method="POST" action="/code">
					<div class="form-group">
						<input type="password" name="password">
					</div>
					<div class="form-group">
						<button class="btn btn-primary" >Try Code</button>
					</div>
				</form>
				
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