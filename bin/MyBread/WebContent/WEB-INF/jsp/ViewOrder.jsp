<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Order</title>
</head>
<body class="bodyCenterGrey">
	<jsp:include page="Header.jsp"/>
	<h1>View Order</h1>

	<h2>Order</h2>
	<table width="400" border="solid 1px black">
    	<tr>
    		<th>Name</th>
    		<th>Price</th>
    		<th>Quantity</th>
    	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.name}"></c:out></td>
			<td><c:out value="$${item.price}"></c:out></td>
			<td><c:choose>
			    <c:when test="${item.quantity != ''}">
			        <c:out value= "${item.quantity}"/>
			        <br />
			    </c:when>    
			    <c:otherwise>
			        <c:out value = '0' />
			        <br />
			    </c:otherwise>
			</c:choose></td>
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
			<td><c:out value="${shipping.name}"></c:out></td>
			<td><c:out value="${shipping.addressLine1}"></c:out></td>
			<td><c:out value="${shipping.addressLine2}"></c:out></td>
			<td><c:out value="${shipping.city}"></c:out></td>
			<td><c:out value="${shipping.state}"></c:out></td>
			<td><c:out value="${shipping.zip}"></c:out></td>
		</tr>
	</table>
	<form:form method="post" action="confirmOrder">
		<%-- <c:forEach items="${order.items}" var="item" varStatus="loop">
			<form:input type="hidden" path="order.items[${loop.index}].name"/>
			<form:input type="hidden" path="order.items[${loop.index}].price"/>
			<form:input type="hidden" path="order.items[${loop.index}].quantity"/>
		</c:forEach>
		
		<form:input type="hidden" path="shipping.name" />
		<form:input type="hidden" path="shipping.addressLine1" />
		<form:input type="hidden" path="shipping.addressLine2" />
		<form:input type="hidden" path="shipping.city" />
		<form:input type="hidden" path="shipping.state" />
		<form:input type="hidden" path="shipping.zip" />
		
		<form:input type="hidden" path="payment.creditCardNumber" />
		<form:input type="hidden" path="payment.expirationDate" />
		<form:input type="hidden" path="payment.cvvCode" />
		<form:input type="hidden" path="payment.cardHolderName" /> --%>
		
		<input type="submit" class="btn btn-outline-success" value="Confirm" />
	</form:form>
	<jsp:include page="Footer.jsp"/>
</body>
</html>