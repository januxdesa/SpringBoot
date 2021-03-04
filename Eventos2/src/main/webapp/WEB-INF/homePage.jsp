<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="row p-4">
			<div class="col-sm-9">
				<h3>
					Welcome,
					<c:out value="${user.firstName}" />
					<c:out value="${user.lastName}" />
				</h3>
			</div>
			<div class="col-sm-3">
				<a href="/logout">Logout</a>
			</div>

			<div class="col-sm-12">
				<h5>Here some events in you State</h5>
			</div>
			<div class="col-sm-12">

				<table class="table border">

					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>State</th>
						<th>Host</th>
						<th>Action / Status</th>
					</tr>
					
					<c:forEach var="e" items="${ eventos }">
						<tr>
						<c:if test="${e.stateEvent == user.stateUser }">
							<td><a href="/events/${e.id}"> ${e.name } </a></td>
							<td>${e.dateEvent }</td>
							<td>${e.ubication }</td>
							<td>${e.stateEvent }</td>
							<td>${e.userEvent.firstName }</td>
					
						
							<c:choose>
								<c:when test="${e.userEvent.id == user.id }">
									<td><a href="/events/${e.id}/edit"> Edit </a> <a href="/events/${e.id}/delete"> Delete </a></td>
								</c:when>
								<c:when test="${e.userEvent.id != user.id}">
								
									 <c:forEach var="u" items="${ uhe }">
									
											<c:if test="${ u.joining.id == e.id }">
												<c:choose>
												
												<c:when  test="${  u.asistente.id == user.id}">
												<td> Joining  | <a href="/events/${e.id}/cancel"> Cancel </a></td>
												</c:when>
												
												<c:when  test="${  u.asistente.id == '' }">
												<td> <a href="/events/${e.id}/add"> Join </a></td>
												</c:when>
												
												</c:choose>
											</c:if>

									</c:forEach>
								</c:when>
							</c:choose>
						
							
						</c:if>
							
						</tr>
						</c:forEach>

				</table>
			</div>

			<div class="col-sm-12">
				<h5>Here some events in other State</h5>
			</div>
			<div class="col-sm-12">
			<table class="table border">

					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>State</th>
						<th>Host</th>
						<th>Action / Status</th>
					</tr>
					
					<c:forEach var="e" items="${ eventos }">
						<tr>
						<c:if test="${e.stateEvent != user.stateUser }">
							<td><a href="/events/${e.id}"> ${e.name } </a></td>
							<td>${e.dateEvent }</td>
							<td>${e.ubication }</td>
							<td>${e.stateEvent }</td>
							<td>${e.userEvent.firstName }</td>
					
						
							<c:choose>
								<c:when test="${e.userEvent.id == user.id }">
									<td><a href="/events/${e.id}/edit"> Edit </a> <a href="/events/${e.id}/delete"> Delete </a></td>
								</c:when>
								<c:when test="${e.userEvent.id != user.id}">
								
									 <c:forEach var="u" items="${ uhe }">
									
									
											<c:if test="${ u.joining.id == e.id &&  u.asistente.id == user.id }">
												<td> E: <c:out value ="${ u.joining.id }"/> </td>
												<td> A: <c:out value ="${ u.asistente.id }"/> </td>
													<td> Joining  | <a href="/events/${e.id}/cancel"> Cancel </a></td>									
											</c:if>
											
											<c:if test="${ u.joining.id =-= '' &&  u.asistente.id == '' }">
												<td> E: <c:out value ="${ u.joining.id }"/> </td>
												<td> A: <c:out value ="${ u.asistente.id }"/> </td>
													<td> <a href="/events/${e.id}/add"> Join </a></td>
											</c:if>
											
									</c:forEach>
								</c:when>
								
								
							</c:choose>
						
							
						</c:if>
							
						</tr>
						</c:forEach>

				</table>
			</div>
			
			

			<div class="col-sm-12">
				<div class="col-sm-6">
					<div class="col-sm-12">
						<h1>Crear Eventos</h1>
					</div>

					<div class="col-sm-12">
						<form:form class="border rounded p-3" method="POST"
							action="/events" modelAttribute="event">
							<div class="col-sm-12">
								<form:errors path="user.*" />
							</div>
							<div class="form-group">
								<form:label path="name">Name:</form:label>
								<form:input class="form-control" type="text" path="name" />
							</div>
							<div class="form-group">
								<form:label path="dateEvent">Date:</form:label>
								<form:input class="form-control" type="date" path="dateEvent" />
							</div>
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<form:label path="ubication">Location:</form:label>
											<form:input class="form-control" type="text" path="ubication" />
										</div>
									</div>
									<div class="col-sm-6">

										<div class="form-group">
											<form:label path="stateEvent">State:</form:label>
											<form:select cssClass="form-control" path="stateEvent">
												<form:option value=""> --SELECT--</form:option>
												<form:options items="${states}" itemValue="stateName"
													itemLabel="stateName"></form:options>
											</form:select>

										</div>
									</div>

								</div>

							</div>
							<div class="form-group">
								<input class="btn btn-primary" type="submit"
									value="Create Event" />
							</div>
						</form:form>
					</div>
				</div>


			</div>
		</div>
		<!-- Bootstrap core JavaScript
================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.js"></script>
</body>
</html>