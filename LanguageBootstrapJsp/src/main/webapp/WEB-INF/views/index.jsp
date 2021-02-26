<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h4>All Languages</h4>
			</div>
			<div class="col-sm-6 d-flex justify-content-around">
			<a class="btn btn-info" href="/languages/new">New Language</a>
			</div>
			
			<table class="table display responsive nowrap ">
				<thead>
					<tr>
						
						<th>Name</th>
						<th>Creator</th>
						<th>CurrentVersion</th>
						<th> Action</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lang}" var="language">
						<tr>


							
							<td><a href="languages/${language.id}"> <c:out
										value="${language.name}" /></a></td>
							<td><c:out value="${language.creator}" /></td>
							<td><c:out value="${language.currentVersion}" /></td>

							<td><a class="btn btn-warning"
								href="/languages/${language.id}/edit">Edit</a></td>
							<td><a class="btn btn-danger"
								href="/languages/${language.id}/delete">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">

				<form:form action="/languages" method="post"
					modelAttribute="language" cssClass="form-control">

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
	</div>
</body>
</html>