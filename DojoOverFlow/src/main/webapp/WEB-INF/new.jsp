<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1><c:out value="${ msg }"/> </h1>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				<h1> New Questions </h1>
			</div>			
			<div class="col-sm-6 offset-sm-3">
				
			</div>		
						<form action="/questions/new" method="post" modelattribute="nuevo">
  							  <label for="question">Questions:</label><br>
							  <input type="text" id="question" name="question" ><br>
							  <label for="subjet">Subjet:</label><br>
							  <input type="text" id="subjet" name="subjet" ><br><br>
							  <input type="submit" value="Submit">
						</form> 
						
						
			<div class="col-sm-3 offset-sm-6">			
			   <a href="/questions/new"> New Question</a>
			</div>
		</div>
	</div>
</body>
</html>