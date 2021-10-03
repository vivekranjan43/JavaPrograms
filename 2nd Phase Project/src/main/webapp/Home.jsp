<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.dto.Class1"%>
 <%@page import="com.dto.Student"%>
 <%@page import="com.dto.Subject"%>
 <%@ include file = "Header.jsp"%>

  
 <% ArrayList class1list = (ArrayList)request.getAttribute("class1list");
 ArrayList subjectlist = (ArrayList)request.getAttribute("subjectlist");
 ArrayList studentlist = (ArrayList)request.getAttribute("studentlist");
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>
<div class="container-fluid">
<div class="row">
<div class="col-md-1" style="overflow: auto;display: inline-block;">
</div>

<div class="col-md-4" style="overflow: auto;display: inline-block;">
<h3 >Subjects and Teacher details</h3>
<table class="table" >
<tr>
<th class="col-md-6">Subject name</th>
<th class="col-md-6">Teacher</th>
</tr>
<%for(int i=0; i<subjectlist.size();i++){ %>

<% Subject subject =(Subject)subjectlist.get(i); %>
<tr class='clickable-row'>
	<td>
	<%out.print(subject.getSubjectName()); %>
	</td>
	<td>
	<%
	try{
	out.print(subject.getTeacher().getTeacherName());
	}catch(Exception ex){
			
	}
	%>
	</td>
	
</tr>

<% } %>


</table>

</div>
<div class="col-md-4 " style="overflow: auto;display: inline-block;">
<h3>Student details:</h3>
<table class="table">
<tr>
<th class="col-md-6">First name</th>
<th class="col-md-6">Last name</th>
</tr>
<%for(int i=0; i<studentlist.size();i++){ %>

<% Student student =(Student)studentlist.get(i); %>
<tr class='clickable-row'>
	<td>
	<%out.print(student.getStudentFirstName()); %>
	</td>
	<td>
	<%	out.print(student.getStudentLastName()); %>
	</td>
	
</tr>

<% } %>


</table>

</div>

<div class="col-md-2" style="overflow: auto;display: inline-block">
  <h3>Search by Class</h3>
  <form action="<%=request.getContextPath()%>/dashboard" method="post">
   <div class="form-group">
   <label for="name">Class: </label>
     <select name="classId" class="form-control" id="classId">
    
    <% for(int i=0; i<class1list.size();i++ ){
    	 Class1 class1 =(Class1)class1list.get(i);
     %>
     
     <option value="<%out.print(class1.getId()); %>"><% out.print(class1.getClassName()); %></option>
     <% }%>
    </select>
   </div>
   <button type="submit" class="btn btn-primary" name="searchByClass" value="searchByClass">Search</button>
  </form>
  
 </div>
</div>
</div>
</body>

</html>