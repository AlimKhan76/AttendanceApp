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

				<div class="container my-3 align-items-center text-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination pagination-lg justify-content-center">

							<c:if test="${currentPage-1 != -1}">
								<li class="page-item"><a class="page-link"
									href="/report/${Name }/${0}"><span>&laquo;&laquo;&laquo;</span></a></li>

							</c:if>

							<c:if
								test="${(totalPages >5 && totalPages>currentPage+2) && currentPage>1}">

								<c:forEach var="i" begin="${currentPage-1}"
									end="${currentPage+3}">
									<c:if test="${currentPage==i-1}">
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
									<c:if test="${currentPage!=i-1}">
										<li class="page-item"><a class="page-link"
											href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if
								test="${(totalPages >5 && totalPages<=currentPage+2) && currentPage>1}">
								<c:forEach var="i" begin="${totalPages-4}" end="${totalPages}">
									<c:if test="${currentPage==i-1}">
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
									<c:if test="${currentPage!=i-1}">
										<li class="page-item"><a class="page-link"
											href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if
								test="${(totalPages >5 && totalPages>=currentPage) && (currentPage==0 || currentPage==1)}">
								<c:forEach var="i" begin="1" end="5">
									<c:if test="${currentPage==i-1}">
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
									<c:if test="${currentPage!=i-1}">
										<li class="page-item"><a class="page-link"
											href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${totalPages <=5}">
								<c:forEach var="i" begin="1" end="${totalPages}">
									<c:if test="${currentPage==i-1}">
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
									<c:if test="${currentPage!=i-1}">
										<li class="page-item"><a class="page-link"
											href="/report/${Name }/${i-1}">${i}</a></li>
									</c:if>
								</c:forEach>
							</c:if>





							<c:if test="${currentPage+1 != totalPages }">

								<li class="page-item"><a class="page-link"
									href="/report/${Name}/${totalPages-1}"><span>&raquo;&raquo;&raquo;</span></a></li>
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