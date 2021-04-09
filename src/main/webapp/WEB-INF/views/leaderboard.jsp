<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/leaderboard.css" />

<title>Leaderboard</title>
</head>
<body>

	<%@ include file="nav.jsp"%>
	<div class="about" id="grid">
		<div class="container" style="width: 30rem">
			<div class="bigwords">
				<h1>Leaderboard</h1>
			</div>
			
			<div class="container">
				<h2 style="text-align: center">Top 10 Lifters</h2>
				<div class="row">
					<label class="col-sm">Place</label><label class="col">Name</label> <label class="col">Total Lifted</label> <label class="col">Total Workouts</label>
				</div>
				<c:forEach items="${all_users}" var="u" varStatus="loop">
					<div class=row>
						<div class="col-sm">
							<h4>${loop.index + 1}</h4>
						</div>
						<div class="col-sm">${u.username}</div>
						<div class="col-sm">${u.total_weight_lifted}</div>
						<div class="col-sm">${u.total_workouts}</div>
					</div>
				</c:forEach>				
			</div>
		</div>
	</div>
</body>
</html>
