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
<c:set var="basedir" value="${pageContext.request.contextPath}" />

<%@include file="../base.jsp"%>
<%@include file="../navigation.jsp"%>
<link href="${basedir}/resources/css/lib/dataTables.tableTools.css"
	rel="stylesheet" type="text/css">	
<link href="${basedir}/resources/css/lib/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">	
<link href="${basedir}/resources/css/testresult.css" rel="stylesheet"
	type="text/css">
<link href="${basedir}/resources/css/loading-icon.css" rel="stylesheet"
	type="text/css">
<script charset="utf8"
	src="${basedir}/resources/js/lib/jquery-1.11.1.js"
	type="text/javascript"></script>
<script charset="utf8"
	src="${basedir}/resources/js/lib/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script charset="utf8"
	src="${basedir}/resources/js/lib/dataTables.tableTools.js"
	type="text/javascript"></script>	
<script charset="utf8"
	src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js"
	type="text/javascript"></script>
</head>
<body>
	<c:set var="show" value="${false}" />
	<sec:authorize access="hasRole('ROLE_USER')">
		<c:if test="${isPublic eq 'true'}">
			<c:set var="show" value="${true}" />
		</c:if>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:set var="show" value="${true}" />
	</sec:authorize>
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
												<td id="user"><strong>User: </strong></td>
											</tr>
											<tr>
												<td id="test"><strong>Test: </strong></td>
											</tr>
											<tr>
												<td id="date"><strong>Date: </strong></td>
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
					<c:if test="${show eq 'true'}">
						<script src="${basedir}/resources/js/testresult.js"></script>
						<div id="loadingIcon" class="form-group">
							<div class="col-md-12 text-center">
								<span
									class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
							</div>
						</div>
						<div class="public" id="public">
							<div class="row-fluid">
								<div class="col-md-offset-4 col-md-4 wrapper">
									<h4 class="wrapper" id="result"></h4>
								</div>
							</div>
							<div class="row-fluid">
								<div class="col-md-offset-1 col-md-10 wrapper">
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
					<sec:authorize access="hasRole('ROLE_USER')">
						<c:if test="${isPublic eq 'false'}">
							<div class="row-fluid" id="private">
								<div class="text">
									<h4>
										<strong>Thank you for completing a test!</strong>
									</h4>
								</div>
							</div>
						</c:if>
					</sec:authorize>
					<div class="col-md-2 col-lg-2 col-md-offset-5 pos" id="okbtn">
						<a href="${basedir}/tests" class="btn btn-block btn-success mybtn"
							type="button">OK</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hidden-attribute" id="hidden-attr"
		data-basedir="${basedir}"></div>
</body>
</html>