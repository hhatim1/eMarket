<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fieldset>
		<legend>Logout</legend>
		<form action="/logout_user" method ="POST">
		<input type = "submit" value = "Logout">
		</form>		
	</fieldset>

	<fieldset>
		<legend>New Product</legend>
			<form:form method="POST" action="/products/create" modelAttribute="product">
			    <form:label path="name">Name:
			    <form:errors path="name"/>
			    <form:input path="name"/></form:label>
			    <p>
			    <form:label path="description">Description:
			    <form:errors path="description"/>
			    <form:input path="description"/></form:label>
			    <p>
			    <form:label path="price">Price:
			    <form:errors path="price"/>
			    <form:input type="float" path="price"/></form:label>			    
			    <p>
			    <input type="submit" value="Submit"/>
			</form:form>		
	</fieldset>
</body>
</html>
