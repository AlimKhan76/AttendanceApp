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

	<div class=" col-md-6 offset-md-3">

		<h1 class="text-center mb-3">Login Page</h1>
		<div class="alert alert-success" role="alert">
			<c:out value="${success }" />
		</div>
		<div class="alert alert-danger" role="alert">
			<c:out value="${exception }" />
		</div>

		<form action="log" method="post">
			<div class="form-group ">
				<label for="uname">Username</label> <input type="text"
					class="form-control" id="uname" name="uname"
					aria-describedby="emailHelp" placeholder="Enter Username">
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Password">
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-lg btn-success">Login</button>
<!-- 				<a href="reg-page" class="btn btn-lg btn-primary">Register</a>
 -->
			</div>
			<div class="container text-center pt-3">
				<a href="/" class="btn btn-lg btn-secondary">Return Home</a>

			</div>

		</form>
	</div>
</body>
</html>