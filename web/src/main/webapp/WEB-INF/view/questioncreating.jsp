<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<%@ include file="navigation.jsp"%>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" />
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/css/summernote/summernote.css">
<script type="text/javascript"
	src="resources/js/summernote/summernote.js"></script>
<script src="resources/js/questioncreating.js"></script>
<!-- <script src="resources/js/summernote/qc.js"></script> -->
<body background="resources/background.jpg">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<form method="POST" id="questioncreatingForm"
				class="panel panel-default">
				<div class="row">
					<div class="col-md-offset-4 col-md-6">
						<h1>Create new question</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-offset-2 col-md-8">
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
						<div class="form-group">
							<label for="comment">Answer:</label>
							<textarea class="form-control" rows="2" id="expectedAnswer"
								placeholder="Input expected answer..."></textarea>
						</div>
						<div class="form-group">
							<label for="comment">Input Data:</label>
							<textarea class="form-control" rows="2" id="inputData"
								placeholder="Input data..."></textarea>
						</div>
						<div class="row">
							<div class="col-md-offset-4 col-md-4">
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Create question" id="submitButton">
							</div>
						</div>
						<br></br>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>