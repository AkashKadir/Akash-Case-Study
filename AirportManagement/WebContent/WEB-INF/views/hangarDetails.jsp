<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hangar Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/details.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Poppins:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<nav>
<img id="headerImage" alt="Icon" src="${pageContext.request.contextPath}/resources/images/Airplane.png">
<h2>AIRPORT MANAGEMENT</h2>
<a href="${pageContext.request.contextPath}/admin/logout">LogOut</a><br>
</nav>
<div id="view">
<h3>Selected Hangar Details:</h3>
<table border="1">
	<tr>
	<td id="column">Hangar Id</td>
	<td>${hangarDetails.hangarId}</td>
	</tr>
	<tr>
	<td id="column">Hangar Length</td>
	<td>${hangarDetails.length}</td>
	</tr>
	<tr>
	<td id="column">Hangar Width</td>
	<td>${hangarDetails.width}</td>
	</tr>
	<tr>
	<td id="column">Hangar Height</td>
	<td>${hangarDetails.height}</td>
	</tr>
</table>
<form action="${pageContext.request.contextPath}/admin/hangar/addedUpdate?hangarId=${hangarDetails.hangarId}&length=${hangarDetails.length}&width=${hangarDetails.width}&height=${hangarDetails.height}" method="post">
<input id="button" type="submit" value="Update Details"/>
</form>
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