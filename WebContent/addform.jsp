<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Student Add Form</title>
</head>
<body>
	<h2 style="color: red;" align="center">Student Management System</h2>
	<h3 style="color: blue;" align="center">Student Add Form</h3>
<form method="post" action="add">
	<table align="center">
	<tr>
		<td>Student Id</td>
		<td><input type="text" name="sid"></td>
	</tr>
	<tr>
		<td>Student Name</td>
		<td><input type="text" name="sname"></td>
	</tr>
	<tr>
		<td>Student Address</td>
		<td><input type="text" name="saddr"></td>
	</tr>
	<tr>
		<td><input type="submit" value="ADD"></td>
	</tr>
</table>
</form>
</body>
</html>