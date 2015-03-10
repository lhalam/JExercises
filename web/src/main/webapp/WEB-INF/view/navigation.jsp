<%--
  User: Ihor Demkovych
  Date: 11.02.15
  Time: 14:15
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">JExercises </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${basedir}/welcome">General </a></li>
                <li><a href="${basedir}/about">About</a></li>
                <li><a href="${basedir}/testsgrid">Tests</a></li>
            </ul>
            <sec:authorize access="isAnonymous()">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${basedir}/user/registration">Registration</a></li>
                <li><a href="${basedir}/login">Login</a></li>
            </ul>
            </sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-right">
					<li><%@ include file="account-menu.jsp"%></li>
				</ul>
			</sec:authorize>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
