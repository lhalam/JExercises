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

<c:choose>
    <c:when test="${currentUser}">
        <c:set var="postUrl" value="${basedir}/user/attempts" scope="request"  />
        <c:set var="panelTitle" value="My Attempts" scope="request"  />
    </c:when>
    <c:otherwise>
        <c:set var="postUrl" value="${basedir}/user/${userId}/attempts" scope="request"  />
        <c:set var="panelTitle" value="${userName} Attempts" scope="request"  />
    </c:otherwise>
</c:choose>

<body id="container">
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-center">
                    ${panelTitle}
                </h3>
            </div>
            <div class="panel-body">
                <div class="col-md-10 col-md-offset-1">
                    <table id="attempts_table"
                           class="table table-striped table-hover"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Test Name</th>
                            <th>Date</th>
                            <th>Result</th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div class="hidden" id="hidden-attr" data-basedir="${basedir}"
     data-user="${currentUser}" data-post-url="${postUrl}"></div>
</body>
</html>