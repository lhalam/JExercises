<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="base.jsp"/>
</head>
<body id="container">
	<div class="container">

		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">

				<form method="POST" role="form" id="registrationform" class="form-signin">

					<fieldset>
						<h3 class="sign-up-title"
							style="color: dimgray; text-align: center">JExercises Please
							Register</h3>
						<hr class="colorgraph">
						<input class="form-control" placeholder="Username" name="username"
							type="text" /> <input class="form-control" placeholder="E-mail"
							name="email" type="text" /> <input class="form-control"
							placeholder="Password" name="password" type="password" /> <input
							class="form-control" placeholder="Confirm Password"
							name="matchingPassword" type="password" /> <br>
						<input class="btn btn-lg btn-success btn-block" type="submit"
							value="Register"> <br>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>