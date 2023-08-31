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
				<br> <br> <br>
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

				<div class="container my-5 align-items-center text-center">
					<nav  aria-label="Page navigation example">
						<ul class="pagination pagination-lg justify-content-center">

							<c:if test="${currentPage-1 != -1}">
								<li class="page-item"><a class="page-link"
									href="/report/${Name }/${currentPage-1}"><span>&laquo;</span>Previous</a></li>

							</c:if>
							
								
							
							
							

							<c:if test="${currentPage+1 != totalPages }">

								<li class="page-item"><a class="page-link"
									href="/report/${Name}/${currentPage+1}">Next<span>&raquo;</span></a></li>
							</c:if>
						</ul>
					</nav>


					<a href="/" class="btn btn-lg btn-secondary">Return to Home
						Page</a>
				</div>
			</div>

		</div>

	</div>
</body>
</html>