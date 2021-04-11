<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Add Exercise</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/login.css" />
</head>
<body>
	<%
	if (session.getAttribute("user") == null) {
		session.setAttribute("error", "Must be logged in to access that page");
		response.sendRedirect("login");
	}
	%>
	<%@ include file="nav.jsp"%>
	<div id="login">
		<form:form action="save_exercise" method="GET">
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">
						<div id="login-box" class="col-md-12">
							<form id="login-form" class="form" action="add_exercise"
								method="post">
								<h3 class="text-center">Add Exercise</h3>
								<div class="form-group">
									<label for="name" class="">Exercise name: </label><br>
									<input type="text" name="name" id="name" class="form-control">
								</div>
								<div class="row d-flex justify-content-around">

									<label for="name" class="">Choose Primary
										Bodypart</label><br> <label for="name" class="">Choose
										Secondary Bodypart</label> <br>
								</div>

								<div class="row d-flex justify-content-around">
									<form:select path="primary_bodypart">

										<form:option value="" label="--Select--" />

										<form:options items="${primary_bodypart}" itemsValue="name" />

									</form:select>
									<form:select path="secondary_bodypart">
										<form:option value="" label="--Select--" />

										<form:options items="${secondary_bodypart}" itemsValue="name" />

									</form:select>
								</div>


								<div class="d-flex justify-content-around" style="margin-top: 45px">
									<input type="submit" name="submit" class="btn btn-outline-secondary btn-md"
										value="submit">
								</div>

							</form>
							<h5>${new_exercise}</h5>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
