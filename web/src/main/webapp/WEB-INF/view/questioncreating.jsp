<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" />
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${basedir}/resources/css/summernote/summernote.css">
<script type="text/javascript"
	src="${basedir}/resources/js/summernote/summernote.js"></script>
<script
	src="http://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.5/css/jquery.dataTables.css" />
<script src="${basedir}/resources/js/questioncreating.js"></script>
<link rel="stylesheet" href="${basedir}/resources/css/questionpage.css">
<%@ include file="navigation.jsp"%>
</head>
<body background="${basedir}/resources/background.jpg">
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
							<textarea class="form-control summernote" id="questionName"
								placeholder="Input question name..."></textarea>
						</div>
						<div class="form-group">
							<label for="comment">Description:</label>
							<textarea class="form-control summernote"
								id="questionDescription"
								placeholder="Input question description..."></textarea>
						</div>
						<div class="row">
							<div class="btn-group col-md-4" role="group"
								style="padding-left: 30px;">
								<button class="btn btn-primary" type="button" id="addRow">
									<span class="glyphicon glyphicon-plus"> </span>Add row
								</button>
							</div>

						</div>
						<div class="col-md-12">
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
						<div class="col-md-7 col-md-offset-5 ">
                            <button type="button" class="btn btn-success" id="submitButton">
                                <span class="glyphicon glyphicon-floppy-disk"></span>
                                Save question
                            </button>
                            <br>
                            <br>
                        </div>
						<br>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hidden-attribute" id="hidden-attr"
		data-basedir="${basedir}"></div>
</body>
</html>