<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<center>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<h1>Login Page</h1>
		<br>
		<form:form action="checkLogin" method="post" modelAttribute="user">
			<table width="300" cellpadding="3" cellspacing="3" border="0">
				<tr>
					<th>User ID</th>
					<td><form:input path="userId" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>