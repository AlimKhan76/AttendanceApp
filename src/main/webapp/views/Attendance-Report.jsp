<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp"%>
<title>Attendance Report of ${Name }</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Attendance Report of ${Name}</h1>
				<br>
				<br>
				<br>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">UserName</th>
							<th scope="col">Date</th>
							<th scope="col">Time</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>

						<!-- Login and Logout Details are showed here.
  The data is received through ReportofUser() of the LoginController -->

						<c:forEach items="${list}" var="Record">
							<tr>
								<th scope="row">${Record.uname }</th>
								<td>${Record.logdate }</td>
								<td>${Record.logtime }</td>
								<td>${Record.status }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</div>

	</div>
</body>
</html>