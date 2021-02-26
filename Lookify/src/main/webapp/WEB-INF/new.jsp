<!-- <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<a href="/languages">DashBoard</a>
<a href="/languages/${language.id}/delete">Delete</a> 
<h1>Edit Languages</h1>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">CurrentVersion</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
     
    <input type="submit" value="Submit"/>
</form:form> -->
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
<title>Languages</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


</head>
<body>

	<div class="container">
		<div class="row  justify-content-md-center">	
			<h1>New Songs</h1>
		</div>
		<div class="row justify-content-md-end">	
			<div class="col-sm-4 offset-sm-4">
			<a class="btn btn-primary" href="/languages">DashBoard</a> 
			<a class="btn btn-primary" href="/languages/${language.id}/delete">Delete</a>
			</div>
			
		</div>	
		
			<form:form action="/songs/new" method="post" modelAttribute="playlist" cssClass="form-control">
				
				
					<div class="row p3">
						<div class="col-sm-3">
							<form:label path="name">Name</form:label>
							<form:errors path="name" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" />
						</div>


						<div class="col-sm-3">
							<form:label path="creator">Creator</form:label>
							<form:errors path="creator" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="creator" cssClass="form-control" />
						</div>


						<div class="col-sm-3">
							<form:label path="currentVersion">CurrentVersion</form:label>
							<form:errors path="currentVersion" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="currentVersion" cssClass="form-control" />
						</div>
						</div>
						
							<div class="col-sm-3 offset-sm-9">
								<input class="btn btn-primary" type="submit" value="Submit" />
							</div>
			</form:form>
		</div>
	</div>


</body>
</html>