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

<h2>Welcome to Sporty Shoes</h2><br></br>
Registered users List
<br/><br/>
<c:set var="sl" value="1"/>
<table class="table table-striped table-hover">
	<thead>
			<tr class="bg-success">
				<th>SL No.</th>
		        <th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>	
			</tr>
	</thead>
		<c:forEach items="${users}" var="user">  
		  <tr> 
		  	<td>${sl}</td> 
		    <td>${user.getUsername()}</td> 
		    <td>${user.getUserfirstname()}</td>
		    <td>${user.getUserlastname()}</td>
		    <td>${user.getEmail()}</td>
		    
		    <c:set  var="sl" value="${sl+1}"/>
		  </tr> 
		</c:forEach> 

</table><br><br>
<a href="dashboard">Dashboard</a>
</body>
</html>