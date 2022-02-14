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
<h3>User Signup Form:</h3>
<form action="registeruser" method="post">
User first Name: <input type="text" name="userfirstname"><br/>
User last Name: <input type="text" name="userlastname"><br/>
Email Id: <input type="text" name="email"><br/>
User Name: <input type="text" name="username"><br/>
Password:<input type="password" name="password"><br/>

<input type="submit" value="Sign up"><br/>
</form>
<a href="login">Back</a>
</body>
</html>