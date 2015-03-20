<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="basedir" value="${pageContext.request.contextPath}" />

<%@ include file="../base.jsp"%>
<%@ include file="../navigation.jsp"%>

<link href="${basedir}/resources/css/lib/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">
<link href="${basedir}/resources/css/testresult.css" rel="stylesheet"
	type="text/css">
<link href="${basedir}/resources/css/usergrid.css" rel="stylesheet"
	type="text/css">	
<script charset="utf8"
	src="${basedir}/resources/js/lib/jquery-1.11.1.js"
	type="text/javascript"></script>
<script charset="utf8"
	src="${basedir}/resources/js/lib/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script charset="utf8"
	src="${basedir}/resources/js/lib/bootstrap.jquery.dataTable.js"
	type="text/javascript"></script>
<script src="${basedir}/resources/js/attempts.js"></script>

</head>

<c:set var="testName" value="All attempts to ${testName}" />

<body id="container">
	<div class="row-fluid">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title text-center">${testName}</h4>
				</div>
				<div class="panel-body">
					<div class="col-md-10 col-md-offset-1">
						<table id="test_attempts_table"
							class=" table table-striped
							table-hover" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th>ID</th>
									<th id="name"
										<sec:authorize access = "hasRole('ROLE_USER')">
										class="hidden"
										</sec:authorize>>
										Name</th>
									<th id="surname"
										<sec:authorize access = "hasRole('ROLE_USER')">
									class="hidden"
									</sec:authorize>>
										Surname</th>
									<th>Date</th>
									<th>Result</th>
									<th class="col-md-2"></th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="col-md-2 col-lg-2 col-md-offset-5 pos">
						<a href="${basedir}/tests" class="btn btn-success btn-block mybtn"
							type="button">Back</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hidden-attribute" id="hidden-attr"
		data-basedir="${basedir}"></div>
</body>
</html>