<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body bgcolor ="green" leftmargin="550px">
<h2 style="color: red; text-align: center">Welcome to Vendor
	Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="vd" >
	<pre>
Vendor Name		:	<form:input path="venName" />
<form:errors path="venName" cssClass="err"/>	
Vendor Code		:	<form:select path="venCode">
<form:option value="">---Select---</form:option>
<form:option value="CAT">CAT</form:option>
<form:option value="RES">RES</form:option>
</form:select>
<form:errors path="venCode" cssClass="err"/>
		
Vendor Designation	:	<form:radiobutton path="venDesg" value="Sale" />SALE <form:radiobutton
			path="venDesg" value="service" />SERVICE <form:radiobutton path="venDesg" value="both" />BOTH
<form:errors path="venDesg" cssClass="err"/>
Vendor Preserve		:	<form:checkbox path="venPreserve" value="A" />A <form:checkbox path="venPreserve" value="B" />B <form:checkbox path="venPreserve" value="C" />C			
<form:errors path="venPreserve" cssClass="err"/>
	<input type="submit" value="Create Vendor" />
	</pre>
</form:form> Vendor ::: ${message}
</body>
</html>