<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="skyblue" leftmargin="550px">
	<h2 style="color: red; text-align: center">Welcome to Customer
		Registration Page</h2>

	<form:form action="update" method="POST" modelAttribute="cust">
		<pre>
Customer Id:	<form:input path="custId" readonly="true" />
Customer Code:<form:input path="custCode" />	
Customer Address:<form:textarea path="custAddr" />	
Customer Location:	 <form:select path="custLocs" multiple="true">
<form:option value="">---Select---</form:option>
<form:option value="HYD">HYD</form:option>
<form:option value=" BAN">BAN</form:option>
<form:option value="CHN">CHN</form:option>
</form:select>

<%-- <form:select path="custLocs" multiple="true">
	<form:options items="${availableHobbies}"/>
</form:select> --%>
Customer Enabled:	<form:radiobutton path="custEnabled" value="YES" />Yes <form:radiobutton
				path="custEnabled" value="No" />No
Customer Email:<form:input path="custEmail" />			
Customer Contact:	<form:input path="custContact" />
			
	<input type="submit" value="Update Customer">
	</pre>
	</form:form>

	Customer :: ${message}
</body>
</html>