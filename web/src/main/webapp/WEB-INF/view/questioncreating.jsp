<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
    <c:set var="basedir" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <title>JExercises</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="JExercises UI">
    <script src="${basedir}/resources/js/lib/jquery-1.11.1.js" type="text/javascript"></script>
    <link href="${basedir}/resources/css/lib/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/lib/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/lib/styles.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/table.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/css/lib/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${basedir}/resources/ss-logo.png" rel="shortcut icon" type="text/css">
    <script src="${basedir}/resources/js/lib/bootstrap.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js" type="text/javascript"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"/>
    <link href="${basedir}/resources/css/summernote/summernote.css" rel="stylesheet" type="text/css">
    <script src="${basedir}/resources/js/summernote/summernote.js" type="text/javascript"></script>
    <script src="${basedir}/resources/js/questioncreating.js"></script>
<%@ include file="navigation.jsp"%>
</head>
<body background="resources/background.jpg">
	<div class="row">
		<div class="col-md-offset-1 col-md-10">
			<form method="POST" id="questioncreatingForm"
				class="panel panel-default">
				<div class="row">
					<div class="col-md-offset-4 col-md-6">
						<h1>Create new question</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-offset-1 col-md-10">
						<div class="form-group">
							<label for="comment">Question name:</label>
							<textarea class="form-control summernote"
								id="questionName" placeholder="Input question name..."></textarea>
						</div>
						<div class="form-group">
							<label for="comment">Description:</label>
							<textarea class="form-control summernote"
								id="questionDescription"
								placeholder="Input question description..."></textarea>
						</div>

						<div class="row">
							<div class="col-md-offset-4 col-md-4">
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Create question" id="submitButton">
							</div>
						</div>
						<div class="col-md-offset-1 col-md-10">
							<table id="assert" class="display">
								<thead>
									<tr>
										<th>Expected answer</th>
										<th>Input data</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Expected answer</th>
										<th>Input data</th>
									</tr>
								</tfoot>
								<tbody>
									<tr id="table_row">
										<td class="editable"></td>
										<td class="editable"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-md-offset-1 col-md-2">
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Add row" id="addRow">
							</div>
						</div>
						<div class="row">
							<div class="col-md-offset-8 col-md-2">
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Save" id="save">
							</div>
						</div>
						<br>
					</div>
				</div>
			</form>
		</div>
	</div>
    <div class="hidden-attribute" id="hidden-attr" data-basedir="${basedir}"></div>
</body>
</html>