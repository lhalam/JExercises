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
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Username</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img
                                alt="User Pic"
                                src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
                                class="img-circle"></div>


                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>

                                <tr>
                                    <td>Name:</td>
                                    <td>${userFirstName}</td>
                                </tr>

                                <tr>
                                    <td>Surname:</td>
                                    <td>${userLastName}</td>
                                </tr>

                                <tr>
                                    <td>Registration date:</td>
                                    <td>${userRegistrationDate}</td>
                                </tr>

                                <tr>
                                    <td>Role</td>
                                    <td>${userRole}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>
                                        <a href="mailto:${userEmail}">${userEmail}</a>
                                    </td>
                                </tr>


                                </tbody>
                            </table>

                            <a href="#" class="btn btn-primary">My Tests</a>
                            <a href="#" class="btn btn-primary">Rating</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>