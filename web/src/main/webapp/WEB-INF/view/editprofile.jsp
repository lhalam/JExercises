<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="base.jsp" %>
</head>
<%@ include file="navigation.jsp" %>

<body id="container">
<div class="container">
    <div class="row" style="margin-top:20px;">
        <div class="col-md-5">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><a href=""
                                               class="btn btn-default"><span
                            class="glyphicon glyphicon-arrow-left"></span> Back</a>
                        Account Settings </h3>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="userDto"
                               id="editProfileForm"
                               cssClass="form-horizontal">

                        <fieldset>

                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">First
                                    Name</label>

                                <div class="col-lg-8">
                                    <form:input cssClass="form-control"
                                                placeholder="First Name"
                                                value="${userFirstName}"
                                                path="firstName" type="text"/>
                                </div>
                            </div>


                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">Last
                                    Name</label>

                                <div class="col-lg-8">
                                    <form:input cssClass="form-control"
                                                placeholder="Last Name"
                                                value="${userLastName}"
                                                path="lastName" type="text"/>
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">Email</label>

                                <div class="col-lg-8">
                                    <form:input cssClass="form-control"
                                                placeholder="${userEmail}"
                                                disabled="true"
                                                path="email" type="text"
                                                id="email"/>
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="password"
                                       class="col-lg-4 control-label">Password</label>

                                <div class="col-lg-8">
                                    <form:input id="password"
                                                cssClass="form-control"
                                                placeholder="New Password"
                                                path="password"
                                                type="password"/>
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="matchingPassword"
                                       class="col-lg-4 control-label">Confirm
                                    Password</label>

                                <div class="col-lg-8">
                                    <form:input id="matchingPassword"
                                                cssClass="form-control"
                                                placeholder="Confirm Password"
                                                path="matchingPassword"
                                                type="password"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-7 col-lg-12">
                                    <input class="btn btn-sm" type="reset"
                                           value="Reset form">
                                    <input class="btn btn-info" type="submit"
                                           value="Update">
                                </div>
                            </div>


                        </fieldset>

                    </form:form>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>