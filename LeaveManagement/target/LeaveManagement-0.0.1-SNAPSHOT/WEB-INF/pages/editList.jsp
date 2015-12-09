<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>Edit Leave</h3>
		<form:form action="update" method="post" modelAttribute="updateLeave">
			<table width="400" cellpadding="5" cellspacing="3" border="3">
				<tr>
					<th>Request ID</th>
					<td><form:input path="requestId" readonly="true" /></td>
				</tr>
				<tr>
					<th>Employee ID</th>
					<td><form:input path="employee.id" readonly="true" /></td>
				</tr>
				<tr>
					<th>Leave Applied On</th>
					<td><form:input path="todayDate" /></td>
				</tr>
				<tr>
					<th>From</th>
					<td><form:input path="fromDate" /></td>
				</tr>
				<tr>
					<th>To</th>
					<td><form:input path="toDate" /></td>
				</tr>
				<tr>
					<th>Days</th>
					<td><form:input path="days" /></td>
				</tr>
				<tr>
					<th>Reason</th>
					<td><form:textarea path="reason" /></td>
				</tr>
				<tr>
					<th>Leave Type</th>
					<td><form:input path="leaveTypes" /></td>
				</tr>
				<tr>
					<th>Leave Status</th>
					<td><form:select path="leaveStatus" multiple="false">
							<form:option value="0" label="Select" />
							<form:options items="${leaveStatus}" />
						</form:select></td>
				<tr>
					<th></th>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>