<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${basedir}/resources/js/account-menu.js"></script>
<link href="${basedir}/resources/css/account-menu.css" rel="stylesheet"
	type="text/css">
<div class="dropdown">
	<input type="hidden" id="postUrl" value="${basedir}/account/menu" />
	<button class="dropdown-toggle navbar navbar-default borderless"
		type="button" data-toggle="dropdown">
		<span class="withPadding"><img id="avatar" class="img-circle sized"
			alt="User Pic" src="${basedir}/user/profile/avatar"></span> <span
			id="menuUsername" class="nav navbar-nav withPadding"></span> <span
			class="caret"></span>
	</button>
	<ul class="dropdown-menu dropdown-menu-right" role="menu"
		aria-labelledby="dLabel">
		<li role="presentation"><a role="menuitem" tabindex="-1"
			href="${basedir}/user/profile">View profile</a></li>
		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">View
				my attempts</a></li>
		<li role="presentation"><a role="menuitem" tabindex="-1"
			href="${basedir}/user/profile/edit">Edit profile</a></li>
		<li class="divider"></li>
		<li><%@ include file="logout.jsp"%></li>
	</ul>
</div>