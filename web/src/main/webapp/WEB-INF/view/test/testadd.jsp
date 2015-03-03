<%--
  Created by IntelliJ IDEA.
  User: rphysicist
  Date: 03.03.15
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="basedir" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <title>JExercises</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="JExercises UI">
    <meta name="author" content="Lv-137.|Java">
    <link href="${basedir}/resources/css/lib/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/lib/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/lib/styles.css" rel="stylesheet">
    <link rel="stylesheet" href="${basedir}/resources/css/table.css">
    <link rel="stylesheet" href="${basedir}/resources/css/lib/dataTables.bootstrap.css" type="text/css">
    <link rel="shortcut icon" href="${basedir}/resources/ss-logo.png">
    <script src="${basedir}/resources/js/lib/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/bootstrap.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
    <script src="${basedir}/resources/js/testsgrid.js"></script>
    <script src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js"></script>
</head>
<jsp:include page="../navigation.jsp"/>
<body id="container">
<div class="row-fluid">
    <div class="col-md-offset-1 col-md-10">
        <form class="panel panel-primary">
            <div class="container-fluid">
                <div class="col-md-offset-5 col-md-1">
                    <h3>
                        Tests
                    </h3>
                </div>
                <div class="row-fluid ">
                    <div class="col-md-offset-1 col-md-10">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-pencil"></span>
                            Add test
                        </button>
                    </div>
                </div>
                <div class="row-fluid ">
                    <div class="col-md-offset-1 col-md-10">
                        <br>
                        <table id="testsGrid" class="table table-striped table-bordered"
                               cellspacing="0" width="100%">
                            <thead>
                            <th>Name</th>
                            <th>Availability</th>
                            <th class="pull-right">Command</th>
                            </tr>
                            </thead>
                        </table>
                        <br>
                    </div>
                </div>
            </div>
            <br>
        </form>
    </div>
</div>
</body>
</html>
