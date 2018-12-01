
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2 {
	text-align: center;
}

.effects1 {
	background-color: #660033;
	border: 1px solid black;
	width: 800px;
	margin: auto;
	font-weight: bold;
	font-size: 15px;
	color: white;
}

.effects {
	background-color: #7ABA7A;
	/* border:1px solid black; */
	width: 1000px;
	margin: auto;
	margin-top: 0px;
	font-weight: bold;
	font-size: 15px;
	color: white;
}

fieldset {
	position: relative;
	margin: auto;
	padding: 0.35em 0.625em 0.75em;
	width: 600px;
	background-color: #7ABA7A;
}

.legend2 {
	position: absolute;
	bottom: -1.4ex;
	left: 10px;
	background: white;
}

caption, .legend2 {
	padding: 0.2px;
}
</style>

</head>
<body bgcolor="#3498DB" leftmargin=""250px"">
	<div class="effect1">
		<h2 style="color: red; text-align: center">Welcome to Purchase Order Update
			 Page</h2>
	</div>
	<fieldset>
		<legend>
			<span class=legend2>PURCHASEORDER</span>
		</legend>

		<form:form action="update" method="post" modelAttribute="porder"
			cssClass="effects">
			<pre>
Purchase Id		:	<form:input path="id" readonly="true" />
				<br>
Order Code		:	<form:input path="orderCode" />

ShipmentCode		:	<form:select path="sCode.id">
<form:option value="">---Select---</form:option>
<form:options items="${shipment}" itemLabel="code" itemValue="id" />
</form:select>	<br>

Vendor			:	<form:select path="vendorType">
<form:option value="">---SELECT---</form:option>
<form:options items="${vendor1}" itemLabel="code" itemValue="id" />
</form:select> 

Preference Number	:	<form:input path="prefenceNumber" />

Quality Check		:	<form:radiobutton path="qualityCheck" value="Required" />Required  <form:radiobutton
					path="qualityCheck" value="Not-Required" />Not-Required 
					
Default Status		:	<form:input path="defaultStatus" />

Description		:	<form:textarea path="dcpt" />
				
			<input type="submit" value="Update PurchaseOrder">
	</pre>
		</form:form>
	</fieldset>
	<p style="text-align: center">Purchase Order :: ${message}</p>
</body>
</html>