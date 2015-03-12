<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="../base.jsp"%>
<%@ include file="../navigation.jsp"%>
<link href="${basedir}/resources/css/registration.css" rel="stylesheet"
	type="text/css">
<script
	src="${basedir}/resources/js/registration/registration-data-validation.js"></script>
<script src="${basedir}/resources/js/lib/jquery.validate.min.js"></script>
</head>
<body id="container">

	<input type="hidden" id="contextRootHolder" value="${basedir}" />
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<div id="alertSource">
					<div class="alert alert-danger alert-dismissible" role="alert"
						hidden="true">
						<button class="close" aria-label="Close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span>
						</button>
						<div class="errorMessage"></div>
					</div>
				</div>

				<form id="registrationForm" method="POST" accept-charset="UTF-8"
					role="form" class="panel panel-default">
					<div class="container-fluid">
						<br />
						<div id="errorMessageHolder"></div>
						<h3 class="sign-up-title">JExercises Register</h3>
						<hr class="colorgraph">
						<hr class="line">

						<div class="form-group has-feedback">
							<label for="firstName" class="sr-only">First Name</label> <input
								class="form-control" placeholder="First name*"
								id="firstName" name="firstName" type="text"><span
								class="glyphicon form-control-feedback"
								id="firstNameFeedback"></span>
						</div>

						<div class="form-group has-feedback">
							<label for="lastName" class="sr-only">Last Name</label> <input
								class="form-control" placeholder="Last name*"
								id="lastName" name="lastName" type="text" /><span
								class="glyphicon form-control-feedback" id="lastNameFeedback"></span>
						</div>

						<div class="form-group has-feedback">
							<label for="email" class="sr-only">Email</label> <input
								class="form-control" placeholder="E-mail*" id="email"
								name="email" type="email" /><span
								class="glyphicon form-control-feedback" id="emailFeedback"></span>
						</div>

						<div class="form-group has-feedback">
							<label for="password" class="sr-only">Password</label> <input
								id="password" class="form-control"
								placeholder="Password*" name="password" type="password" /> <span
								class="glyphicon form-control-feedback"
								id="passwordFeedback"></span>
						</div>

						<div class="form-group has-feedback">
							<label for="matchingPassword" class="sr-only">Matching
								Password</label> <input id="matchingPassword"
								class="form-control" placeholder="Confirm Password*"
								name="matchingPassword" type="password" /> <span
								class="glyphicon form-control-feedback"
								id="matchingPasswordFeedback"></span>
						</div>

						<hr class="line">

						<div id="birthDate" class="form-group has-feedback col-sm-11">
							<span id="birthDateFeedback"
								class="glyphicon form-control-feedback nearLabel"></span><label
								for="birthDate">Birth Date</label>
						</div>
						<br></br>
						<div class="form-inline row-fluide">
							<div class="form-group">
								<label for="day" class="sr-only">Day</label> <select id="day"
									name="day" class="form-control">
									<option disabled selected>Day</option>
									<c:forEach items="${days}" var="day">
										<option value="${day}"><c:out value="${day}" /></option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-sm-offset-1">
								<label for="month" class="sr-only">Month</label> <select
									id="month" name="month" class="form-control">
									<option disabled selected>Month</option>
									<c:forEach items="${months}" var="month">
										<option value="${month.key}"><c:out
												value="${month.value}" /></option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-sm-offset-1">
								<label for="year" class="sr-only">Year</label> <select id="year"
									name="year" class="form-control">
									<option disabled selected>Year</option>
									<c:forEach items="${years}" var="year">
										<option value="${year}"><c:out value="${year}" /></option>
									</c:forEach>
								</select>
							</div>
						</div>

						<hr class="line">
						<input id="submitButton" class="btn btn-lg btn-success btn-block"
							type="submit" value="Sign up"> <br>
					</div>
					<p class="text-center">
                            <a href="${basedir}/login">Already registered? Please, login.</a>
                        </p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
