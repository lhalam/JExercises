<%--
  User: Volodymyr Lishchynskiy
  Date: 12.02.15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<%@include file="../base.jsp"%>
<%@include file="../navigation.jsp"%>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="${basedir}/resources/css/lib/dataTables.bootstrap.css">
<link href="${basedir}/resources/css/loading-icon.css" rel="stylesheet"
	type="text/css">
<script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
<script src="${basedir}/resources/js/testresult.js"></script>
</head>
<body>
	<div id="loadingIcon" class="form-group">
		<div class="col-md-offset-4 col-md-4 text-center">
			<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
		</div>
	</div>
	<div class="row-fluid">
		<div class="col-md-offset-2 col-md-8">
			<form class="panel panel-primary">
				<div class="container-fluid">
					<div class="admin" id="admin">
						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<p id="user"></p>
							</div>
						</div>
						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<p id="test"></p>
							</div>
						</div>

						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<p id="date"></p>
							</div>
						</div>

						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<hr class="colorgraph">
							</div>
						</div>
					</div>

					<div class="public"id="public">
						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<h4 id="result"></h4>
							</div>
						</div>
						<div class="row-fluid">
							<div class="col-md-offset-2 col-md-8">
								<table id="testresult"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th>Question</th>
											<th>Result</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-info" id="private">
						<div class="panel-heading">
							<h5 class="panel-title">Panel title</h5>
						</div>
						<div class="panel-body">
							<strong>Thank you for passing test!</strong>
						</div>
					</div>
					<div class="col-md-2 col-lg-2 col-md-offset-5" id="okbtn"
						style="margin-top: 40px; height: 50px">
						<a href="${basedir}/login" class="btn btn-success" type="button"
							style="height: 30px; width: 80px">OK</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
