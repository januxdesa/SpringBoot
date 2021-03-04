<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="col-sm-12">
					<h1>Register!</h1>
				</div>
				<div class="col-sm-12">
					<p>
						<form:errors path="user.*" />
					</p>
				</div>
				<div class="col-sm-12">
					<form:form class="border rounded p-3" method="POST"
						action="/registration" modelAttribute="user">

						<div class="form-group">
							<form:label path="firstName">FirstName:</form:label>
							<form:input class="form-control" type="text" path="firstName" />
						</div>
						<div class="form-group">
							<form:label path="lastName">LastName:</form:label>
							<form:input class="form-control" type="text" path="lastName" />
						</div>
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<form:label path="location">Location:</form:label>
										<form:input class="form-control" type="text" path="location" />
									</div>
								</div>
								<div class="col-sm-6">

									<div class="form-group">
										<form:label path="stateUser">State:</form:label>
										<form:select cssClass="form-control" path="stateUser">
											<form:option value=""> --SELECT--</form:option>
											<form:options  items="${states}" itemValue="stateName" itemLabel="stateName" ></form:options>
										</form:select>

									</div>
								</div>

							</div>

						</div>
						<div class="form-group">
							<form:label path="email">Email:</form:label>
							<form:input class="form-control" type="email" path="email" />
						</div>
						<div class="form-group">
							<form:label path="password">Password:</form:label>
							<form:password class="form-control" path="password" />
						</div>
						<div class="form-group">
							<form:label path="passwordConfirmation">Password Confirmation:</form:label>
							<form:password class="form-control" path="passwordConfirmation" />
						</div>
						<div class="form-group">
							<input class="btn btn-primary" type="submit" value="Register!" />
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="col-sm-12">
					<h1>Login</h1>
				</div>
				<div class="col-sm-12">
					<p>
						<c:out value="${error}" />
					</p>
				</div>
				<div class="col-sm-12">

					<form class="border rounded p-3 " method="post" action="/login">
						<div class="form-group">
							<label for="email">Email</label> <input class="form-control"
								type="text" id="email" name="email" />
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input
								class="form-control" type="password" id="password"
								name="password" />
						</div>
						<div class="form-group">
							<input class="btn btn-primary" type="submit" value="Login!" />
						</div>
					</form>
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