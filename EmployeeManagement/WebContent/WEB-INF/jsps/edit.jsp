<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
.errorblock {
	color: red;
}
</style>
<body>
	<center>
		<h3>Edit Employee Details</h3>
		<form:form action="update" method="post" modelAttribute="employee">
			<table width="500" cellpadding="3" cellspacing="3" border="0">
				<tr>
					<th>Employee ID</th>
					<td><form:input path="empId" readonly="true" /></td>
				</tr>
				<tr>
					<th>Employee Name</th>
					<td><form:input path="empName" /></td>
					<td><form:errors path="empName" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>Age</th>
					<td><form:input path="age" /></td>
					<td><form:errors path="age" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><form:input path="phone" /></td>
					<td><form:errors path="phone" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<!-- <th>Address ID</th> -->
					<td><form:hidden path="address.addressId" /></td>
					<td><form:errors path="address.addressId"
							cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>Street</th>
					<td><form:input path="address.street" /></td>
					<td><form:errors path="address.street" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>Location</th>
					<td><form:input path="address.location" /></td>
					<td><form:errors path="address.location" cssClass="errorblock" /></td>
				</tr>
				<tr>
					<th>City</th>
					<td><form:input path="address.city" /></td>
					<td><form:errors path="address.city" cssClass="errorblock" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form:form>
	</center>
</body>
</html>