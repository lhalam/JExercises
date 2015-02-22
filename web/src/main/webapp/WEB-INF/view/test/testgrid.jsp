<%--
  User: Ihor Demkovych
  Date: 14.02.15
  Time: 22:40
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="../base.jsp"/>
    <jsp:include page="../navigation.jsp"/>
    <script src="resources/js/testgrid.js"></script>
    <script src="resources/js/lib/bootstrap-paginator.min.js"></script>
</head>
<body id="container">
 ​<div class="container">
    <div class="row-fluid">
        <form class="panel panel-primary">
            <div class="table-responsive">
                <div id="testgrid"></div>
                <div class="col-md-6">
                    <ul class="pagination pagination-control">
                        <li id="showEntries" class="active"><a>Show entries:</a></li>
                        <li id="button5" class=""><a>5</a></li>
                        <li id="button10"><a>10</a></li>
                        <li id="button25"><a>25</a></li>
                        <li id="button50"><a>50</a></li>
                    </ul>
                </div>
                <div class="col-md-offset-3">
                    <ul class="pagination pagination-control">
                        <li><a id="button" >&laquo;</a></li>
                        <li><a href="testgrid12">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
