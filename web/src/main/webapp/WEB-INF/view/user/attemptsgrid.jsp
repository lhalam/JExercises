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
    <link href="${basedir}/resources/css/attemptsgrid.css"
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
    <script charset="utf8" src="${basedir}/resources/js/attemptsgrid.js"
            type="text/javascript"></script>
</head>
<body id="container">
<div class="container">
    <div class="row">
        <div class="panel panel-info">
            <div class="panel-body">
                <div class="col-md-8 col-md-offset-2">
                    <table id="attempts_table"
                           class="table table-striped table-hover"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Test Name</th>
                            <th>Date</th>
                            <th>Result</th>
                            <th class="col-md-2"></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="hidden-attribute" id="hidden-attr" data-basedir="${basedir}"></div>
</body>
</html>