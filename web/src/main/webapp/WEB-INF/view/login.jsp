<jsp:include page="base.jsp"/>
<body id="container">
	<div class="container">

		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">
				<c:url var="loginUrl" value="j_spring_security_check" />
				<form method="POST" action="${loginUrl}" accept-charset="UTF-8"
					role="form" id="loginform" class="form-signin">
					<input name="_token" type="hidden">
					<fieldset>
						<h3 class="sign-up-title"
							style="color: dimgray; text-align: center">JExercises Please
							sign in</h3>
						<hr class="colorgraph">
						<input class="form-control email-title" placeholder="E-mail"
							name="j_username" type="text" /> <input class="form-control"
							placeholder="Password" name="j_password" type="password" /> <a
							class="pull-right" href="forgotpassword.jsp">Forgot password?</a>
						<div class="checkbox" style="width: 140px;">
							<label><input name="_spring_security_remember_me"
								type="checkbox" value="true"> Remember Me</label>
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