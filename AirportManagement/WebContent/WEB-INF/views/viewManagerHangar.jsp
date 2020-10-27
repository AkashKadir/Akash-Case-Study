<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Hangars</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/viewManagerHangar.css" type="text/css"/>
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
<div id="view">
	<table border="1">
	<tr>
	<th>Hangar Id</th>
	<th>Height</th>
	<th>Length</th>
	<th>Width</th>
	<th>Status</th>
	<th>Plane Id - Name</th>
	</tr>
		<c:forEach items="${listOfViewHangars}" var="hangarsList">
			<tr><%-- 
			<c:set value="${hangarsList.status}" var="status"/>
				<c:if test="${status == 0 }">
					<c:set value="${Available}" var="status"/>
				</c:if>
				<c:if test="${status>0 }">
					<c:set value="${Alloted}" var="status"/>
				</c:if> --%>
			<td>${hangarsList.hangarId}</td>
			<td>${hangarsList.height}</td> 
			<td>${hangarsList.length}</td>
			<td>${hangarsList.width}</td>
			<%-- <td><c:out value = "${status}"/></td> --%>
			<td>${hangarsList.status}</td>
			<td>${hangarsList.plane.planeId} - ${hangarsList.plane.planeName}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Status - 1  *Alloted</p>
	<p>Status - 0  *Available</p>
</div>
<div id="adminOptions">
<h2>What you want to do as Manager?</h2>
<a href="${pageContext.request.contextPath}/manager/allotHangar">Allot Hanger</a><br>
<a href="${pageContext.request.contextPath}/manager/viewHangar">View Hanger</a><br>
</div>
</body>
</html>