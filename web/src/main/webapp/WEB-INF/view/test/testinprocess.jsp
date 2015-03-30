<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <script src="${basedir}/resources/js/testinprocess.js"></script>
    <link href="${basedir}/resources/css/test-in-process.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/loading-icon.css" rel="stylesheet"
          type="text/css">
</head>
<body id="container">
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-sm-10 col-md-8 col-lg-8 col-xs-offset-1 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 ">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="h4" id="panel-title"></div>
                </div>
                <div class="container-fluid">
                    <div class="col-md-10 col-lg-10 col-md-offset-1 col-md-offset-1">
                        <div class="question-description-panel">
                            <div id="loadingIcon" class="form-group">
                                <div class="col-md-offset-4 col-md-4 text-center">
                                    <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
                                </div>
                            </div>
                            <div id="question-description"></div>
                        </div>
                        <hr class="line"/>
                        <div class="form-group">
                            <div class="question-answer">
                                <label for="question-answer">Answer:</label>
                            </div>
                        <textarea class="form-control custom-font"  rows="8" id="question-answer"
                                  placeholder="Input answer..."></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <ul class="pager">
                            <li id="btnprev"><a>&larr; Previous</a></li>
                            <li id="btnnext"><a>Next &rarr;</a></li>
                            <li id="btnfinish"><a>Submit</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
