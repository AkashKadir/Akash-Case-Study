<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css"/>
<link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Trispace:wght@500&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/Airplane.png" type="image/png" sizes="16x16">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Poppins:wght@300&display=swap" rel="stylesheet">
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
<form:form cssClass="formCss"
		action="${pageContext.request.contextPath}/${userType}/logined" modelAttribute="${userType}"
		method="post">
		<h2>${userType} Login</h2>
		<h3>${message}</h3>
		<table>
			<tr>
				<td id="column">${userType} Id</td>
				<td><form:input id="input" path="id"/><span><form:errors path="id" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Password</td>
				<td><form:input id="input" path="password" type="password"/><span><form:errors path="password" cssClass="errors"></form:errors></span></td>
			</tr>
		</table>
		<br>
		<input id="button" type="submit" value="Submit"/>
	</form:form>
</body>
</html>