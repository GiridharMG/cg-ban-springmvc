<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./login" method="post">
	<table>
		<tr>
			<td>ID:</td>
			<td><input type="number" name="id"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="reset"></td>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
<a href="./register">Click here to register</a>
<h3>${msg}</h3>
</body>
</html>




