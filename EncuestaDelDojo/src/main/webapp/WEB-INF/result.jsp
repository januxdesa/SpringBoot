<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="css/styles.css" />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>

	<div class="container  ">
		
		<div class="row">
			
			<div class="col-sm-4 offset-sm-4">
				<form class="border p-3 " method="POST" action="/">
					
				<h1>Submitted Info</h1>
					
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="name">Name:</label>
						<div class="col-sm-6">
						<label class="col-sm-6 col-form-label" for="name"><c:out value="${name}"/> </label>
						</div>
					</div>
					
				
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="location">Dojo Location:</label>
						<div class="col-sm-6">
						<label class="col-sm-6 col-form-label" ><c:out value="${location}"/> </label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="language">Favorite Language:</label>
						<div class="col-sm-6">
						<label class="col-sm-6 col-form-label" ><c:out value="${language}"/> </label>
					
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="Comment">Comment (Optional):</label>
						<div class="col-sm-6">
							<label for="Comment"><c:out value="${comment}"/></label>
						</div>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary" > Go Back </button>
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