<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Register</title>
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
	<%@ include file="nav.jsp"%>
	<div id="login">
		<div class="container" >
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12" style="height: 420px">
						<form id="login-form" class="form" action="registerUser"  method="POST">
							<h3 class="text-center second_color">Register</h3>
							<div class="form-group">
								<label for="username" class="second_color">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="second_color">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="confirm_password" class="second_color">Confirm
									Password:</label><br> <input type="password" name="confirm_password"
									id="confirm_password" class="form-control">
							</div>
							<div class="form-group">
								<br> <input type="submit" name="submit"
									class="btn btn-outline-secondary btn-md" value="submit">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
