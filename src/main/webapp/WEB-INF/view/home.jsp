<%@page import="com.testyantra.cgbanspringmvc.beans.StudentInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="left"><a href="./logout">Logout</a></div>
<a href="./edit">Edit Account</a>
<a href="./delete">Delete Account</a>
<h1>Welcome <%=((StudentInfo)session.getAttribute("info")).getName() %></h1>
</body>
</html>