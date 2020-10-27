<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pilot</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addPilot.css" type="text/css"/>
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
	<form:form cssClass="formCss"
		action="${pageContext.request.contextPath}/admin/pilot/added"
		method="post" modelAttribute="pilot">
		<h2>Adding Pilot</h2>
		<h3>${message}</h3>
		<table>
			<tr>
				<td id="column">First Name</td>
				<td><form:input path="firstName" id="input" type="text"/><span><form:errors
							path="firstName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Last Name</td>
				<td><form:input path="lastName" id="input" type="text"/><span><form:errors
							path="lastName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">High School Name</td>
				<td><form:input path="highSchoolName" id="input" type="text"/><span><form:errors
							path="highSchoolName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">University Name</td>
				<td><form:input path="universityName" id="input" type="text"/><span><form:errors
							path="universityName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Graduated year</td>
				<td><form:input path="graduatedYear" id="input" type="text"/><span><form:errors
							path="graduatedYear" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">GPA</td>
				<td><form:input path="gpa" id="input"/><span><form:errors
							path="gpa" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Experience</td>
				<td><form:input path="experience" id="input" type="number"/><span><form:errors
							path="experience" cssClass="errors"></form:errors></span></td>
			</tr>
		</table>
		<input id="button" type="submit" value="Submit" />
	</form:form>
</body>
</html>