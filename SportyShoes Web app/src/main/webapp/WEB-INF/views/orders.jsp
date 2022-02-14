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
<h3>Purchase Report</h3>
<br/><br/>

<c:set var="sl" value="1"/>
<table class="table table-striped table-hover">
	<thead>
			<tr class="bg-success">
				<th>SL No.</th>
		        <th>Order Id</th>
				<th>Product ID</th>
				<th>Ordered Quantity</th>				
				<th>Order Date</th>				
				<th>Status</th>
				<th></th>
			</tr>
	</thead>
		<c:forEach items="${orders}" var="Order">  
		  <tr> 
		  	<td>${sl}</td> 
		    <td>${Order.getOrderid()}</td> 
		    <td>${Order.getProductid()}</td>
		    <td>${Order.getQuantity()}</td>
		    <td>${Order.getOrderDate()}</td>		
		    <td>${Order.getStatus()}</td>
		    <td> </td>
		    <c:set  var="sl" value="${sl+1}"/>
		  </tr> 
		</c:forEach> 

</table>
<a href="back">Dashboard</a>
</body>
</html>