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
<script src="resources/js/testgrid.js"></script>
<body id="container">
​
<div class="container">
    <div class="row-fluid">
        <form class="panel panel-primary">
            <div class="table-responsive">
                <div class="row-fluid">
                    <br>
                        <div class="col-md-offset-5 col-md-1">
                            <h3>Tests</h3>
                        </div>
                        <div class="search col-md-3 col-md-offset-2">
                            <input id="fieldsearch" type="text" class="form-control input-sm" maxlength="24"
                                   placeholder="Type to search"/>
                        </div>
                        <div class="col-md-1">
                            <input id="searchfield" type="button" class="btn btn-primary btn-sm" value="Search"/>
                        </div>
                    </br>
                </div>
                <br></br>
                    <div class="col-md-1 col-md-offset-5" id="noresults">
                        <p>No results</p>
                    </div>
                <div id="testgrid"></div>
                <div class="row-fluid">
                    <form class="panel panel-primary">
                        <div class="col-md-8">
                            <button id="show" type="button" class="btn btn-primary disabled"> Show entries:</button>
                            <button id="button5" type="button" class="btn btn-default"> 5</button>
                            <button id="button10" type="button" class="btn btn-default btn-primary"> 10</button>
                            <button id="button25" type="button" class="btn btn-default"> 25</button>
                            <button id="button50" type="button" class="btn btn-default"> 50</button>
                        </div>
                        <div class="col-md-4" id="pagebar">
                            <input type='button' id="firstpage" type="button" class="btn btn-default" value="<<">
                            <input type='button' id="previouspage" type="button" class="btn btn-default" value="0">
                            <input type='button' id="currentpage" type="button" class="btn btn-primary" value="1">
                            <input type='button' id="nextpage" type="button" class="btn btn-default" value="2">
                            <input type='button' id="lastpage" type="button" class="btn btn-default" value=">>">
                            <input id="info" type="button" class="btn btn-primary disabled" value="Results:">
                        </div>
                        <br>
                        </br>
                    </form>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
