<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Welcome Page</h2>

<c:if test="${not empty message}">
    <c:out value="${message}" />
</c:if>

<div>
	<h1>For Signup Click below Link</h1>
	<a href="signup">SignUp</a>
	
</div>

<div>
	<h1>For Signin Click below Link</h1>
	<a href="signin.jsp">SignIn</a>
	
</div>

</body>
</html>
