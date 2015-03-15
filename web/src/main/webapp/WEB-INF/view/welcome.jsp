<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="base.jsp" %>
    <link href="${basedir}/resources/css/welcome.css" rel="stylesheet" type="text/css">
</head>

<body class="container">
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-sm-10 col-md-8 col-lg-8 col-xs-offset-1 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 ">
            <div class="home">
                <span class="bs-docs-booticon bs-docs-booticon-lg bs-docs-booticon-outline">JE</span>

                <h1>Welcome to JExercises</h1>

                <p>Online programming tests to hire developers.
                    Select programmers based on their actual coding skills.
                </p>

                <div class="banner_btn">
                    <a href="/web/login" class="btn btn-default btn-lg">Log in</a>
                    <a href="/web/user/registration" class="btn btn-default btn-lg">Sign in</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
