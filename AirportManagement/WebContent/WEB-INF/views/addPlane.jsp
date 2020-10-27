<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Planes</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addPlanes.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
</head>
<body>
<nav>
<img id="headerImage" alt="Icon" src="${pageContext.request.contextPath}/resources/images/Airplane.png">
<h2>AIRPORT MANAGEMENT</h2>
<a href="${pageContext.request.contextPath}/admin/logout">LogOut</a>
<a href="${pageContext.request.contextPath}/admin/hangar/add">Add Hangers</a>
<a href="${pageContext.request.contextPath}/admin/hangar/view">View Hangers</a>
<a href="${pageContext.request.contextPath}/admin/manager/viewManagers">View Managers</a>
<a href="${pageContext.request.contextPath}/admin/plane/add">Add Planes</a>
<a href="${pageContext.request.contextPath}/admin/plane/view">View Planes</a>
<a href="${pageContext.request.contextPath}/admin/pilot/add">Add Pilots</a>
<a href="${pageContext.request.contextPath}/admin/pilot/view">View Pilots</a>
</nav>
<form:form cssClass="formCss" action="${pageContext.request.contextPath}/admin/plane/added" modelAttribute="plane" method="post">
<h2>Adding Plane</h2>
<h3>${message}</h3>
	<table>
		<tr>
		<td id="column">Plane Name</td>
		<td><form:input path="planeName" id="input" type="text"/><span><form:errors path="planeName" cssClass="errors"></form:errors></span></td>
		</tr>
		<tr>
		<td id="column">From</td>
		<td><form:input path="fromPlace" id="input" type="text"/><span><form:errors path="fromPlace" cssClass="errors"></form:errors></span></td>
		</tr>
		<tr>
		<td id="column">To</td>
		<td><form:input path="toPlace" id="input" type="text"/><span><form:errors path="toPlace" cssClass="errors"></form:errors></span></td>
		</tr>
		<tr>
		<td id="column">Capacity</td>
		<td><form:input path="capacity" id="input" type="number"/><span><form:errors path="capacity" cssClass="errors"></form:errors></span></td>
		</tr>
	</table>
	<input id="button" type="submit" value="Submit"/>
</form:form>
</body>
</html>