<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="base.jsp"%>
</head>
<%@ include file="navigation.jsp"%>
<body>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<form class="panel panel-default">
				<div class="row">
					<div class="col-md-offset-4 col-md-6">
						<h1>Create new question</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-offset-2 col-md-8">


						<form role="form">
							<div class="form-group">
								<label for="comment">Description:</label>
								<textarea class="form-control" rows="5" id="comment"
									placeholder="Input question description..."></textarea>
							</div>
						</form>



						<form role="form">
							<div class="form-group">
								<label for="comment">Answer:</label>
								<textarea class="form-control" rows="5" id="comment"
									placeholder="Input expected answer..."></textarea>
							</div>
						</form>
						<div class="row">
							<div class="col-md-offset-4 col-md-4">
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Create question" id="btnsq">
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