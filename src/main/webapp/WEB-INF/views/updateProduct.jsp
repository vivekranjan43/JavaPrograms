<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h2>Welcome to Sporty Shoes</h2><br>

<form action="update?productid=${product.getProductid()}" method="post" >
	Product id: <input type="text" name="productid" value="${product.getProductid()}" disabled="disabled"/><br/>
	Product Name: <input type="text" value="${product.getName()}" name="name"/><br/>
	Brand: <input type="text" name="brand" value="${product.getBrand()}"/><br/>
	Size: <input type="text" name="size" value="${product.getSize()}"/><br/>
	Category: <input type="text" name="category" value="${product.getCategory()}"/><br/>
	Available Quantity: <input type="number" name="availablequantity" value="${product.getAvailablequantity()}"/> <br/>
	<input type="submit" value="Update"/><br/>
</form>
<br/>
<br/>

</body>
</html>