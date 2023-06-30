<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- This page is Displayed after hitting the logout button in the Login-page.
    It display the name of the user, the logout date and time and a login button on
    which the user again has to reenter his credentials to login.    
     -->
     
     
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
<h1 class="text-center">Logging Out ${Name} </h1>
<br><br><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">UserName</th>
      <th scope="col">LogOut Date and time</th>
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
	<a href="login" >
      	<button type="button" class="btn btn-success">Log in</button>
      	</a>
      </div>
		
</div>
</div>

</div>
</body>
</html>