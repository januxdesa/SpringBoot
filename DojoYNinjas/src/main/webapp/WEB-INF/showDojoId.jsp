<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    

<c:set var="assets" value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${assets}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				
				
				<c:forEach var="d" items="${ dojos }">
				<h1><c:out value="${d.name}"/></h1>
				
				</c:forEach>
				<table class="table">
				<tr>
					<th> FirstName </th>
					<th> LastName</th>
					<th> Age </th>
					
				</tr>
				<c:forEach var="c" items="${ ninjas }">
				<tr>
				<td><c:out value="${ c.firstName}"/></td>
				<td><c:out value="${ c.lastName}"/></td>
				<td><c:out value="${ c.age}"/></td>
		
				</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>