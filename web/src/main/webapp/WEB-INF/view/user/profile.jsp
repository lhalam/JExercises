<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <c:set var="basedir" value="${pageContext.request.contextPath}"/>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <link href="${basedir}/resources/css/profile.css" rel="stylesheet"
          type="text/css">
    <link href="${basedir}/resources/css/loading-icon.css" rel="stylesheet"
          type="text/css">
    <script src="${basedir}/resources/js/profile.js"></script>
</head>

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
                                src="/web/user/profile/avatar"
                                class="img-circle"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Name:</td>
                                    <td id="userFirstName"></td>
                                </tr>
                                <tr>
                                    <td>Surname:</td>
                                    <td id="userLastName"></td>
                                </tr>
                                <tr>
                                    <td>Registration date:</td>
                                    <td id="userRegistrationDate"></td>
                                </tr>
                                <tr>
                                    <td>Date of Birth:</td>
                                    <td id="userDateOfBirth"></td>
                                </tr>
                                <tr>
                                    <td>Role</td>
                                    <td id="userRole"></td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td id="userEmail">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Broadcast Message"
                       data-toggle="tooltip" type="button"
                       class="btn btn-sm btn-primary"><i
                            class="glyphicon glyphicon-user"></i></a>
                        <span class="pull-right">
                            <a href="/web/user/profile/edit"
                               data-original-title="Edit this user"
                               data-toggle="tooltip" type="button"
                               class="btn btn-sm btn-warning"><i
                                    class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user"
                               data-toggle="tooltip" type="button"
                               class="btn btn-sm btn-danger"><i
                                    class="glyphicon glyphicon-remove"></i></a>
                        </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>