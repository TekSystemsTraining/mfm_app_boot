<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>
/resources/css/landing_page.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>
/resources/js/landing_page.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<title>Landing Page</title>
</head>
<body style="background-image: url('<%=request.getContextPath()%>/resources/images/GymPhoto.jpg')">

	<%@ include file="nav.jsp"%>
	<header class="header">
		<div class="overlay">
			<div class="container">
				<form action="login" method="get" class="description">
					<h1>
						Welcome to My First Million Weight Lifting Tracker
						<p>Join today and start tracking your workouts and see your
							lifetime totals and global leaderboards</p>
						<button class="btn btn-outline-secondary btn-lg" type="submit">Log
							in</button>
					</h1>
				</form>
			</div>
		</div>
	</header>

</body>
</html>
