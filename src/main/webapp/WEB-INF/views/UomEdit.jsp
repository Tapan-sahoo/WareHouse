<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container">
		<div class="card">
			<div class="card-header bg-success text-white text-center">
				<h2>welcome to Unit of Measurement Edit Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="uom"
					cssClass="form">

					<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">UOM Id</label>
						<form:input path="id" readonly="true"
							cssClass="form-control col-sm-4" />
					</div>

					<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">UOM
							TYPE</label>
						<form:select path="type" cssClass="form-control col-sm-4">
							<form:option value="">---Select---</form:option>
							<form:option value="PACKING">PACKING</form:option>
							<form:option value=" NOPACKING"> NO PACKING</form:option>
							<form:option value="">--NA--</form:option>
						</form:select>
						<form:errors path="type" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM
							MODEL</label>
						<form:input path="model" cssClass="form-control col-sm-4" />
						<form:errors path="model" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM
							NOTE</label>
						<form:textarea path="dcpt" cssClass="form-control col-sm-4" />
						<form:errors path="dcpt" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<input type="submit" value="Update" class="btn btn-success" />
					</div>

				</form:form>
				<!-- End of card body -->
				<div>


					<!-- card footer -->
					<c:if test="${message ne null }">
						<div class="card-footer bg-info text-white">${message}</div>
					</c:if>

					<!-- End of card  -->
				</div>
				<!-- End of Container -->

			</div>
		</div>
	</div>
</body>
</html>