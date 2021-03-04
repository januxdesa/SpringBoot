<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="row p-4">
			<div class="col-sm-12">
			
			</div>


			
				<div class="row">
					<div class="col-sm-6">

						<c:forEach var="s" items="${eventos}">
							<h3>
								<c:out value="${s.name}" />
							</h3>

							<p> <c:out value="Host: ${s.userEvent.firstName} ${s.userEvent.lastName}" />
							</p>
							<p> <c:out value="Date: ${s.dateEvent} " />
							</p>
							<p> <c:out value="Location: ${s.ubication}" />
							</p>
						</c:forEach>
					</div>
					<div class="col-sm-6">
						
						<p>${uhe}</p>
						
					 <c:forEach var="s" items="${uhe2}">
					 	<p>${ s.asistente.firstName } ${ s.asistente.lastName }</p>			
					</c:forEach>

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