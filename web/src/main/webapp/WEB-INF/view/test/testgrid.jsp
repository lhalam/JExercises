<%--
  User: Ihor Demkovych
  Date: 14.02.15
  Time: 22:40
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../base.jsp"/>
<jsp:include page="../navigation.jsp"/>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="${basedir}/web/resources/css/table.css">
<script src="${basedir}/web/resources/js/lib/jquery.dataTables.min.js"></script>
<script src="${basedir}/web/resources/js/testgrid.js"></script>
<body id="container">
<div class="row-fluid">
    <div class="col-md-offset-2 col-md-8">
        <form class="panel panel-primary">
            <div class="container-fluid">
                <div class="col-md-offset-5 col-md-1">
                    <h3>
                        Tests
                    </h3>
                </div>
                <div class="row-fluid ">
                    <div class="col-md-offset-2 col-md-8 gridtableborder">
                        <br></br>
                        <table id="testgrid" class="display cell-border row-border"
                               cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Availability</th>
                            </tr>
                            </thead>

                            <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Availability</th>
                            </tr>
                            </tfoot>
                        </table>
                        <br></br>
                    </div>
                </div>
            </div>
            <br></br>
        </form>
    </div>
</div>
</body>
</html>
