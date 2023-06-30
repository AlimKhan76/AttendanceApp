<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<title>Registration Page</title>
</head>
<body>
	<!-- Dynamically render the error or the Success message -->
	<div class=" col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Registration Page</h1>
		<div class="alert alert-danger" role="alert">
			<c:out value="${exception }" />
		</div>
		<!-- Ending Dynamically render the error or the Success message -->


		<!-- Form for the registration of User 
	It Sends the form to RegisterController -->
		<form action="register" method="post">
			<!-- 2 column grid layout with text inputs for the first and last names -->
			<div class="row mb-4">
				<div class="col">
					<div class="form-outline">

						<!-- Input field for username -->
						<label class="form-label" for="uname">Username</label> <input
							type="text" id="uname" name="uname" class="form-control" />

					</div>
				</div>

			</div>

			<!-- Message input -->
			<div class="form-outline mb-4">
				<label class="form-label" for="password">Password</label> <input
					type="text" id="password" name="password" class="form-control" />


			</div>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<label class="form-label" for="email">Email</label> <input
					type="email" id="email" name="email" class="form-control" />

			</div>

			<div class="form-outline mb-4">
				<label class="form-label" for="phone_number">Phone Number</label> <input
					type="number" id="phone_number" name="phone_number"
					class="form-control" />

			</div>

			<div class="container text-center">
				<!-- Redirects to Login page -->
				<a href="login" class="btn btn-outline-danger">Login</a>

				<button type="submit" class="btn btn-primary">Register</button>

			</div>
		</form>
	</div>
</body>
</html>