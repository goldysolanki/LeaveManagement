<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>${message}</center>

	<p align="right">
		<a href="get_list">List</a>
	</p>
	<%-- <c:if test="${not empty employees}">
		<c:forEach items="${employees}" var="e">
			<table>
				<tr>
					<td>${e.id}</td>
				</tr>
			</table>

		</c:forEach>
	</c:if>
	<c:if test="${empty employees}">
		<h2>No Data Found</h2>
	</c:if> --%>
</body>
</html>