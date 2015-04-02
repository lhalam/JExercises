<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>

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

                <h2>Status code: ${pageContext.errorData.statusCode}</h2>

                <h2>Sorry, an error has occurred!</h2>

                <h2> ${requestScope['javax.servlet.error.message']}</h2>

                <div class="error-actions">
                    <a href="${basedir}/tests" class="btn btn-default "><span
                            class="glyphicon glyphicon-home"></span>
                        Take Me Home </a>
                    <a href="${basedir}/about" class="btn btn-default "><span
                            class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
