<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<jsp:useBean id="date1" class="java.util.Date" />
<jsp:useBean id="date2" class="java.util.Date" />
<jsp:useBean id="date3" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<a href="get_approved_list">Approved</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="get_rejected_list">Rejected</a>
		<c:if test="${not empty leaves}">
			<table width="400" cellpadding="3" cellspacing="5" border="2">
				<tr>
					<th>Request ID</th>
					<th>Employee ID</th>
					<th>Leave Applied On</th>
					<th>From</th>
					<th>To</th>
					<th>Days</th>
					<th>Reason</th>
					<th>Leave Type</th>
					<th>Leave Status</th>
					<th>Approve / Reject</th>
				</tr>
				<c:forEach items="${leaves}" var="l">
					<jsp:setProperty name="date1" property="time"
						value="${l.todayDate}" />
					<jsp:setProperty name="date2" property="time" value="${l.fromDate}" />
					<jsp:setProperty name="date3" property="time" value="${l.toDate}" />
					<s:url value="edit" var="e">
						<s:param name="requestId" value="${l.requestId}"></s:param>
					</s:url>
					<tr>
						<td>${l.requestId}</td>
						<td>${l.employee.id}</td>
						<td><fmt:formatDate value="${date1}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${date2}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${date3}" pattern="dd-MM-yyyy" /></td>
						<td>${l.days}</td>
						<td>${l.reason}</td>
						<td>${l.leaveTypes}</td>
						<td>${l.leaveStatus}</td>
						<td><a href="${e}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty leaves}">
			<h2>No data found</h2>
		</c:if>
	</center>
</body>
</html>