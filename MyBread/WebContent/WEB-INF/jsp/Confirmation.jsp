<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	<h1>Confirmation</h1>
	<p>
		Your order has been submitted. Your confirmation number is ${confirmation}.
	</p>
	<h2>Order</h2>
	<table width="350" border="solid 1px black">
    	<tr>
    		<th>Name</th>
    		<th>Price</th>
    		<th>Quantity</th>
    	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.name}"></c:out></td>
			<td><c:out value="$${item.price}"></c:out></td>
			<td><c:out value="${item.quantity}" /></td>
		</tr>
	</c:forEach>
	</table>
	<h2>Payment Information</h2>
	<table width="600" border="solid 1px black">
		<tr>
			<th>Credit Card Number</th>
			<th>Expiration Date</th>
			<th>CVV Code</th>
			<th>Card Holder Name</th>
		</tr>
		<tr>
			<td><c:out value="${payment.creditCardNumber}"></c:out></td>
			<td><c:out value="${payment.expirationDate}"></c:out></td>
			<td><c:out value="${payment.cvvCode}"></c:out></td>
			<td><c:out value="${payment.cardHolderName}"></c:out></td>
		</tr>
	</table>
	<h2>Shipping Information</h2>
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
			<td><c:out value="${shipping.name}"></c:out></td>
			<td><c:out value="${shipping.addressLine1}"></c:out></td>
			<td><c:out value="${shipping.addressLine2}"></c:out></td>
			<td><c:out value="${shipping.city}"></c:out></td>
			<td><c:out value="${shipping.state}"></c:out></td>
			<td><c:out value="${shipping.zip}"></c:out></td>
		</tr>
	</table>
</body>
</html>