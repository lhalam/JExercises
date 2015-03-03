<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <link href="${basedir}/resources/css/profile.css" rel="stylesheet"
          type="text/css">
    <link href="${basedir}/resources/css/loading-icon.css" rel="stylesheet"
          type="text/css">
    <script src="${basedir}/resources/js/profile.js"></script>
</head>

<c:choose>
    <c:when test="${currentUser}">
        <c:set var="postUrl" value="${basedir}/user/profile" scope="session"  />
    </c:when>
    <c:otherwise>
        <c:set var="postUrl" value="${basedir}/user/profile/${userId}" scope="session"  />
    </c:otherwise>
</c:choose>

<body id="container">
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Profile</h3>
                </div>
                <div class="panel-body">
                    <div id="loadingIcon" class="form-group">
                        <div class="col-md-12 text-center">
                            <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
                        </div>
                    </div>
                    <div id="profileForm" class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img
                                alt="User Pic"
                                src="${postUrl}/avatar"
                                class="img-circle"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td><strong>Name:</strong></td>
                                    <td id="userFirstName"></td>
                                </tr>
                                <tr>
                                    <td><strong>Surname:</strong></td>
                                    <td id="userLastName"></td>
                                </tr>
                                <tr>
                                    <td><strong>Registration date:</strong></td>
                                    <td id="userRegistrationDate"></td>
                                </tr>
                                <tr>
                                    <td><strong>Date of Birth:</strong></td>
                                    <td id="userDateOfBirth"></td>
                                </tr>
                                <tr>
                                    <td><strong>Email:</strong></td>
                                    <td id="userEmail">
                                    </td>
                                </tr>
                                <tr>
                                    <td><strong>Role:</strong></td>
                                    <td id="userRole"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a type="button"
                       class="btn btn-success btn-sm"><span
                            class="glyphicon glyphicon-th-list"></span> View
                        attempts</a>

                    <div class="pull-right">
                        <a href="${basedir}/user/profile/edit"
                           type="button"
                           class="btn btn-warning btn-sm"><span
                                class="glyphicon glyphicon-edit"></span>
                            Edit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="hidden-attribute" id="hidden-attr" data-post-url="${postUrl}"></div>
</div>
</body>
</html>