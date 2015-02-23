<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<html>
<head>
<%@ include file="base.jsp"%>
</head>
<%@ include file="navigation.jsp"%>
<script src="resources/js/questioncreating.js"></script>
<body>
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
							<textarea class="form-control" rows="4" id="questionName"
								placeholder="Input question name..."></textarea>
						</div>
						
						<div class="form-group">
							<label for="comment">Description:</label>
							<textarea class="form-control" rows="4" id="questionDescription"
								placeholder="Input question description..."></textarea>
						</div>

						<div class="form-group">
							<label for="comment">Answer:</label>
							<textarea class="form-control" rows="4" id="expectedAnswer"
								placeholder="Input expected answer..."></textarea>
						</div>

						<div class="form-group">
							<label for="comment">Input Data:</label>
							<textarea class="form-control" rows="4" id="inputData"
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