<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment Entry Form</title>
</head>
<body>
<h1>Payment Entry Form</h1>
<form:form modelAttribute="payment" method="post" action="submitPayment">
    <table width="600" border="solid 1px black">
	   	<tr>
	   		<th>Credit Card Number</th>
	   		<th>Expiration Date</th>
	   		<th>CVV Code</th>
	   		<th>Card Holder Name</th>
	   	</tr>
		<tr>
			<td><form:input path="creditCardNumber" /></td>
			<td><form:input path="expirationDate" /></td>
			<td><form:input path="cvvCode" /></td>
			<td><form:input path="cardHolderName" /></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="Pay"></td>
		</tr>
    </table>
</form:form>

</body>
</html>