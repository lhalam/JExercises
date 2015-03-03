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
<script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
<script src="${basedir}/resources/js/testresult.js"></script>
</head>
<body>
	<div class="row-fluid">
		<div class="col-md-offset-2 col-md-8">
			<form class="panel panel-primary">
				<div class="container-fluid">
					<div class="admin">
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

					<div class="public">
						<div class="row-fluid">
							<div class="col-md-offset-4 col-md-4">
								<p id="result"></p>
							</div>
						</div>

						<div class="userpublic">
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
					</div>
					<div class="row-fluid private">
						<div class="col-md-offset-4 col-md-8">
							<p id="thanks">
								<strong>Thank you for complete test !</strong>
							</p>
						</div>
					</div>

					<div class="col-md-2 col-lg-2 col-md-offset-5 okbtn" id="pagebar"
						style="margin-top: 50px; height: 50px">
						<a class="btn btn-primary btn-sm" type="button"
							style="height: 30px; width: 70px"
							href="http://localhost:9090/web/login.com">OK</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
