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
		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">

				<form id="registrationForm" method="POST" accept-charset="UTF-8"
					role="form" class="panel panel-default">
					<div class="container-fluid">
						<br />
						<div id="errorMessageHolder" class="alert alert-danger"
							hidden="true"></div>
						<h3 class="sign-up-title"
							style="color: dimgray; text-align: center">JExercises
							Register</h3>
						<hr class="colorgraph">
						<hr class="line">
						<div class="form-group has-feedback fullWidth">
							<input class="form-control roundedTop validated"
								placeholder="First name*" id="firstName" name="firstName"
								type="text"><span
								class="glyphicon form-control-feedback roundedTopRight"
								id="firstNameFeedback"></span>
						</div>

						<div class="form-group has-feedback fullWidth">
							<input class="form-control roundedTop validated"
								placeholder="Last name*" id="lastName" name="lastName"
								type="text" /><span
								class="glyphicon form-control-feedback roundedTopRight"
								id="firstNameFeedback"></span>
						</div>

						<div class="form-group has-feedback fullWidth">
							<input class="form-control roundedTop validated"
								placeholder="E-mail*" id="email" name="email" type="email" /><span
								class="glyphicon form-control-feedback roundedTopRight"
								id="firstNameFeedback"></span>
						</div>

						<div class="form-group has-feedback fullWidth">
							<input id="password" class="form-control roundedTop validated"
								placeholder="Password*" name="password" type="password" /> <span
								class="glyphicon form-control-feedback roundedTopRight"
								id="firstNameFeedback"></span>
						</div>

						<div class="form-group has-feedback fullWidth">
							<input id="matchingPassword"
								class="form-control roundedTop validated"
								placeholder="Confirm Password*" name="matchingPassword"
								type="password" /> <span
								class="glyphicon form-control-feedback roundedTopRight"
								id="firstNameFeedback"></span>
						</div>


						<hr class="line">
						<label class="label" id="label">Birthday</label> <br></br>
						<div id="datePicker" class="combodate">
							<select id="day" name="day">
								<option disabled selected>Day</option>
								<c:forEach items="${days}" var="day">
									<option value="${day}"><c:out value="${day}" /></option>
								</c:forEach>
							</select> <select id="month" name="month">
								<option disabled selected>Month</option>
								<c:forEach items="${months}" var="month">
									<option value="${month.key}"><c:out
											value="${month.value}" /></option>
								</c:forEach>
							</select> <select id="year" name="year">
								<option disabled selected>Year</option>
								<c:forEach items="${years}" var="year">
									<option value="${year}"><c:out value="${year}" /></option>
								</c:forEach>
							</select>
						</div>
						<hr class="line">
						<input id="submitButton" class="btn btn-lg btn-success btn-block"
							type="submit" value="Sign up"> <br>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
