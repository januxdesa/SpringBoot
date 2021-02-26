<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Gold</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>

	<div class="container">

		<div class="row p-3">
			<div class="col-sm-4">
			<h3>Tu gold : <c:out value="${ gold }"/> </h3>
			</div>

		</div>

		<div class="row p-3">

			<div class="col-sm-3 ">
				<form class="border text-center p-2" method="POST" action="/gold" >
					<h3>FARM</h3>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="result" value="farm" >
					<button class="btn btn-primary">Find Gold</button>
				</form>
			</div>

			<div class="col-sm-3">
				<form class="border text-center p-2" method="POST" action="/gold" >
					<h3>CAVE</h3>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="result" value="cave" >
					<button class="btn btn-primary">Find Gold</button>
				</form>
			</div>

			<div class="col-sm-3">
				<form class="border text-center p-2" method="POST" action="/gold" >
					<h3>HOUSE</h3>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="result" value="house" >
					<button class="btn btn-primary">Find Gold</button>
				</form>
			</div>

			<div class="col-sm-3">
				<form class="border text-center p-2" method="POST" action="/gold" >
					<h3>CASINO</h3>
					<p>(earns/takes 0-50 gold)</p>
					<input type="hidden" name="result" value="casino">
					<button class="btn btn-primary" >Find Gold</button>
				</form>
			</div>


		</div>

		<div class="row p-3">
			<div class="col-sm-10 offset-sm-2">
			
			
			<div class="panel panel-primary" id="result_panel">
    			<div class="panel-heading"><h3 class="panel-title">Activities:</h3>
    			</div>
    			<div class="panel-body">
    
				<ul class="list-group">
	              
	             <c:forEach var="l" items="${log}" >
	             	${l}
	             </c:forEach>
	
	
				</ul>
			 	</div>
			</div> 	
			 
				
			
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