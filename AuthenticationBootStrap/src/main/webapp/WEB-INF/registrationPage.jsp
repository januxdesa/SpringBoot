<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet"  href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	 	<div class="row"> 
	 		<div class="col-sm-4 offset-sm-4">
		    <h1>Register!</h1>
		    </div>
		    <div class="col-sm-4 offset-sm-4">
		    <p><form:errors path="user.*"/></p>
		    </div>
		    <div class="col-sm-4 offset-sm-4">
		    <form:form method="POST" action="/registration" modelAttribute="user">
		        <div class="form-group">
		            <form:label path="email">Email:</form:label>
		            <form:input class="form-control" type="email" path="email"/>
		        </div>
		         <div class="form-group">
		            <form:label path="password">Password:</form:label>
		            <form:password  class="form-control" path="password"/>
		        </div>
		        <div class="form-group">
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password class="form-control" path="passwordConfirmation"/>
		        </div>
		         <div class="form-group">
		        <input class="btn btn-primary" type="submit" value="Register!"/>
		        </div>
		    </form:form>
		    </div>
		    </div>
    </div>
	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>