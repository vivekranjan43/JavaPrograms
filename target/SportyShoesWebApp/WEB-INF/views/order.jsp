<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dto.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h2>Welcome to Sporty Shoes</h2>
<%User user=(User)request.getSession().getAttribute("user");%>
Welcome,${user.getUsername()}<br/><br/><br/>

Order details
<br/><br/>

<form action="saveorder?productid=${order.product.getProductid()}" method="post" >
	Product id: <input type="text" name="productid" value="${order.product.getProductid()}" disabled="disabled"/><br/>
	Product Name: <input type="text" value="${order.product.getName()}" name="name"/><br/>
	Brand: <input type="text" name="brand" value="${order.product.getBrand()}"/><br/>
	Size: <input type="text" name="size" value="${order.product.getSize()}"/><br/>
	Category: <input type="text" name="category" value="${order.product.getCategory()}"/><br/>
	Quantity: <input type="number" name="quantity" value=0 required/> <br/>
	<input type="submit" value="Save"/><br/>
</form>
<br/>
<br/>
<a href="dashboard">Dashboard</a>
</body>
</html>