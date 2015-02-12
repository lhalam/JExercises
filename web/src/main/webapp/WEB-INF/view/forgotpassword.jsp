<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="base.jsp" %>
</head>
<body id="container">
<div class="container">
    <%@ include file="navigation.jsp" %>
    <div class="col-md-4 col-md-offset-4">
        <form class="panel panel-primary">

            <div class="container-fluid">
                <form method="POST" action="http://bootsnipp.com/password" accept-charset="UTF-8" role="form"
                      id="loginform"
                      class="form-signin"><input name="_token" type="hidden"
                                                 value="AopTenvrFiopz5xcgvEmi7rwrSirQ24TWVf8OdJn">
                    <fieldset>
                        <h2>Request password reset</h2>
                        <hr class="colorgraph">
                        <input class="form-control" placeholder="Enter your E-mail" name="email" type="text">
                        <br></br>

                        <p>
                            <input class="btn btn-lg btn-success btn-block" type="submit"
                                   value="Request password reset">
                        </p>

                        <p class="text-center">Remembered your password? <a href="login">Login here</a></p>
                    </fieldset>
                </form>
            </div>
        </form>
    </div>
</div>
</body>
</html>