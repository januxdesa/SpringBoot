<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<link rel="stylesheet" href="css/styles.css" />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" />
</head>
<body>

	<div class="container  ">
		<div class="row">
			<div class="col-sm-4 offset-sm-4">
				<h1> <c:out value="${error} "/></h1>
				<form class="border p-3 " method="POST" action="/result">
									
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="name">Your Name:</label>
						<div class="col-sm-6">
						<input type="text" name="name">
						</div>
					</div>
					
				
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="location">Dojo Location:</label>
						<div class="col-sm-6">
						<select name="location" id="location">
 	 							<c:forEach items="${location}" var="item">
   								 	<option value= "${item}"> ${item}</option>
								</c:forEach>
						</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-6 col-form-label" for="language">Favorite Language:</label>
						<div class="col-sm-6">
						<select name="language" id="language">
 	 							<c:forEach items="${language}" var="item">
   								 	<option value= "${item}"> ${item}</option>
								</c:forEach>
						</select>
						</div>
					</div>
					<div class="form-group">
						<label for="Comment">Comment (Optional):</label>
						<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary" > Submit</button>
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