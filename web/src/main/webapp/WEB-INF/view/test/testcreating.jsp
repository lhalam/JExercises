<%--
  User: Ihor Demkovych
  Date: 07.03.15
  Time: 04:47
--%>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="basedir" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <title>JExercises</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="JExercises UI">
    <script src="${basedir}/resources/js/lib/jquery-1.11.1.js" type="text/javascript"></script>
    <link  href="${basedir}/resources/css/lib/bootstrap.css" rel="stylesheet" type="text/css">
    <link  href="${basedir}/resources/css/lib/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link  href="${basedir}/resources/css/lib/styles.css" rel="stylesheet" type="text/css">
    <link  href="${basedir}/resources/css/table.css" rel="stylesheet" type="text/css">
    <link  href="${basedir}/resources/css/lib/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
    <link  href="${basedir}/resources/ss-logo.png" rel="shortcut icon" type="text/css">
    <script src="${basedir}/resources/js/lib/bootstrap.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js" type="text/javascript"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"/>
    <link  href="${basedir}/resources/css/summernote/summernote.css" rel="stylesheet" type="text/css">
    <script src="${basedir}/resources/js/summernote/summernote.js" type="text/javascript"></script>
    <c:if test="${toDo eq 'create'}">
        <script src="${basedir}/resources/js/testcreate.js"></script>
    </c:if>
    <c:if test="${toDo eq 'edit'}">
        <script src="${basedir}/resources/js/testedit.js"></script>
    </c:if>
    <c:if test="${toDo eq 'view'}">
        <script src="${basedir}/resources/js/testview.js"></script>
    </c:if>
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
                <div class="col-md-10 col-md-offset-1">
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
                </div>
                <div class="col-md-offset-5 col-md-7">
                    <button type="button" class="btn btn-success" id="create">
                        <span class="glyphicon glyphicon-floppy-disk"></span>
                        Create new test
                    </button>
                    <br>
                    <br>
                    <br>
                </div>
                <div id="edit" class="hidden">
                    <div class="row-fluid">
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="col-md-offset-5 col-md-7">
                            <label>
                                <strong>
                                    Select the questions below
                                </strong>
                            </label>
                        </div>
                        <br>
                    </div>
                    <div class="row-fluid">
                        <div class="col-md-offset-1 col-md-10">
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-default" id="all">All questions</button>
                                <button type="button" class="btn btn-default" id="select">Added questions</button>
                            </div>
                            <button type="button" class="btn btn-default pull-right"
                                    id="add">Add new question
                            </button>
                        </div>
                        <div class="col-md-10 col-md-offset-1" id="allTable">
                            <br>
                            <table id="questionGrid" class="table table-striped table-hover"
                                   cellspacing="0" width="100%">
                                <thead>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th></th>
                                </thead>
                            </table>
                            <br>
                        </div>
                        <div class="col-md-10 col-md-offset-1" id="selectedTable">
                            <br>
                            <table id="selected" class="table table-striped table-hover"
                                   cellspacing="0" width="100%">
                                <thead>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th></th>
                                </thead>
                            </table>
                            <br>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="col-md-2 col-md-offset-5 ">
                            <button type="button" class="btn btn-success" id="save">
                                <span class="glyphicon glyphicon-floppy-disk"></span>
                                Save test
                            </button>
                            <br>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="hidden-attribute" id="hidden-attr" data-basedir="${basedir}"></div>
</body>
</html>