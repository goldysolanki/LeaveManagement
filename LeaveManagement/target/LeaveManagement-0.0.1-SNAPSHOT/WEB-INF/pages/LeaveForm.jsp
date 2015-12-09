<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%!String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <style type="text/css">
.error {
	color: red;
}
</style> -->
</head>
<body>
	<p align="right">
		<a href="logout">Logout</a>
	</p>
	<center>
		Welcome ${emp.firstName}
		<h3>Apply for Leave</h3>
		<form:form action="save" method="post" modelAttribute="leaveRequest">
			<table width="400" cellpadding="5" cellspacing="3" border="0">
				<tr>
					<th>Employee ID</th>
					<td><form:input path="employee.id" value="${emp.id}"
							readonly="true" /></td>
				</tr>
				<tr>
					<th>Today Date</th>
					<td><form:input path="todayDate" value="<%=date%>"
							readonly="true" /></td>
				</tr>
				<tr>
					<th>From Date</th>
					<td><form:input path="fromDate" /></td>
					<%-- <td><form:errors path="fromDate" cssClass="error" /></td> --%>
				</tr>
				<tr>
					<th>To Date</th>
					<td><form:input path="toDate" /></td>
					<%-- <td><form:errors path="toDate" cssClass="error" /></td> --%>
				</tr>
				<tr>
					<th>Days</th>
					<td><form:input path="days" /></td>
					<%-- <td><form:errors path="days" cssClass="error" /></td> --%>
				</tr>
				<tr>
					<th>Reason</th>
					<td><form:textarea path="reason" /></td>
					<%-- <td><form:errors path="reason" cssClass="error" /></td> --%>
				</tr>
				<tr>
					<th>Leave Type</th>
					<td><form:select path="leaveTypes" multiple="false">
							<form:option value="0" label="Select" />
							<form:options items="${leaveTypes}" itemLabel="typeId"
								itemValue="typeValue" />
						</form:select></td>
					<%-- <td><form:errors path="leaveTypes" cssClass="error" /></td> --%>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>