<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
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
<body>
	<div class="container" >
		<div class="card">
			<div class="card-header bg-primary text-white text-center ">
				<h1>Welcome to Item Data Page</h1>
			</div>
			<div class="card-body text-border">
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover table-bordered table-sm">
							<tr class="bg-dark text-white text-center">
			<th>ID</th>
			<th>CODE</th>
			<th>DIMENSION</th>
			<th>BASE COST</th>
			<th>BASE CURRENCY</th>
			<th>UOM</th>
			<th>SALE</th>
			<th>PURCHASE</th>
			<th>VENDOR</th>
			<th>CUSTOMER</th>
			<th>DESCRIPTION</th>
			<th colspan=2>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="i">
			<tr class="text-center">
				<td class="table-secondary"><c:out value="${i.itemId}" /></td>
				<td><c:out value="${i.itemCode}" /></td>
				<td>W:<c:out value=" ${i.width}" /> L:<c:out
						value="${i.length}" /> H:<c:out value=" ${i.height}" /></td>
				<td><c:out value="${i.baseCost}" /></td>
				<td><c:out value="${i.baseCurrency}" /></td>
				<td><c:out value="${i.uom.model}" /></td>
				<td><c:out value="${i.omSale.code}" /></td>
				<td><c:out value="${i.omPurchase.code}" /></td>

				<td><c:forEach items="${i.whVendor}" var="ven">
						<c:out value="${ven.code}" />
	</c:forEach></td>
				<td><c:forEach items="${i.whCustomer}" var="cust">
						<c:out value="${cust.code}" />
	</c:forEach></td>

				<td><c:out value="${i.dcpt}" /></td>


				<td><a href="delete?id=${i.itemId}" class="btn btn-danger"><i class="fa fa-trash"></i> DELETE</a></td>
				<td><a href="edit?id=${i.itemId}" class="btn btn-danger"><i class="fa fa-pencil"></i> EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
				</c:when>
					<c:otherwise>
						<div class="text-info">No Data found in Database</div>
					</c:otherwise>
				</c:choose>
				<a href="excel" class="btn btn-success">Excel Export</a> <a
					href="pdf" class="btn btn-success"> PDF Export</a><br>
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