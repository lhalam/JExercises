<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>

    <link href="${basedir}/resources/css/lib/dataTables.bootstrap.css"
          rel="stylesheet"
          type="text/css">
    <link href="${basedir}/resources/css/usergrid.css"
          rel="stylesheet"
          type="text/css">
    <script charset="utf8" src="${basedir}/resources/js/lib/jquery-1.11.1.js"
            type="text/javascript"></script>
    <script charset="utf8"
            src="${basedir}/resources/js/lib/jquery.dataTables.min.js"
            type="text/javascript"></script>
    <script charset="utf8"
            src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js"
            type="text/javascript"></script>
    <script charset="utf8" src="${basedir}/resources/js/usergrid.js"
            type="text/javascript"></script>
</head>
<body id="container">
<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-center">
                    Users Search
                </h3>
            </div>
            <div class="panel-body">
                <div class="col-md-10 col-md-offset-1">
                    <table id="users_table"
                           class="table table-striped table-hover"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Reg. Date</th>
                            <th>Role</th>
                            <th class="col-md-2"></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="hidden" id="hidden-attr" data-basedir="${basedir}"></div>
</body>
</html>