<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hangar</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addHangar.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Poppins:wght@300&display=swap" rel="stylesheet">
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
		action="${pageContext.request.contextPath}/admin/hangar/updateHangar?id=${updateHangar.hangarId}"
		method="post" modelAttribute="hangar">
		<h2>Update Hangar</h2>
		<h3>${message}</h3>
		<table>
			<tr>
				<td id="column">Length</td>
				<td><form:input path="length" id="input" type="number" value="${updateHangar.length}"/><span><form:errors
							path="length" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Width</td>
				<td><form:input path="width" id="input" type="number" value="${updateHangar.width}"/><span><form:errors
							path="width" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Height</td>
				<td><form:input path="height" id="input" type="number" value="${updateHangar.height}"/><span><form:errors
							path="height" cssClass="errors"></form:errors></span></td>
			</tr>
		</table>
		<input id="button" type="submit" value="Submit" />
	</form:form>
</body>
</html>