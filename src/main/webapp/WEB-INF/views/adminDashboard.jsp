<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
<h2>Welcome to Sporty Shoes</h2>
Hello Admin-,<%=request.getSession().getAttribute("adminUserName")%><br/><br/><br/>
<a href="userslist">List Registered Users</a><br/>
<a href="updatepassword">Update Password</a><br/>
<a href="..\productmanager\all">Manage Products</a><br/>
<a href="logout">Logout</a><br/>
</body>
</html>