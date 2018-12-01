
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
				<h2>Welcome to Item Edit Page</h2>
			</div>
			<div class="card-body">

				<form:form action="update" method="POST" modelAttribute="item"
					cssClass="form">


					<div class="form-group">
						<label for="itemCode" class="control-label col-sm-4">Item
							Id</label>
						<form:input path="itemId" readonly="true" />
					</div>

					<div class="form-group">
						<label for="itemCode" class="control-label col-sm-4">Item
							Code</label>
						<form:input path="itemCode" />
						<br>
						<form:errors path="itemCode" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="Length" class="control-label col-sm-4">Item
							Dimensions</label>
						<form:input path="width" size="10px" />
						W
						<form:input path="length" size="10px" />
						L
						<form:input path="height" size="10px" />
						H
						<form:errors path="length" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="baseCost" class="control-label col-sm-4">Base
							Cost</label>
						<form:input path="baseCost" />
						<form:errors path="baseCost" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="baseCurrency" class="control-label col-sm-4">Base
							Currency</label>
						<form:select path="baseCurrency">
							<form:option value="">---Select---</form:option>
							<form:option value="INR">INR</form:option>
							<form:option value="USD">USD</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="ERU">ERU</form:option>
						</form:select>
						<form:errors path="baseCurrency" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="uom" class="control-label col-sm-4">Item UOM</label>

						<form:select path="uom.id">
							<form:option value="">---Select---</form:option>
							<form:options items="${uom}" itemLabel="model" itemValue="id" />
						</form:select>
						<br>
						<form:errors path="uom" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="sales" class="control-label col-sm-4">Order
							Method(Sale Type)</label>
						<form:select path="omSale.id">
							<form:option value="">---SELECT---</form:option>
							<form:options items="${sales}" itemLabel="code" itemValue="id" />
						</form:select>
						<form:errors path="omSale" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="sales" class="control-label col-sm-4">Order
							Method(Purchase Type)</label>

						<form:select path="omPurchase.id">
							<form:option value="">---SELECT---</form:option>
							<form:options items="${purchase}" itemLabel="code" itemValue="id" />
						</form:select>
						<form:errors path="omPurchase" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="sales" class="control-label col-sm-4">Item
							Vendors</label>

						<form:select path="whVendor">
							<form:option value="">-SELECT-</form:option>
							<form:options items="${vendor}" itemLabel="code" itemValue="id" />
						</form:select>
						<form:errors path="whVendor" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="sales" class="control-label col-sm-4">Item
							Customers</label>

						<form:select path="whCustomer">
							<form:option value="">-SELECT-</form:option>
							<form:options items="${customer}" itemLabel="code" itemValue="id" />
						</form:select>
						<form:errors path="whCustomer" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="dcpt" class="control-label col-sm-4">UOM NOTE</label>
						<form:textarea path="dcpt" />
						<form:errors path="dcpt" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<input type="submit" value="Update" class="btn btn-success" />
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