<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <script src="${basedir}/resources/js/testdescription.js"></script>
</head>

<body id="container">
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-sm-10 col-md-8 col-lg-8 col-xs-offset-1 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 ">
            <div class="panel panel-info" style="text-align: center;">
                <div class="panel-heading">
                    <h3 class="panel-title" align="middle" style="text-height: inherit"></h3>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class=" col-md-10 col-lg-10 col-md-offset-1 col-md-offset-1 ">
                            <div id="test" style="margin-top:15px; "><h4>Description:</h4></div>
                            <div id="test-description" style="text-align:justify"></div>
                        </div>
                        <br>
                        <hr align="center" width="90%"/>
                        <div class="col-md-2 col-lg-2 col-md-offset-5" id="pagebar" style="margin-top: 5px;">
                            <input class="btn btn-success btn-md" type="submit" value="Start test" id="btnsub">
                            <br>
                            <br>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
