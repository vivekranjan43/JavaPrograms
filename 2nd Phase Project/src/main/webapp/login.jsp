<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "LoginHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<section class="vh-100" style="background-color: #508bfc;">   
   <div class="container py-5 h-100";style="overflow: auto;display: inline-block;">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Sign in</h3>
  
  <form action="<%=request.getContextPath()%>/login" method="post">  
   <div class="form-group">
    <label for="uname"></label> <input type="text"
     class="form-control" id="username" placeholder="User Name"
     name="uname" required>
   </div>
   <div class="form-group">
    <label for="uname"></label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div> 
  <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
  <div>
              <p class="mb-0">Don't have an account? <a href="<%=request.getContextPath()%>/signup.jsp" class="text-blue-50 fw-bold">Sign Up</a></p>
            </div>
  </form>
 </div>
</section>
</body>
</html>