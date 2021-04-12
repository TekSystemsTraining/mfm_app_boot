
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	href="<%=request.getContextPath()%>/resources/css/profile_page.css" />


<title>My Profile</title>
</head>
<body>
	<%
	if (session.getAttribute("user") == null) {
		session.setAttribute("error", "Must be logged in to access that page");
		response.sendRedirect("login");
	}
	%>
	<%@ include file="nav.jsp"%>
	<div class="bigwords">
		<h1>My stats</h1>
	</div>
	<div class="container profile-layout">
		<div class="main-body">



			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Username</h6>
								</div>
								<div class="col-sm-9 text-secondary">${user.username}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Total Weight lifted</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<c:choose>
										<c:when test="${ user.total_weight_lifted  == 0}">
                    						You haven't logged a workout yet
                    					</c:when>
										<c:otherwise>
                    						${user.total_weight_lifted }
                   					</c:otherwise>
									</c:choose>

								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Average Weight Lifted</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<c:choose>
										<c:when
											test="${ user.total_workouts  == 0 || user.total_workouts  == null}">
                    						You haven't logged a workout yet
                   						 </c:when>
										<c:otherwise>
                   							 ${Math.round(user.total_weight_lifted/user.total_workouts) }
                    					</c:otherwise>
									</c:choose>
								</div>
							</div>

						</div>
					</div>

					<div class="d-flex row justify-content-center">
						<button class="btn btn-outline-secondary btn-lg " type="button"
							onclick="location.href='workout'">Start New Workout</button>
					</div>
					<div class="card mb-6" style="margin-top: 40px">
						<h6>${delete}</h6>
						<form:form action="delete_workout" method="POST">
							<div class="card-body">
								<div class="row">
									<div class="col-sm">
										<h6 class="mb-0">Date completed</h6>
									</div>
									<div class="col-sm">
										<h6 class="mb-0">Total Weight lifted</h6>
									</div>
									<div class="col-sm">
										<h6 class="mb-0">Delete Workout</h6>
									</div>
								</div>
								<hr>
								<c:forEach items="${all_workouts}" var="w">
									<div class="row">
										<div class="col-sm">
											<div>
												<fmt:formatDate value="${w.date_of_workout}" type="date"
													pattern="dd-MMM-yyyy" />
											</div>
										</div>
										<div class="col-sm">
											<div>${w.total_weight_lifted}</div>
										</div>
										<div class="col-sm">
											<div>
												<button type="button" class="btn btn-outline-secondary">
													<a href="<c:url value='/delete_workout/${w.id}'/>">Delete</a>
												</button>

											</div>
										</div>

									</div>
									<hr>
								</c:forEach>
							</div>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
