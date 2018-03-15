<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> <!-- Must ADD -->
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
		<legend>Shoes available in the store now:</legend>
		<table>
			<thead>
                 <tr>
                     <th>Shoes in Display</th>
                     <th>Price in $US Dollars</th>
                     <th>Color &  Size</th>
               
                 </tr>
              </thead> 
			<c:forEach items="${allProducts}" var="product">
		    <tbody>
			    <tr>   
			        <td><a href="/product/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a>
			        <td><a href="/product/<c:out value="${product.id}"/>"><c:out value="${product.price}"/></a> 
			        <td><a href="/product/<c:out value="${product.id}"/>"><c:out value="${product.description}"/></a> 	
			        <td><a href="/product/delete/<c:out value="${product.id}"/>"><c:out value="${id}"/>Buy</a></td>    		    		   		
	       		 </tr>
		    </tbody>
			</c:forEach>		
		</table>
		  <h3>Click below to add stuff to your shopping cart</h3>
	   				
				<td>
			    		<c:forEach items="${allCategories}" var="category">    
			    		<td><a href="/category/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a></td>
					</c:forEach>	
		    		</td>	 
	
	</fieldset>
	
	<fieldset>
		<legend>Store Management Stuff: Remove From Store Option:</legend>
		<table>
			<c:forEach items="${allProducts}" var="product">
		    <tr>    
		    		<td><a href="/product/<c:out value="${product.id}"/>"><c:out value="${product.name}"/></a></td>
		    		<td><a href="/product/delete/<c:out value="${product.id}"/>"><c:out value="${id}"/>Remove</a></td>
		    		<!-- <td><a href="/product/buy/<c:out value="${product.id}"/>"><c:out value="${id}"/>Buy</a></td>  -->
		    		
		    		<!-- <td><a href="/product/delete/<c:out value="${product.id}"/>"><c:out value="${product.name}"/>Delete</a></td> -->
		    		<!-- <a href="/category/< value="{category.id}"/>">< value="${category.name}"/></a></td> -->
		    </tr>
			</c:forEach>		
			
				
		</table>
	</fieldset>
	<fieldset><legend>Store Management Stuff: Add new shoes and other foot wear options to the store</legend>
	<p><a href="/products/new">Add Shoes to The Store</a>To add new Shoe Selections</p>
		
	<p><a href="/category/new">Add new foot-wear line</a>To add new foot-wear line</p>

	</fieldset>
	
	
</body>
</html>