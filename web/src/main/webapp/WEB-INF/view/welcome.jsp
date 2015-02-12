<%@include file="base.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>Welcome</h1>
<h1>
<c:url var="postUrl" value="j_spring_security_logout" />
<a href="${postUrl}" >Logout</a></h1>
</body>
</html>