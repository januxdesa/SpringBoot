<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row p-4">
			<div class="col-sm-3">
				<a href="/songs/new">Add New</a>
			</div>
			<div class="col-sm-3">
				<a href="">DashBoard</a>
			</div>
			<div class="col-sm-6">
				<form action="action="/dashboard" method="post" >
					<input type="search" name="search">
					<button class="btn btn-primary">Consulta</button>
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
	              
	             <c:forEach var="l" items="${playlists}" >
	             <li>	${l.tittle} </li>
	             <li>	${l.rating}	</li>
	             </c:forEach>
	
	
				</ul>
			 	</div>
			</div> 	
			 
				
			
			</div>
		</div>
	</div>

	
</body>
</html>