<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h2>Welcome to Sporty Shoes</h2>


<div><a  href="addproduct"> Add new product </a><br/></div><br/>
<div><a  href="orders"> Order Summary </a><br/></div><br/>
<div>
<form action="" method="get" >
	Product Name: <input type="text" value="${product.getName()}" name="name"/><br/>
	<input type="submit" value="Search"/><br/><br/>
</form>
<form action="" method="get" >
	Category: <input type="text" name="category" value="${product.getCategory()}"/><br/>
	<input type="submit" value="Search"/><br/><br/>
</form>
</div><br/><br/>
Product Lists
<br/>
<c:set var="sl" value="1"/>
<table class="table table-striped table-hover">
	<thead>
			<tr class="bg-success">
				<th>SL No.</th>
		        <th>Product Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Size</th>
				<th>Category</th>
				<th>Available Quantity</th>
				<th></th>
			</tr>
	</thead>
		<c:forEach items="${products}" var="product">  
		  <tr> 
		  	<td>${sl}</td> 
		    <td>${product.getProductid()}</td> 
		    <td>${product.getName()}</td>
		    <td>${product.getBrand()}</td>
		    <td>${product.getSize()}</td>
		    <td>${product.getCategory()}</td>
		    <td>${product.getAvailablequantity()}</td>
		    <td><a href="update?productid=${product.getProductid()}">edit</a> <a href="delete?productid=${product.getProductid()}">delete</a> </td>
		    <c:set  var="sl" value="${sl+1}"/>
		  </tr> 
		</c:forEach> 

</table>
</div>
<a href="back">Dashboard</a>
</body>
</html>