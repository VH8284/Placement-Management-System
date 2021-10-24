<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<h1>Company Registration</h1>
	<form action = "<%= request.getContextPath() %>/register" method="post">
	<table style = "with:80%">
	<tr>
	<td>Name</td>
	<td><input type="text" name="Name" /></td>
	</tr>
	<tr>
	<td>Location</td>
	<td><input type="text" name="location" /></td>
	</tr>
	<tr>
	<td>Position</td>
	<td><input type="text" name="position" /></td>
	</tr>
	<tr>
	<td>Experience</td>
	<td><input type="text" name="experience" /></td>
	</tr>
	<tr>
	<td>Skills</td>
	<td><input type="text" name="skills" /></td>
	</tr>
	<tr>
	<td>Vacancies</td>
	<td><input type="text" name="vacancies" /></td>
	</tr>
	<tr>
	<td>Contact</td>
	<td><input type="text" name="contact" /></td>
	</tr>
	</table>
	<input type="submit" value="Submit" />
	</form>
	</div>
</body>
</html>