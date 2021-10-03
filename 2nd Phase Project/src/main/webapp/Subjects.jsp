<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.dto.Subject"%>
 <%@page import="com.dto.Teacher"%>
 <%@page import="com.dto.Class1"%>
 
 <%@ include file = "Header.jsp"%>

  
 <% ArrayList subjectlist = (ArrayList)request.getAttribute("subjectlist");
 ArrayList class1list = (ArrayList)request.getAttribute("class1list");
 ArrayList teacherlist = (ArrayList)request.getAttribute("teacherlist");
 
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>

<div class="container col-md-1" style="overflow: auto;display: inline-block;">
</div>

<div class="container col-md-6" style="overflow: auto;display: inline-block;">
<h3>Subjects List</h3>
<table >
<tr>
<th class="col-md-3">Subject name</th>
<th class="col-md-3">Class</th>
<th class="col-md-3">Teacher</th>
<th class="col-md-3">Description</th>
<th class="col-md-2"></th>
</tr>
<%for(int i=0; i<subjectlist.size();i++){ %>

<% Subject subject =(Subject)subjectlist.get(i); %>
<tr class='clickable-row'>
	<td>
	<%out.print(subject.getSubjectName()); %>
	</td>
	<td>
	<%out.print(subject.getClass1().getClassName()); %>
	</td>
	<td>
	<%
	try{
		out.print(subject.getTeacher().getTeacherName());
		}catch(Exception ex){
			
		}
		%>
	</td>
	<td>
	<%	out.print(subject.getDescription()); %>
	</td>
	<td><form action="<%=request.getContextPath()%>/listsubjects" method="post">
	<input style="display:none;" type="text" name="SubjectId"  value="<%out.print(subject.getId());%>">
	<button type="submit" class="btn" name="deleteSubject" value="deleteSubject"><i class="fa fa-trash"></i></button>
	</form>
	</td>
	
</tr>

<% } %>


</table>

</div>

<div class="container col-md-3" style="overflow: auto;display: inline-block; position: absolute">
  <h3>Add New Subject</h3>
  <form action="<%=request.getContextPath()%>/listsubjects" method="post">
   <div class="form-group">
    <label for="name">Subject Name: </label> <input type="text"
     class="form-control" id="name" placeholder="Subject Name"
     name="name" required>
   </div>
   <div class="form-group">
    <label for="name">Class: </label>
     <select name="class1" class="form-control" id="class1">
     <% for(int i=0; i<class1list.size();i++ ){
    	 Class1 class1 =(Class1)class1list.get(i);
     %>
     
     <option value="<%out.print(class1.getId()); %>"><% out.print(class1.getClassName()); %></option>
     <% }%>
     
     </select>
     
   </div>
   <div class="form-group">
    <label for="name">Teacher: </label>
     <select name="teacher" class="form-control" id="teacher">
     <% for(int i=0; i<teacherlist.size();i++ ){
    	 Teacher teacher =(Teacher)teacherlist.get(i);
     %>
     
     <option value="<%out.print(teacher.getId()); %>"><% out.print(teacher.getTeacherName()); %></option>
     <% }%>
     
     </select>
     
   </div>
   <div class="form-group">
    <label for="name">Description: </label> <input type="text"
     class="form-control" id="discription" placeholder="Description"
     name="discription">
   </div>
   <button type="submit" class="btn btn-primary" name="addSubject" value="addSubject">Add</button>
  </form>
  
 </div>
 


</body>

</html>