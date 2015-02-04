<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="utf-8">
<title>JExercises</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="JExercises UI">
<meta name="author" content="Lv-137.|Java">
<link href="resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet"
	type="text/css">
<link rel="shortcut icon" href="ss-logo.png">
<script src="resources/js/bootstrap.js" type="text/javascript"></script>
<script src="resources/js/jquery-2.1.3.js" type="text/javascript"></script>
</head>
<body id="container">
	<div class="container">

		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">
				<form method="POST" action="login" accept-charset="UTF-8"
					role="form" id="loginform" class="form-signin">
					<input name="_token" type="hidden"
						value="AopTenvrFiopz5xcgvEmi7rwrSirQ24TWVf8OdJn">
					<fieldset>
						<h3 class="sign-up-title"
							style="color: dimgray; text-align: center">JEexercises
							Please sign in</h3>
						<hr class="colorgraph">
						<input class="form-control email-title" placeholder="E-mail"
							name="email" type="text"/>
						<input class="form-control" placeholder="Password" name="password"
							type="password" /> <a class="pull-right"
							href="forgotpassword.jsp">Forgot password?</a>
						<div class="checkbox" style="width: 140px;">
							<label><input name="remember" type="checkbox"
								value="Remember Me"> Remember Me</label>
						</div>
						<input class="btn btn-lg btn-success btn-block" type="submit"
							value="Login"> <br>
						<p class="text-center">
							<a href="register.jsp">Register for an account?</a>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>