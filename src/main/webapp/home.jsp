<%@page import="ticketreport.springmvc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<c:out value="${message}"/>

    <h1>Welcome, ${userData.userName}</h1>
     
    
    
</body>
</html>