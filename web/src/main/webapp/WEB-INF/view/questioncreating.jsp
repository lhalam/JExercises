<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<script src="http://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" />
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/css/summernote/summernote.css">
<script type="text/javascript"
	src="resources/js/summernote/summernote.js"></script>


<script
	src="http://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"
	type="text/javascript"></script>


<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.5/css/jquery.dataTables.css" />


<script src="resources/js/questioncreating.js"></script>
<style type="text/css">
tr {
	height: 25px
}
</style>
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
							<textarea class="form-control summernote" rows="2"
								id="questionName" placeholder="Input question name..."></textarea>
						</div>
						<div class="form-group">
							<label for="comment">Description:</label>
							<textarea class="form-control summernote" rows="4"
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
							<div class="col-md-offset-4 col-md-4">
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Add row" id="addRow">
							</div>
						</div>
						<div class="row">
							<div class="col-md-offset-4 col-md-4">
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
</body>
</html>