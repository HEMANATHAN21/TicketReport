<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
	<form:form action="save" modelAttribute="user" method="post">
		<h1>SignUp Page</h1>
		
		<label> User Name </label>
		<form:input path="userName"/>
		<br>
		<label> User Mail </label>
		<form:input path="userMail"/>
		<br>
		<label> User Password </label>
		<form:input path="userPassword"/>
		<br>
		<input type="submit">
	</form:form>
</body>
</html>