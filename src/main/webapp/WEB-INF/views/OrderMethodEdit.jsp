
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container">
		<div class="card">
			<div class="card-header bg-secondary  text-white text-center">
				<h2>Welcome to Order Method Edit Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="om"
					cssClass="form">
					
					<div class="form-group">
						<label for="Order id" class="control-label col-sm-4">Order Id</label>
						<form:input path="id" readonly="true" />
					</div>
					

					<div class="form-group">
						<label for="mode" class="control-label col-sm-4">Order
							Mode </label>
						<form:radiobutton path="mode" value="Sale" />
						SALE 
						<form:radiobutton path="mode" value="Purchase" />
						PURCHASE
						<form:errors path="mode" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="code" class="control-label col-sm-4">Order
							Code </label>
						<form:input path="code"  />
						<form:errors path="code" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="method" class="control-label col-sm-4">Order
							Method </label>

						<form:select path="method" >

							<form:option value="">---Select---</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
						<form:errors path="method" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="accept" class="control-label col-sm-4">Order
							Accept </label>
						<form:checkbox path="accept" value="Muti-Model" />
						Multi-Model
						<form:checkbox path="accept" value="Accept Return" />
						Accept Return
						<form:errors path="accept" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="dcpt" class="control-label col-sm-4">Order
							NOTE</label>
						<form:textarea path="dcpt" />
						<form:errors path="dcpt" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<input type="submit" value="Update" class="btn btn-secondary" />
					</div>

				</form:form>
				

				<!-- card footer -->
				<c:if test="${message ne null }">
					<div class="card-footer bg-info text-white">${message}</div>
				</c:if>

				<!-- End of card  -->
			</div>
			<!-- End of Container -->

		</div>
	</div>
	
</body>
</html>