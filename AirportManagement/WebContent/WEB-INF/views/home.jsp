<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
</head>
<body>
<nav>
<img id="headerImage" alt="Icon" src="${pageContext.request.contextPath}/resources/images/Airplane.png">
<h2>AIRPORT MANAGEMENT</h2>
<a href="${pageContext.request.contextPath}/admin/login">ADMIN LOGIN</a>
<a href="${pageContext.request.contextPath}/admin/register">ADMIN REGISTER</a>
<a href="${pageContext.request.contextPath}/manager/login">MANAGER LOGIN</a>
<a href="${pageContext.request.contextPath}/manager/register">MANAGER REGISTER</a>
</nav>
<div id="para">
	<h2>Enjoy the Freedom</h2>
	<p>We are always ready to help you with any questions concerning our shuttle services.</p>
	<p>More than 17 thousand people are satisfied with our services all over the world.</p>
	<p>We have a wide fleet of reliable and licensed vehicles that provide safe airport transfer.</p>
	<button class="button">Read More</button>
</div>
</body>
</html>