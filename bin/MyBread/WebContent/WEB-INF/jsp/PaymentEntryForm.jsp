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
<title>Payment Entry Form</title>
</head>
<body class="bodyCenterGrey">
<jsp:include page="Header.jsp"/>
<h1>Payment</h1>
<form:form modelAttribute="payment" method="post" action="submitPayment">
    <table>
    	<tr>
	   		<th>Credit Card Number</th>
	   		<td><form:input path="creditCardNumber" class="form-control" /></td>
	   	</tr>
	    <tr>
	   		<th>Expiration Date</th>
			<td><form:input path="expirationDate" class="form-control" /></td>
	   	</tr>
	   	<tr>
	   		<th>CVV Code</th>
	   		<td><form:input path="cvvCode" class="form-control" /></td>
		</tr>
	   	<tr>
	   		<th>Card Holder Name</th>
	   		<td><form:input path="cardHolderName" class="form-control" /></td>
	   	</tr>
    </table>
    <input type="submit" class="btn btn-outline-success"  value="Pay">
</form:form>
<jsp:include page="Footer.jsp"/>
</body>
</html>