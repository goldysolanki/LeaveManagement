<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
		Welcome ${userId}<br> <br> <a href="show">New Employee</a>
		<c:if test="${not empty empsList}">
			<table width="500" cellpadding="3" cellspacing="3" border="0">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Age</th>
					<th>Email ID</th>
					<th>Phone No</th>
					<th>Street</th>
					<th>Location</th>
					<th>City</th>
					<th>Operation</th>
				</tr>
				<c:forEach items="${empsList}" var="e">
					<s:url value="edit/${e.empId}" var="eu">
					</s:url>
					<s:url value="delete" var="ed">
						<s:param name="empId" value="${e.empId}"></s:param>
					</s:url>
					<tr>
						<td>${e.empId}</td>
						<td>${e.empName}</td>
						<td>${e.age}</td>
						<td>${e.email}</td>
						<td>${e.phone}</td>
						<td>${e.address.street}</td>
						<td>${e.address.location}</td>
						<td>${e.address.city}</td>
						<td><a href="${eu}" title="Edit">Edit</a>&nbsp;&nbsp;<a
							href="${ed}" title="Delete">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty empsList}">
			<h2>No data found</h2>
		</c:if>
	</center>
</body>
</html>