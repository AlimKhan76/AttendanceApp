<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- This page is loaded after a successful login and it shows the name 
    of the user, the login date and time and a logout button -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp" %>
<title>Welcome ${Name }</title>
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center">Welcome ${Name} </h1>
<br><br><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">UserName</th>
      <th scope="col">Login Date and time</th>
      <th scope="col">Status</th>
    </tr>
  </thead>
  <tbody>
    
    <tr>
      <th scope="row">${Name }</th>
      <td>${Date }</td>
      <td>${status }</td>
        </tr>
  </tbody>
</table>
<br><br>
<div class="container text-center">
<a href="logOutRedirect" class="btn btn-lg btn-danger">Log Out </a>
	<br>
	<br>
      <a href="report/${Name}/0">
      <button class="btn btn-lg btn-info">View Attendance</button>
      </a>
</div>
</div>
</div>
</div>
</body>
</html>