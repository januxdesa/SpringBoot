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
<title>New Ninja</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				<h1>New Dojo</h1>
				<form:form action="/ninja/new" method="post"
					modelAttribute="ninja" cssClass="form-control">

					

					<div class="row p4">
						<div class="col-sm-3">
							<form:label path="dojo">Dojos</form:label>
							<form:errors path="dojo" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:select path="dojo">
        						<form:options items="${dojos}" itemValue="id" itemLabel="name" />
    						</form:select>
						</div>
					
					
						<div class="col-sm-3">
							<form:label path="firstName">FirstName</form:label>
							<form:errors path="firstName" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="firstName" cssClass="form-control" />
						</div>
						<div class="col-sm-3">
							<form:label path="lastName">LastName</form:label>
							<form:errors path="lastName" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="lastName" cssClass="form-control" />
						</div>
						<div class="col-sm-3">
							<form:label path="age">Age</form:label>
							<form:errors path="age" cssClass="form-control" />
						</div>
						<div class="col-sm-9">
							<form:input path="age" cssClass="form-control" />
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