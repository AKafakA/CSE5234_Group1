<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Entry Form</title>
</head>
<body>
<h1>Order Entry Form</h1>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">

    <table width="350" border="solid 1px black">
    	<tr>
    		<th>Name</th>
    		<th>Price</th>
    		<th>Quantity</th>
    	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td>
				<c:out value="${item.name}"></c:out>
			    <form:input type="hidden" path="items[${loop.index}].name"/>
		    </td>
			<td>
				<c:out value="$${item.price}"></c:out>
			    <form:input type="hidden" path="items[${loop.index}].price"/>
			</td>
			<td><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="2"><input type="submit" value="Purchase"></td>
	  </tr>
    </table>
</form:form>

</body>
</html>