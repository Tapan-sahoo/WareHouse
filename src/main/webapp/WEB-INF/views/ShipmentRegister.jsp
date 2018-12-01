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
				<h2>Welcome to Shipment Type Page</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="st"
					cssClass="form">


					<div class="form-group">
						<label for="mode" class="control-label col-sm-4">Shipment
							Mode </label>
						<form:select path="mode">
							<form:option value="">---Select---</form:option>
							<form:option value="Air">AIR</form:option>
							<form:option value="Truck">TRUCK</form:option>
							<form:option value="ship">SHIP</form:option>
							<form:option value="Train">TRAIN</form:option>
						</form:select>
						<form:errors path="mode" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="code" class="control-label col-sm-4">Shipment
							Code </label>
						<form:input path="code" />
						<form:errors path="code" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="enable" class="control-label col-sm-4">Enabled
							Shipment </label>
						<form:checkbox path="enable" value="YES" />
						YES
						<form:errors path="enable" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="grade" class="control-label col-sm-4">Shipment
							Grade </label>
						<form:radiobutton path="grade" value="A" />
						A
						<form:radiobutton path="grade" value="B" />
						B
						<form:radiobutton path="grade" value="C" />
						C
						<form:errors path="grade" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="dcpt" class="control-label col-sm-4">Shipment
							NOTE</label>
						<form:textarea path="dcpt" />
						<form:errors path="dcpt" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<input type="submit" value="Register" class="btn btn-success" />
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