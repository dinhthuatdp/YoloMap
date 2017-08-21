<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>SignUp</h1>
	<form:form id="signUpForm" method="post" action="${pageContext.request.contextPath}/signup.html" modelAttribute="loginBean">

		<c:if test="${not empty errorMessage}">
			<h3 style='color:red'><%=request.getAttribute("errorMessage") %></h3>
		</c:if>
		<form:label path="user_name">Enter your user-name</form:label>
		<form:input id="username" name="username" path="user_name" /><br>
		<form:label path="user_name">Please enter your password</form:label>
		<form:password id="password" name="password" path="password" /><br>
		<input type="submit" value="Sign Up" />
	</form:form>
</body>
</html>