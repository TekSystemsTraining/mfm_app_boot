<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/workout.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<title>Workout</title>
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
		<h1>Workout Tracker</h1>
	</div>

	<div class="about" id="grid">
		<form:form action="save_workout" method="GET">
			<div class="container" style="width: 50rem">
				<div class="description"></div>
				<div class="exercise-container">
					<div class="row">
						<div class="col">
							<form:select path="exercise_one_completed">
								<form:option value="" label="--Select--" />

								<form:options items="${exercises}" itemsValue="id" />

							</form:select>
						</div>
						<div class="col">
							<div class="row">
								<label class="col">Reps</label> <label class="col">Weight</label>
								<label class="col">Total</label>
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-1-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-1-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-1-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-2-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-2-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-2-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-3-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-3-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-3-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-4-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-4-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="1-4-3" disabled />
							</div>
							<div class="d-flex justify-content-between total_button">
								<div>
									<button onclick="total_exercise(1,false)"
										class="btn btn-outline-secondary btn-lg " type="button">View
										Totals</button>
								</div>


							</div>
						</div>
					</div>
				</div>
				<div class="exercise-container">
					<div class="row">
						<div class="col">
							<form:select path="exercise_two_completed">
								<form:option value="" label="--Select--" />

								<form:options items="${exercises}" />

							</form:select>
						</div>
						<div class="col">
							<div class="row">
								<label class="col">Reps</label> <label class="col">Weight</label>
								<label class="col">Total</label>
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-1-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-1-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-1-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-2-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-2-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-2-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-3-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-3-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-3-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-4-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-4-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="2-4-3" disabled />
							</div>
							<div class="d-flex justify-content-between total_button">
								<div>
									<button onclick="total_exercise(2,false)"
										class="btn btn-outline-secondary btn-lg " type="button">View
										Totals</button>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="exercise-container">
					<div class="row">
						<div class="col">
							<form:select path="exercise_three_completed">
								<form:option value="" label="--Select--" />

								<form:options items="${exercises}" />

							</form:select>
						</div>
						<div class="col">
							<div class="row">
								<label class="col">Reps</label> <label class="col">Weight</label>
								<label class="col">Total</label>
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-1-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-1-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-1-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-2-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-2-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-2-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-3-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-3-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-3-3" disabled />
							</div>
							<div class="row">
								<input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-4-1" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-4-2" /> <input type="number"
									onkeyup="if(this.value<0){this.value= this.value * -1}" min="0"
									class="col-sm" id="3-4-3" disabled />
							</div>
							<div class="d-flex justify-content-between total_button">
								<div>
									<button onclick="total_exercise(3,false)"
										class="btn btn-outline-secondary btn-lg " type="button">View
										Totals</button>
								</div>


							</div>
						</div>
					</div>
				</div>

				<div class="d-flex row justify-content-center workout_submit">
					<button type="button" class="btn btn-outline-secondary btn-lg"
						data-toggle="modal" data-target="#modalCenter"
						onclick="workout_total()">Complete Workout</button>


				</div>
				<!-- Button trigger modal -->

				<!-- Modal -->
				<div class="modal fade" id="modalCenter" tabindex="-1" role="dialog"
					aria-labelledby="modalCenterTitle" aria-hidden="true">

					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalLongTitle">Complete
									Workout</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true"></span>
								</button>
							</div>
							<div class="modal-body form-group">
								<h2 id="total_weight"></h2>
								<input type="hidden" name="total_weight_lifted"
									id="total_weight_lifted" value="" /> <input type="hidden"
									name="exercises_completed" id="exercises_completed" value="" />
								Have you entered everything for this workout? If it is complete
								hit save.
							</div>


							<div class="modal-footer form-group">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" onclick="clear_total()">Close</button>
								<button type="submit" class="btn btn-primary" type="submit"
									value="submit">Save</button>
							</div>

						</div>
					</div>

				</div>
			</div>
		</form:form>
	</div>

</body>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/workout.js"></script>
</html>
