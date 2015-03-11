<%--
  User: Volodymyr Lishchynskiy
  Date: 12.02.15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<link href="${basedir}/resources/css/testresult.css" rel="stylesheet"
	type="text/css">
<script src="${basedir}/resources/js/lib/jquery.dataTables.min.js"></script>
</head>
<body>
	<div class="row-fluid">
		<div class="col-md-offset-2 col-md-8">
			<form class="panel panel-primary">
				<div class="container-fluid">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div class="admin" id="admin">
							<div class="row-fluid">
								<div class="col-md-offset-3 col-md-6">
									<table class="table test-result-table">
										<tbody>
											<tr>
												<td><strong>User: </strong> <c:out
														value="${firstName} ${lastName}" /></td>
												<td id="user"></td>
											</tr>
											<tr>
												<td><strong>Test: </strong> <c:out value="${testName}" /></td>
												<td id="test"></td>
											</tr>
											<tr>
												<td><strong>Date: </strong> <c:out value="${date}" /></td>
												<td id="date"></td>
											</tr>
										</tbody>
									</table>
									<div class="row-fluid">
										<div class="col-md-offset-2 col-md-8">
											<hr class="colorgraph">
										</div>
									</div>
								</div>
							</div>
						</div>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
						<c:if test="${isPublic eq 'true'}">
							<script src="${basedir}/resources/js/testresult.js"></script>
							<div class="public" id="public">
								<div class="row-fluid">
									<div class="col-md-offset-4 col-md-4">
										<h4 class="wrapper" id="result">
											<strong>Test result is <c:out value="${correct}" />
												of <c:out value="${total}" /></strong>
										</h4>
									</div>
								</div>
								<br> <br>
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
						</c:if>
					</sec:authorize>

					<sec:authorize access="hasRole('ROLE_USER')">
						<c:if test="${isPublic eq 'false'}">
							<div class="panel panel-info" id="private">
								<div class="panel-heading">
									<h4 class="panel-title"></h4>
								</div>
								<div class="panel-body">
									<strong>Thank you for passing test!</strong>
								</div>
							</div>
						</c:if>
					</sec:authorize>
					<div class="col-md-2 col-lg-2 col-md-offset-5 pos" id="okbtn">
						<a href="${basedir}/login" class="btn btn-success okbtn"
							type="button">OK</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
