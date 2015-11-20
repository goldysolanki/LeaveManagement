<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p align="right">
		<a href="logout">Logout</a>
	</p>
	<br>
	<br>
	<center>
		Welcome ${userId}<br> <br>
		<form:form modelAttribute="employee">
			<table width="500" cellpadding="3" cellspacing="3" border="0">
				<tr>
					<th>Employee ID</th>
					<td>${employee.empId}</td>
				</tr>
				<tr>
					<th>Employee Name</th>
					<td>${employee.empName}</td>
				</tr>
				<tr>
					<th>Age</th>
					<td>${employee.age}</td>
				</tr>
				<tr>
					<th>Email ID</th>
					<td>${employee.email}</td>
				</tr>
				<tr>
					<th>Phone No</th>
					<td>${employee.phone}</td>
				</tr>
				<tr>
					<th>Street</th>
					<td>${employee.address.street}</td>
				</tr>
				<tr>
					<th>Location</th>
					<td>${employee.address.location}</td>
				</tr>
				<tr>
					<th>City</th>
					<td>${employee.address.city}</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>