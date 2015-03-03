<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<c:url var="logoutUrl" value="${basedir}/j_spring_security_logout" />
	<a href="${logoutUrl}">Logout</a>
</body>
</html>