<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Entry Form</title>
</head>
<body>
<h1>Shipping Entry Form</h1>
<form:form modelAttribute="shipping" method="post" action="submitShipping">
    <table width="600" border="solid 1px black">
	   	<tr>
	   		<th>Name</th>
	   		<th>Address Line 1</th>
	   		<th>Address Line 2</th>
	   		<th>City</th>
	   		<th>State</th>
	   		<th>Zip</th>
	   	</tr>
		<tr>
			<td><form:input path="name" /></td>
			<td><form:input path="addressLine1" /></td>
			<td><form:input path="addressLine2" /></td>
			<td><form:input path="city" /></td>
			<td><form:input path="state" /></td>
			<td><form:input path="zip" /></td>
		</tr>
		<tr>
			<td colspan="6"><input type="submit" value="Ship"></td>
		</tr>
    </table>
</form:form>

</body>
</html>