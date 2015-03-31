<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <script src="${basedir}/resources/js/testdescription.js"></script>
    <link href="${basedir}/resources/css/testdescription.css" rel="stylesheet" type="text/css">
</head>
<body id="container">
<input type="hidden" id="contextRootHolder" value="${basedir}" />
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-sm-10 col-md-8 col-lg-8 col-xs-offset-1 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 ">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="h4" id="panel-title"></div>
                </div>
                <div class="container-fluid">
                    <div class=" col-md-10 col-lg-10 col-md-offset-1 col-md-offset-1 ">
                        <div class="test-description-panel">
                            <div id="test-description"></div>
                        </div>
                    </div>
                    <hr class="line"/>
                    <div class="col-md-2 col-lg-2 col-md-offset-5 col-lg-offset-5">
                        <button id="btnsub" type="button" class="btn btn-success btn-block">Start test</button>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
