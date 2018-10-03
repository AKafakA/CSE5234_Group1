<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shipping Entry Form</title>
</head>
<body class="bodyCenterGrey">
<jsp:include page="Header.jsp"/>
<h1>Shipping</h1>
<form:form modelAttribute="shipping" method="post" action="submitShipping">
    <table>
	   	<tr>
	   		<th>Name</th>
	   		<th>Address Line 1</th>
	   		<th>Address Line 2</th>
	   		<th>City</th>
	   		<th>State</th>
	   		<th>Zip</th>
	   	</tr>
		<tr>
			<td><form:input path="name" class="form-control" /></td>
			<td><form:input class="form-control" path="addressLine1" /></td>
			<td><form:input class="form-control" path="addressLine2" /></td>
			<td><form:input class="form-control" path="city" /></td>
			<td><form:input class="form-control" path="state" /></td>
			<td><form:input class="form-control" path="zip" /></td>
		</tr>
    </table>
    <input type="submit" class="btn btn-outline-success" value="Ship">
</form:form>
<jsp:include page="Footer.jsp"/>
</body>
</html>