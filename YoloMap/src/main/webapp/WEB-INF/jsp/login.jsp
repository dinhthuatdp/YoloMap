<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<!--
<body>
	<div id="mainLogin">
		<c:url var="loginUrl" value="/login.html" />
		<form action="${loginUrl}" method="post">
			<input type="text" id="username" name="ssoId"
				   placeholder="Enter Username" required> <br> 
			<input type="password" id="password" name="password"
				   placeholder="Enter Password" required>
			<div>
				<input type="submit" value="Log in">
			</div>
		</form>
	</div>
</body>
-->
	<body>
		<h1>Login</h1>
		<form:form id="loginForm" method="post" action="${pageContext.request.contextPath}/login.html" modelAttribute="loginBean">

			<c:if test="${not empty errorMessage}">
				<h3 style='color:red'><%=request.getAttribute("errorMessage") %></h3>
			</c:if>
			<form:label path="user_name">Enter your user-name</form:label>
			<form:input id="username" name="username" path="user_name" /><br>
			<form:label path="user_name">Please enter your password</form:label>
			<form:password id="password" name="password" path="password" /><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>