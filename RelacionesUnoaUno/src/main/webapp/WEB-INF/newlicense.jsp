<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>


<c:set var="assets" value="${pageContext.request.contextPath}" /> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link href="${assets}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1> <c:out value=" ${msg}"></c:out></h1>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				<h1>New License</h1>
				<form:form action="/licenses/new" method="post" modelAttribute="licenses" cssClass="form-control">

					<div class="row p3">
						<div class="col-sm-6">
							<form:label path="person">Person</form:label>
							<form:errors path="person" cssClass="form-control" />
						</div>
						<div class="col-sm-6">
							<select  name="person" id="person">
 	 							<c:forEach items="${personas}" var="p">
   								 	<option  value= "${p.id}" >  ${p.firstName} ${p.lastName}  </option>
								</c:forEach>
							</select>
						
						</div>
						<div class="col-sm-6">
							<form:label path="state">State</form:label>
							<form:errors path="state" cssClass="form-control" />
						</div>
						<div class="col-sm-6">
							<form:input path="state" cssClass="form-control" />
						
						</div>
						
						<div class="col-sm-6">
							<form:label path="expirationDate">Expire Date</form:label>
							<form:errors path="expirationDate" cssClass="form-control" />
						</div>
						<div class="col-sm-6">
							<form:input type="date" path="expirationDate" cssClass="form-control" />
							
							
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