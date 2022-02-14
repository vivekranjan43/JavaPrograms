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
<h3>Admin password update:</h3>
${responsemsg}
<form action="updatepassword" method="post">
Insert New Password:<input type="password" name="newPassword" required><br/>
Insert Confirm New Password:<input type="password" name="confirmNewPassword" required><br/>
<input type="submit" value="Update Password">

<br/><br/>

<br><br>
<a href="dashboard">Dashboard</a>

</form>
</body>
</html>