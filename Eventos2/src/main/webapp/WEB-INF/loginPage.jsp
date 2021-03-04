<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet"  href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			
			<div class="col-sm-4 offset-sm-4">
				    <h1>Login</h1>
			</div>
			<div class="col-sm-4 offset-sm-4">
			
				    <p><c:out value="${error}" /></p>
			</div>
			<div class="col-sm-4 offset-sm-4">
			
				    <form  class="border rounded p-3 " method="post" action="/login">
				        <div class="form-group">
				            <label for="email">Email</label>
				            <input class="form-control" type="text" id="email" name="email"/>
				        </div>
				        <div class="form-group">
				            <label for="password">Password</label>
				            <input class="form-control" type="password" id="password" name="password"/>
				        </div>
				        <div class="form-group">
				        <input class="btn btn-primary" type="submit" value="Login!"/>
				          </div>
				    </form>
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