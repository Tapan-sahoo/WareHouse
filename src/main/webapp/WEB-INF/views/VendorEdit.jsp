<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<bodybgcolor ="blue" leftmargin="550px">
<h2 style="color: red; text-align: center">Welcome to Vendor Edit
	 Page</h2>
<form:form action="update" method="POST" modelAttribute="vendor">
	<pre>
	
Vendor Id:	<form:input path="venId" readonly="true" />	
Vendor Name	:	<form:input path="venName" />
Vendor Designation:	<form:radiobutton path="venDesg" value="Sale" />SALE <form:radiobutton
			path="venDesg" value="service" />SERVICE <form:radiobutton
			path="venDesg" value="both" />BOTH

Vendor Code:	<form:select path="venCode">
			
<form:option value="">---Select---</form:option>
<form:option value="CAT">CAT</form:option>
<form:option value="RES">RES</form:option>
</form:select>
		
Vendor Preserve:	<form:checkbox path="venPreserve" value="A" />A	
		<form:checkbox path="venPreserve" value="B" />B
		<form:checkbox path="venPreserve" value="C" />C			

	<input type="submit" value="update" />
	</pre>
</form:form> Vendor ::: ${message}
</body>
</html>
