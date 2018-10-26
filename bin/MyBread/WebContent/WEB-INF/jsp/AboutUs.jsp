<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
	<jsp:include page="Header.jsp"/>
	<h3>Our mission is to build the best online bread retailer!!</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Job Title</th>
			<th>Education and Experience </th>
		</tr>
		<tr>
			<td ><img src="${pageContext.request.contextPath}/images/tyler.jpg" 
				class="image"/><br /> Tyler Cai</td>
			<td>cai.471@osu.edu</td>
			<td>Cofounder, Software Developer</td>
			<td width= 450px>A fourth-year undergraduate student at The Ohio State University majoring in Computer Science and Engineering.</td>
		</tr>
		<tr>
			<td ><img src="${pageContext.request.contextPath}/images/wei.jpg" 
				class="image"/><br /> Wei Da</td>
			<td>da.11@osu.edu</td>
			<td>Cofounder, Software Developer</td>
			<td width= 450px>A second-year master student at The Ohio State University majoring in Computer Science and Engineering</td>
		</tr>
		<tr>
			<td><img src="${pageContext.request.contextPath}/images/zuanxu.jpg" 
				class="image"/><br /> Zuanxu Gong</td>
			<td>gong.366@osu.edu</td>
			<td>Cofounder, Software Developer</td>
			<td width= 450px>A second-year master student at The Ohio State University majoring in Computer Science and Engineering</td>
		</tr>
		
	</table>
	<jsp:include page="Footer.jsp"/>
</body>
</html>