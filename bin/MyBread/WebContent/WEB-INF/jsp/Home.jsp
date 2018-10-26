<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>
	<jsp:include page="Header.jsp"/>
	<h2> Company Vision & Mission </h2>
	<p> Our goal is to provide easy access to bread for all consumers online.</p>
	<h2> Company business strategy </h2>
	<p> By providing online access to bread for all consumers, we reduce the cost of bringing bread to the consumer. </p>
	<h2> Products Offered </h2>
	<table>
		<tr>
			<td>White Bread*</td>
			<td><img src="${pageContext.request.contextPath}/images/whiteBread.jpg" 
				class="image"/></td>
		</tr>
		<tr>
			<td>Wheat Bread*</td>
			<td><img src="${pageContext.request.contextPath}/images/wheatBread.jpg" 
				class="image"/></td>
		</tr>
		<tr>
			<td>Raisin Bread*</td>
			<td><img src="${pageContext.request.contextPath}/images/raisinBread.jpg" 
				class="image"/></td>
		</tr>
		<tr>
			<td>Oat Bread*</td>
			<td><img src="${pageContext.request.contextPath}/images/oatBread.jpg" 
				class="image"/></td>
		</tr>
		<tr>
			<td>Honey Wheat Bread*</td>
			<td><img src="${pageContext.request.contextPath}/images/honeyWheatBread.jpg" 
				class="image"/></td>
		</tr>
	</table>		
	<p>*Images may or may not be completely misleading.</p>
	
	<jsp:include page="Footer.jsp"/>
</body>
</html>