<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<jsp:include page="base.jsp" />
<jsp:include page="navigation.jsp" />
<script src="resources/js/registration_data_validation.js"
	type="text/javascript"></script>
<script	src="resources/js/lib/jquery.validate.min.js"></script>
</head>
<body id="container">
	<div class="container">
		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">
				<form:form method="POST" modelAttribute="user" id="registrationForm"
					cssClass="panel panel-default">
					<div class="container-fluid">
						<fieldset>
							<h3 class="sign-up-title"
								style="color: dimgray; text-align: center">JExercises
								Please Register</h3>
							<hr class="colorgraph">
							<form:input cssClass="form-control" placeholder="First name"
								path="firstName" type="text" />
							<form:input cssClass="form-control" placeholder="Last name"
								path="lastName" type="text" />
							<form:input cssClass="form-control" placeholder="E-mail"
								path="email" type="email" />
							<form:input id="password" cssClass="form-control"
								placeholder="Password" path="password" type="password"/>
							<form:input id="matchingPassword" cssClass="form-control"
								placeholder="Confirm Password" path="matchingPassword"
								type="password" />
							<br> <input id="registrationSubmit"
								class="btn btn-lg btn-success btn-block" type="submit"
								value="Register"> <br>
						</fieldset>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
