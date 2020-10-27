<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register.css" type="text/css"/>
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
	<form:form action="${pageContext.request.contextPath}/${userType}/registered" cssClass="formCss" modelAttribute="${userType}" method="post">
		<h2>${userType} Register
		</h2>
		<h3>${message}</h3>
		<h3>${Idmessage} ${Id}</h3>
		<table>
			<tr>
				<td id="column">First Name</td>
				<td><form:input path="firstName" id="input" type="text"/><span><form:errors path="firstName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Last Name</td>
				<td><form:input path="lastName" id="input" type="text"/><span><form:errors path="lastName" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Age</td>
				<td><form:input path="age" id="input" type="number"/><span><form:errors path="age" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Gender</td>
				<td><form:select id="select" path="gender">
						<option value="M">M</option>
						<option value="F">F</option>
					</form:select><span><form:errors path="gender" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Contact Number</td>
				<td><form:input path="contactNumber" id="input" type="text"/><span><form:errors path="contactNumber" cssClass="errors"></form:errors></span></td>
			</tr>
			<tr>
				<td id="column">Password</td>
				<td><form:input path="password" id="input" type="password"/><span><form:errors path="password" cssClass="errors"></form:errors></span></td>
			</tr>
		</table>
		<input id="button" type="submit" value=Submit />
	</form:form>
</body>
</html>