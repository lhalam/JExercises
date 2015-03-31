<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="base.jsp" %>
    <%@ include file="navigation.jsp" %>
    <link href="${basedir}/resources/css/login.css" rel="stylesheet"
	type="text/css">
</head>
<body id="container">
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <c:url var="loginUrl" value="j_spring_security_check"/>
            <form method="POST" action="${loginUrl}" accept-charset="UTF-8" role="form" id="loginform"
                  class="panel panel-default">

                <div class="container-fluid">
                    <input name="_token" type="hidden"><br/>
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button class="close" aria-label="Close" data-dismiss="alert">
									<span aria-hidden="true">&times;</span>
								</button>
								<p>Invalid email or password</p>
							</div>
						</c:if>
						<c:if test="${not empty param.logout}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button class="close" aria-label="Close" data-dismiss="alert">
									<span aria-hidden="true">&times;</span>
								</button>
								<p>You were logout successfully</p>
							</div>
						</c:if>
                    <fieldset>
                        <h3 class="sign-up-title">JExercises Please
                            sign in</h3>
                        <hr class="colorgraph">
                        <div class="input-group">
                        <span class="input-group-addon glyphicon glyphicon-user" id="email-addon"></span>
                        <input class="form-control email-title" placeholder="E-mail"
                               name="j_username" type="text" aria-describedby="email-addon"/>
                        </div>
                        <div class="input-group">
                        <span class="input-group-addon glyphicon glyphicon-lock" id="password-addon"></span>
                        <input class="form-control" placeholder="Password" 
                       		   name="j_password" type="password" aria-describedby="password-addon"/>
 						 </div>
                        <div class="checkbox">
                            <label><input name="_spring_security_remember_me"
                                          type="checkbox" value="true"> Remember Me</label>
                        </div>
                        <input class="btn btn-lg btn-success btn-block" type="submit"
                               value="Sign in" id="btnsub"> <br>

                        <p class="text-center">
                           <a href="${basedir}/user/registration">Don't have an account? Sign up now.</a>
                        </p>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

