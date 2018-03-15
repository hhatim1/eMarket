<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Register</legend>
		<p>${errors }</p>
		<form:form action="/register/user" method="POST" modelAttribute="user">
			<p><form:label path="first_name"/>First Name:
			<form:errors path="first_name"/>
			<form:input type="text" path="first_name"/></p>
			
			<p><form:label path="last_name"/>Last Name:
			<form:errors path="last_name"/>
			<form:input type="text" path="last_name"/></p>
			
			<p><form:label path="email"/>Email:
			<form:errors path="email"/>
			<form:input type="text" path="email"/></p>
			
			<p><form:label path="Birthday"/>Birthday:
			<form:errors path="Birthday"/>
			<form:input type="Date" path="Birthday"/></p>
			
			<p><form:label path="password"/>Password:
			<form:errors path="password"/>
			<form:input type="password" path="password"/></p>
			
			<p>Confirm Password:<input type="password" name = "c_password"></p>
			
			<input type="submit" value="Register">	
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>Login</legend>
		<form action="/login_user" method ="POST">
		<p>Email: <input type="text" name="email"></p>
		<p>Password: <input type ="password" name="password"></p>
		<input type = "submit" value = "Login">
		</form>
		
	</fieldset>
	
	

</body>
</html>