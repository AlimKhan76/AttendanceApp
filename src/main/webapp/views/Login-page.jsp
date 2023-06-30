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
<form action="logOut" method="post">
      <input type="hidden" name="name" id="name" value="${Name }" class="d-none">
      <button type="submit" class="btn btn-danger">Log Out</button>
      </form>
	
	<br>
     <form action="report" method="post">
      <input type="hidden" name="name" id="name" value="${Name }" class="d-none">
      <button type="submit" class="btn btn-info">View Attendance</button>
      </form>
</div>
</div>
</div>
</div>
</body>
</html>