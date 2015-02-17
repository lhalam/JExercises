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
    <jsp:include page="base.jsp"/>
    <jsp:include page="navigation.jsp"/>
</head>
<body id="container">
<div class="container">
    <div class="row-fluid" id="testgrid">
        <form class="panel panel-primary">


            <div class="table-responsive">


                <table class="table table-bordered">
                    <tr class="row">
                        <td class="field-label col-md-10 active">
                            <label><strong>Description</strong></label>
                        </td>
                        <td class="col-md-2 active">
                            <label><strong>Availability</strong></label>
                        </td>
                    </tr>
                    <% for (Test test : DataRepository.GetTests()) { %>
                    <tr class="row">
                        <td class="field-label col-md-10 ">

                            <%=test.getTestDescription()%>
                        </td>
                        <td class="col-md-2">
                            <%=test.getTestIsPublic()%>
                        </td>
                    </tr>
                    <% } %>
                </table>
                <div class="col-md-6">
                    <ul class="pagination pagination-control">
                        <li><a>Show entries:</a></li>
                        <li><a href="#">10</a></li>
                        <li><a href="#">25</a></li>
                        <li><a href="#">50</a></li>
                        <li><a href="#">100</a></li>
                    </ul>
                </div>
                <div class="col-md-offset-3">
                    <ul class="pagination pagination-control">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
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
