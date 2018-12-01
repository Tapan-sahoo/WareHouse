
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2{
text-align:center;
}

.effects1{

background-color: #660033;
border:1px solid black;
width: 800px;
margin:auto;
font-weight:bold;
font-size: 15px;
color:white;
}

.effects{

background-color: #7ABA7A;
/* border:1px solid black; */
width: 700px;
margin:auto;
margin-top:0px;
font-weight:bold;
font-size: 15px;
color:white;
}

fieldset{
position:relative;
margin:auto;
padding:0.35em 0.625em 0.75em;
width:600px;
background-color: #7ABA7A;
}

.legend2{
position:absolute;
bottom:-1.4ex;
left:10px;
background:white;
}

caption, .legend2{
padding:0.2px;
}

.err{
color:red;
}
</style>

</head>
<body bgcolor="#3498DB" leftmargin="550px">
<div class="effect1">
	<h2 style="color: red; text-align: center">Welcome to Customer
		Registration Page</h2>
		</div>
		<fieldset>
		<legend>
		<span class=legend2>CUSTOMER</span>
		</legend>

<form:form action="insert" method="POST" modelAttribute="cust" cssClass="effects">
		<pre>
Customer Code		:	<form:input path="custCode" /><br>	
<form:errors path="custCode" cssClass="err" />
Customer Address	:	<form:textarea path="custAddr" /><br>	
<form:errors path="custAddr" cssClass="err" />
Customer Location	:	<form:select path="custLocs" multiple="true">
<form:option value="">---Select---</form:option>
<form:option value="HYD">HYD</form:option>
<form:option value=" BAN">BAN</form:option>
<form:option value="CHN">CHN</form:option>
</form:select>
<form:errors path="custLocs" cssClass="err" />
<br>
Customer Enabled	:	<form:radiobutton path="custEnabled" value="YES" />Yes <form:radiobutton
				path="custEnabled" value="No" />No<br>
<form:errors path="custEnabled" cssClass="err" />
Customer Email		:	<form:input path="custEmail" />	
<form:errors path="custEmail" cssClass="err" /><br>		
Customer Contact	:	<form:input path="custContact" />
<form:errors path="custContact" cssClass="err" />
<br>
			
	
			<input type="submit" value="Create Customer">
	</pre>
	</form:form>
</fieldset>
	<p style="text-align:center">Customer :: ${message}</p>
</body>
</html>