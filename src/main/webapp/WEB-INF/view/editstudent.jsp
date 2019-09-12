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
<%
	StudentInfo info = (StudentInfo)session.getAttribute("info");
%>
<form action="./edit" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="number" name="id" value="<%=info.getId()%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="<%=info.getName()%>"></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="number" name="age" value="<%=info.getAge()%>"></td>
		</tr>
		<tr>
			<td>DOB</td>
			<td><input type="date" name="dob" value="<%=info.getDob()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" value="<%=info.getOtherInfo().getEmail()%>"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value="<%=info.getOtherInfo().getPassword()%>"></td>
		</tr>
		<tr>
			<td><input type="reset"></td>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>