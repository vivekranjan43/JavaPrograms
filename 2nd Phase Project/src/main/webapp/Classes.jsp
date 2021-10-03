<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.dto.Class1"%>
 <%@ include file = "Header.jsp"%>

  
 <% ArrayList classlist = (ArrayList)request.getAttribute("classlist");
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>

<div class="container col-md-1" style="overflow: auto;display: inline-block;">
</div>

<div class="container col-md-6" style="overflow: auto;display: inline-block;">
<h3>Available Class Details:</h3>
<table >
<tr>
<th class="col-md-6">Class name</th>
<th class="container col-md-6">Description</th>
<th></th>
</tr>
<%for(int i=0; i<classlist.size();i++){ %>

<% Class1 class1 =(Class1)classlist.get(i); %>
<tr class='clickable-row'>
	<td>
	<%out.print(class1.getClassName()); %>
	</td>
	<td>
	<%	out.print(class1.getDescription()); %>
	</td>
	<td><form action="<%=request.getContextPath()%>/listclasses" method="post">
	<input style="display:none;" type="text" name="classId"  value="<%out.print(class1.getId());%>">
	<button type="submit" class="btn" name="deleteClass" value="deleteClass"><i class="fa fa-trash"></i></button>
	</form>
	</td>
	
</tr>

<% } %>


</table>

</div>

<div class="container col-md-3" style="overflow: auto;display: inline-block; position: absolute">
  <h3>Add New Class</h3>
  <form action="<%=request.getContextPath()%>/listclasses" method="post">
   <div class="form-group">
    <label for="name">Class Name: </label> <input type="text"
     class="form-control" id="name" placeholder="Class Name"
     name="name" required>
   </div>
   <div class="form-group">
    <label for="name">Description: </label> <input type="text"
     class="form-control" id="discription" placeholder="Description"
     name="discription">
   </div>
   <button type="submit" class="btn btn-primary" name="addClass" value="addClass">Add</button>
  </form>
  
 </div>
 


</body>

</html>