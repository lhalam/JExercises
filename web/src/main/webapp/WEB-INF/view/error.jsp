<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="base.jsp" %>
    <link href="${basedir}/resources/css/error.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="error-template">
                <h1>
                    Oops!</h1>

                <h2> ${message}</h2>

                <div class="error-details">
                    Sorry, an error has occurred, ${info}
                </div>
                <div class="error-actions">
                    <a href="/web/tests" class="btn btn-primary "><span
                            class="glyphicon glyphicon-home"></span>
                        Take Me Home </a>
                    <a href="/web/about" class="btn btn-default "><span
                            class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
