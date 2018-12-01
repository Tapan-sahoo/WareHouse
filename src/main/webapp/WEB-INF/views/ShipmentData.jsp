<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body >
<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
	<h1>Welcome to Shipment Page</h1></div>
	<div class="card-body">
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover ">
							<tr class="bg-dark text-white text-center">
			<th>ID</th>
			<th>MODE</th>
			<th>CODE</th>
			<th>ENABLED</th>
			<th>GRADE</th>
			<th>DESCRIPTION</th>
			<th colspan=2>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="s">
			<tr class="text-center">
				<td><c:out value="${s.id}" /></td>
				<td><c:out value="${s.mode}" /></td>
				<td><c:out value="${s.code}" /></td>
				<td><c:out value="${s.enable}" /></td>
				<td><c:out value="${s.grade}" /></td>
				<td><c:out value="${s.dcpt}" /></td>

				<td><a href="delete?id=${s.id}"class="btn btn-danger"><i class="fa fa-trash"></i> DELETE</a></td>
				<td><a href="edit?id=${s.id}"class="btn btn-success"><i class="fa fa-pencil"></i> EDIT</a></td>
			</tr>
		</c:forEach>
		</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data found in Database</div>
					</c:otherwise>
				</c:choose>
					<a href="excel" class="btn btn-success">Excel Export</a>  <a href="pdf" class="btn btn-success"> PDF Export</a><br>
			</div>
			<!-- End of Card body -->
		
			<!-- card footer -->
			<c:if test="${message ne null}">
				<div class="card-footer bg-warning ">${message}</div>
				</c:if>
		</div>
		<!-- End of Card -->
	</div>
	<!-- End of div container -->
</body>
</html>