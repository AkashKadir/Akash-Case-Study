<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/manager.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Poppins:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<nav>
<img id="headerImage" alt="Icon" src="${pageContext.request.contextPath}/resources/images/Airplane.png">
<h2>AIRPORT MANAGEMENT</h2>
<a href="${pageContext.request.contextPath}/manager/logout">LogOut</a>
</nav>
<div class="welcome">
	<h2>Hi Manager!</h2>
	<p>Has Manager you can do serveral operations. The operations are listed here!</p>
	<p>Contribute your work to our organisation by flying in your skills and growth</p>
</div>
<div id="adminOptions">
<h2>What you want to do as Manager?</h2>
<a href="${pageContext.request.contextPath}/manager/allotHangar">Allot Hanger</a><br>
<a href="${pageContext.request.contextPath}/manager/viewHangar">View Hanger</a><br>
</div>
</body>
</html>