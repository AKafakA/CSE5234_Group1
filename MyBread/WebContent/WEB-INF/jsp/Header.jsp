<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body class="bodyCenterGrey">
	<div class="row">
		<div class="col-sm-1"> </div>
		<div class="col-sm-2"> 
			<img src="${pageContext.request.contextPath}/images/logo.png" class="image"/> 
		</div>
		<div class="col-sm-6"> 
			<h1>MyBread</h1>
			<h3>One stop shop for all your bread needs...</h3>
				<br/>
				<a href="${pageContext.request.contextPath}/" class="stub">Home</a>
				<a href="${pageContext.request.contextPath}/purchase" class="stub">Purchase</a>
				<a href="${pageContext.request.contextPath}/AboutUs" class="stub">About Us</a>
				<a href="${pageContext.request.contextPath}/ContactUs" class="stub">Contact Us</a>
				<br/>
		</div>
	</div>
	<hr>
</body>
</html>