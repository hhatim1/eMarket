<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> <!-- Must ADD --> 
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
			<legend>  Your <c:out value="${thisCategory.name}"/></legend>
	        <table>	     
	          <tbody>	    		
					<c:forEach items="${thisCategory.products}" var="product">
				<tr>
						<td><c:out value="${product.name}"/></td>
				
				
						<td><c:out value="${product.price}"/></td>
				
				
						<td><c:out value="${product.description}"/></td>	
						
						<td><a href="/product/buy/<c:out value="${product.id}"/>"><c:out value="${name.id}"/>Pay Here</a></td>    		    		   				
					</c:forEach>		
				</tr>	
				
				
		    
			
				
				
				
			 </tbody>
		</table>
		       
		</fieldset>
		
		
		
		<!--         -----          -->
		
		<fieldset>
		   <legend>Add to your shopping cart</legend>
		     <form method="POST" action="/category/${thisCategory.id}/add_product">
		     <select name="product_id">
		     	
		     <c:forEach items="${filteredProducts}" var="categories">
		     	<option value="${categories.id}">${categories.name}</option>
		     </c:forEach>
		     </select>
		     
		    <input type="submit" value="Submit"/>
		    </form>
		</fieldset>
	
</body>
</html>