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
<form action="./register" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="number" name="id"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="number" name="age"></td>
		</tr>
		<tr>
			<td>DOB</td>
			<td><input type="date" name="dob"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="reset"></td>
			<td><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>