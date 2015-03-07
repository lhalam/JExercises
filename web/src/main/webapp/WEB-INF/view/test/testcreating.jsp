<%--
  User: Ihor Demkovych
  Date: 07.03.15
  Time: 04:47
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
    <script src="${basedir}/resources/js/testcreating.js"></script>
    <script src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js"></script>
</head>
<jsp:include page="../navigation.jsp"/>
<body id="container">
<div class="row-fluid">
    <div class="col-md-offset-1 col-md-10">
        <form class="panel panel-primary">
            <div class="container-fluid">
                <div class="col-md-offset-5 col-md-7">
                    <h3>
                        Create new test
                    </h3>
                </div>
                <div class="form-group">
                    <label>Test name:</label>
							<textarea class="form-control summernote" rows="2"
                                      id="testName" placeholder="Input test name..."></textarea>
                </div>
                <div class="form-group">
                    <label>Description:</label>
							<textarea class="form-control summernote" rows="4"
                                      id="testDescription"
                                      placeholder="Input test description..."></textarea>
                </div>
                <form role="form">
                    <label>Check an availability :</label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio" id="public" checked>
                        Public
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio" id="private">
                        Private
                    </label>
                </form>
                <div class="row-fluid">
                    <div class="col-md-offset-5 col-md-7">
                        <br>
                        <label>
                            <strong>
                                Select the questions below
                            </strong>
                        </label>
                        <br>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="col-md-offset-5 col-md-2">
                        <button type="button" id="seeselected" class="btn btn-default pull-right">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            Selected
                        </button>
                        <button type="button" id="addnew" class="btn btn-default pull-left">
                            <span class="glyphicon glyphicon-plus"></span>
                            Add
                        </button>
                        <br>
                    </div>
                </div>
                <div class="row-fluid " id="tableSource">
                    <div class="col-md-offset-1 col-md-10">
                        <table id="questionSource" class="table table-striped table-bordered"
                               cellspacing="0" width="100%">
                            <thead>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th class="col-md-2 pull-right"></th>
                            </tr>
                            </thead>
                        </table>
                        <br>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="col-md-offset-5 col-md-2">
                        <button type="button" class="btn btn-success">
                            Save test
                        </button>
                    </div>
                </div>
            </div>
            <br>
        </form>
    </div>
</div>
</body>
</html>