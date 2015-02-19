<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<html>
<head>
<jsp:include page="base.jsp" />
<jsp:include page="navigation.jsp" />
<script src="resources/js/registration_data_validation.js"></script>
<script src="resources/js/register.js"></script>
<script src="resources/js/lib/jquery.validate.min.js"></script>
</head>
<body id="container">
	<div class="container">
		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">
				<form id="registrationForm" method="POST"
					class="panel panel-default">
					<div class="container-fluid">
						<h3 class="sign-up-title"
							style="color: dimgray; text-align: center">JExercises Please
							Register</h3>
						<hr class="colorgraph">
						<input class="form-control" placeholder="First name"
							id="firstName" name="firstName" type="text" /> <input
							class="form-control" placeholder="Last name" id="lastName"
							name="lastName" type="text" /> <input class="form-control"
							placeholder="E-mail" id="email" name="email" type="email" /> <input
							id="password" class="form-control" placeholder="Password"
							name="password" type="password" /> <input id="matchingPassword"
							class="form-control" placeholder="Confirm Password"
							name="matchingPassword" type="password" /> <input id="birthDate"
							class="form-control" placeholder="Date Of Birth" name="birthDate"/>
						<br> <input id="submitButton"
							class="btn btn-lg btn-success btn-block" type="button"
							value="Register"> <br>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
