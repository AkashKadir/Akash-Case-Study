<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
</head>
<body>
<nav>
<img id="headerImage" alt="Icon" src="${pageContext.request.contextPath}/resources/images/Airplane.png">
<h2>AIRPORT MANAGEMENT</h2>
<a href="${pageContext.request.contextPath}/admin/logout">LogOut</a><br>
</nav>
<div class="welcome">
	<h2>Hi Admin!</h2>
	<p>Has Admin you can do serveral operations. The operations are listed here!</p>
	<p>Contribute your work to our organisation by flying in your skills and growth</p>
</div>
<div id="adminOptions">
<h2>What you want to do as Admin?</h2>
<a href="${pageContext.request.contextPath}/admin/hangar/add">Add Hangers</a><br>
<a href="${pageContext.request.contextPath}/admin/hangar/view">View Hangers</a><br>
<a href="${pageContext.request.contextPath}/admin/manager/viewManagers">View Managers</a><br>
<a href="${pageContext.request.contextPath}/admin/plane/add">Add Planes</a><br>
<a href="${pageContext.request.contextPath}/admin/plane/view">View Planes</a><br>
<a href="${pageContext.request.contextPath}/admin/pilot/add">Add Pilots</a><br>
<a href="${pageContext.request.contextPath}/admin/pilot/view">View Pilots</a><br>
</div>
</body>
</html>