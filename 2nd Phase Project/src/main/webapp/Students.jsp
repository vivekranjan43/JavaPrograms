<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.dto.Student"%>
 <%@page import="com.dto.Class1"%>
 <%@ include file = "Header.jsp"%>

  
 <% ArrayList list = (ArrayList<Student>)request.getAttribute("studentlist");
 ArrayList class1list = (ArrayList)request.getAttribute("classlist");
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>

<div class="container col-md-1" style="overflow: auto;display: inline-block;">
</div>

<div class="container col-md-6" style="overflow: auto;display: inline-block;">
<h3>Student Details:</h3>
<table>
<tr>
<th class="col-md-6">First name</th>
<th class="col-md-6">Last name</th>
<th class="container col-md-6">Description</th>
</tr>
<%for(int i=0; i<list.size();i++){%>
<% Student student =(Student)list.get(i); %>
<tr>
	<td >	
	<%	out.print(student.getStudentFirstName()); %>
	</td>
	<td >	
	<%	out.print(student.getStudentLastName()); %>
	</td>
	<td>
	<%	out.print(student.getClass1().getClassName()); %>
	</td>
	<td><form action="<%=request.getContextPath()%>/liststudents" method="post">
	<input style="display:none;" type="text" name="stId"  value="<%out.print(student.getId());%>">
	<button type="submit" class="btn" name="deleteStudent" value="deleteStudent"><i class="fa fa-trash"></i></button>
	</form>
	</td>
</tr>

<%}%>


</table>

</div>

<div class="container col-md-3" style="overflow: auto;display: inline-block; position: absolute">
  <h3>Add New Student</h3>
  <form action="<%=request.getContextPath()%>/liststudents" method="post">
   <div class="form-group">
    <label for="name">First Name: </label> <input type="text"
     class="form-control" id="fname" placeholder="First Name"
     name="fname" required>
   </div>
   <div class="form-group">
    <label for="name">Last Name: </label> <input type="text"
     class="form-control" id="lname" placeholder="Last Name"
     name="lname" required>
   </div>
   <div class="form-group">
    <label for="name">Class: </label>
     <select name="class1" class="form-control" id="class1">
     <!-- option value="0"> select class </option-->
     <% for(int i=0; i<class1list.size();i++ ){
    	 Class1 class1 =(Class1)class1list.get(i);
     %>
     
     <option value="<%out.print(class1.getId()); %>"><% out.print(class1.getClassName()); %></option>
     <% }%>
     
     </select>
     
   </div>
   <button type="submit" class="btn btn-primary" name="addStudent" value="addStudent">Add</button>
  </form>
 </div>

</body>


</html>