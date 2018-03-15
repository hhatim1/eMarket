<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> <!-- Must ADD --> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- Need to include for the form -->
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
			<legend>Product: <c:out value="${thisProduct.name}"/></legend>
				<c:forEach items="${thisCategory.products}" var="product">
					<li><c:out value="${product.name}"/></li>
					<li><c:out value="${product.price}"/></li>
					<li><c:out value="${product.description}"/></li>	
				</c:forEach>
			</fieldset> 
	
</body>
</html>