<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Admin report</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Admin Page</h1>
				<br> <br> <br>

				<!-- All the user registered in the Database are shown in a tabular format -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Username</th>
							<th scope="col">Email Id</th>
							<th scope="col">Phone Number</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>

						<!--Data recieved through validate() of LoginController 
							is iterated here through a forEach loop using jstl tag-->
						<c:forEach items="${allUser}" var="p">
							<tr>
								<th scope="row">${p.uname}</th>
								<td>${p.email }</td>
								<td>${p.phone_number}</td>
								<td>
									<!-- Form used with a hidden field to 
									get the uname of the user of whose attendance
									 will be viewed -->
									
											<a href="report/${p.uname}/0">
										<button class="btn btn-info">View
											Attendance</button>
											</a>
											<a class="btn btn-info" href="/export-to-excel/${p.uname }">Download
						Attendance Report </a>
				
									

								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>