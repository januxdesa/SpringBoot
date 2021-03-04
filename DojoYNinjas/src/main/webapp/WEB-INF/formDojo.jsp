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
<title>New Dojo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				<h1>New Dojo</h1>
				<form:form action="/dojo/new" method="post"
					modelAttribute="dojo" cssClass="form-control">

					<div class="row p4">
						<div class="col-sm-3">
							<form:label path="name">Name</form:label>
							<form:errors path="name" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="name" cssClass="form-control" />
						</div>


						</div>
						
							<div class="col-sm-3 offset-sm-9">
								<input class="btn btn-primary" type="submit" value="Create" />
							</div>

						
					
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>