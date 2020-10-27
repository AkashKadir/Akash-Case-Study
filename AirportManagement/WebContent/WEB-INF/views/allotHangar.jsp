<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allot Hangar</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allotHangar.css" type="text/css"/>
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
	<form id="formCss"
		action="${pageContext.request.contextPath}/manager/allotPlaneWithHangar"
		method="post">
		<h2>Allot hangar</h2>
		<h3>${message}</h3>
		<table>
		<tr>
		<td id="column">Hangar List</td>
		<td><select id="select" name="hangar">
			<c:forEach items="${hangars}" var="hangar">
				<option value="${hangar.hangarId}">${hangar.hangarId}</option>
			</c:forEach>
		</select></td>
		</tr>
		<tr>
		<td id="column">Plane List</td>
		<td><select id="select" name="plane">
			<c:forEach items="${planes}" var="plane">
				<option value="${plane.planeId}">${plane.planeId} - ${plane.planeName}</option>
			</c:forEach>
		</select></td>
		</tr>
		</table>		
		<input id="button" type="submit" value="Submit"/>
	</form>
<div id="adminOptions">
<h2>What you want to do as Manager?</h2>
<a href="${pageContext.request.contextPath}/manager/allotHangar">Allot Hanger</a><br>
<a href="${pageContext.request.contextPath}/manager/viewHangar">View Hanger</a><br>
</div>
</body>
</html>