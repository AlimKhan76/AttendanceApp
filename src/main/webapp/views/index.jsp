<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- This is the starting page of the project. On this page the user logs in 
	using his registered username and password -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="base.jsp"%>
<title>Login Page</title>
</head>
<body>

<div class=" my-5 row h-100 align-items-center ">

			<div class="text-center col-12 align-items-center justify-content-center  " >
		<h1 class=" my-3">Home Page</h1>

			<h3>Would You Like to ?</h3>		
			
							<a href="login" class="btn btn-lg btn-success">Log In</a>
							<a href="logOutRedirect" class="btn btn-lg btn-danger">Log Out</a>
							<div class="container text-center pt-3">
							<a href="reg-page" class="btn  btn-lg btn-primary">Register</a>
							</div>
			</div>
			
			
			</div>
		


	
</body>
</html>