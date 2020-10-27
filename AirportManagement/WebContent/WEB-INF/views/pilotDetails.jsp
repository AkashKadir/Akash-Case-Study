<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pilot Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pilotDetails.css" type="text/css"/>
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
<h3>The Particular pilot details are:</h3>
<table border="1">
	<tr>
	<td id="column">Pilot Id</td>
	<td>${pilotDetail.pilotId}</td>
	</tr>
	<tr>
	<td id="column">Experience</td>
	<td>${pilotDetail.experience}</td>
	</tr>
	<tr>
	<td id="column">First Name</td>
	<td>${pilotDetail.firstName}</td>
	</tr>
	<tr>
	<td id="column">GPA</td>
	<td>${pilotDetail.gpa}</td>
	</tr>
	<tr>
	<td id="column">Graduated Year</td>
	<td>${pilotDetail.graduatedYear}</td>
	</tr>
	<tr>
	<td id="column">HighSchool Name</td>
	<td>${pilotDetail.highSchoolName}</td>
	</tr>
	<tr>
	<td id="column">Last Name</td>
	<td>${pilotDetail.lastName}</td>
	</tr>
	<tr>
	<td id="column">University Name</td>
	<td>${pilotDetail.universityName}</td>
	</tr>
</table>
<form action="${pageContext.request.contextPath}/admin/pilot/addedUpdate?pilotId=${pilotDetail.pilotId}&experience=${pilotDetail.experience}&firstName=${pilotDetail.firstName}&gpa=${pilotDetail.gpa}&graduatedYear=${pilotDetail.graduatedYear}&highSchoolName=${pilotDetail.highSchoolName}&lastName=${pilotDetail.lastName}&universityName=${pilotDetail.universityName}" method="post">
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