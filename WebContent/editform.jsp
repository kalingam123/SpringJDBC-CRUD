<%@ page import="com.kali.beans.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
Student student = null;
%>
<%
student = (Student) request.getAttribute("student");
%>
<html>
<head>
<title>Student Edit Form</title>
</head>
<body>
<h2 style="color: red;" align="center">Student Management System</h2>
<h3 style="color: blue;" align="center">Student Edit Form</h3>
<form method="post" action="update">
<table align="center">
<tr>
<td>Student Id</td>
<td><%=student.getSid()%><input type="hidden" name="sid" value='<%=student.getSid()%>'></td>
</tr>
<tr>
<td>Student Name</td>
<td><input type="text" name="sname"
value='<%=student.getSname()%>'></td>
</tr>
<tr>
<td>Student Address</td>
<td><input type="text" name="saddr"
value='<%=student.getSaddr()%>'></td>
</tr>
<tr>
<td><input type="submit" value="UPDATE"></td>
</tr>
</table>
</form>
</body>
</html>