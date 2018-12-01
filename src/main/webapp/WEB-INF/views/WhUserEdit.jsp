
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<h2>Welcome to WhUser Edit Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="wu"
					cssClass="form">

					<div class="form-group">
						<label for="id" class="control-label col-sm-4">User ID</label>
						<form:input path="id" readonly="true" />
					</div>

					<div class="form-group">
						<label for="type" class="control-label col-sm-4">User Type</label>
						<form:radiobutton path="type" value="Vendor" />
						Vendor
						<form:radiobutton path="type" value="Customer" />
						Customer
						<form:errors path="type" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="code" class="control-label col-sm-4">User Code
						</label>
						<form:input path="code" />
						<form:errors path="code" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="forType" class="control-label col-sm-4">User
							For </label>
						<form:select path="forType">
							<form:option value="Purchase">Purchase</form:option>
							<form:option value="sale">Sale</form:option>
						</form:select>
						<form:errors path="forType" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="email" class="control-label col-sm-4">User
							Email </label>
						<form:input path="email" />
						<form:errors path="email" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="contact" class="control-label col-sm-4">User
							Contact </label>
						<form:input path="contact" />
						<form:errors path="contact" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="idType" class="control-label col-sm-4">User ID
							Type </label>
						<form:select path="idType">
							<form:option value="">---Select---</form:option>
							<form:option value="PANCARD">PANCARD</form:option>
							<form:option value="AADHAR">AADHAR</form:option>
							<form:option value="VOTERID">VOTERID</form:option>
							<form:option value="OTHER">OTHER</form:option>
						</form:select>
						<form:errors path="idType" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="ifOther" class="control-label col-sm-4">*If
							Other </label>
						<form:input path="ifOther" />
						<form:errors path="ifOther" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="idNum" class="control-label col-sm-4">ID
							Number </label>
						<form:input path="idNum" />
						<form:errors path="idNum" cssClass="text-danger" />
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