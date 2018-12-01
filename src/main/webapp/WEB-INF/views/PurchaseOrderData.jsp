<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body bgcolor="green">
	<h1 style="color: red; text-align: center">Welcome to Purchase
		Order Page</h1>
	<a href="excel">Excel Export</a> | |
	<a href="pdf"> PDF Export</a>
	<br>
	<table border="1" cellspacing="4" cellpadding="4" align="center"
		style="background-color: marron; color: Orange;">
		<tr>
			<th>ID</th>
			<th>ORDER CODE</th>
			<th>SHIPMENT CODE</th>
			<th>VENDOR</th>
			<th>PREFENCE NO.</th>
			<th>QUALITY CHECK</th>
			<th>DEFAULT STATUS</th>
			<th>DESCRIPTION</th>
			<th colspan=2>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="p">
			<tr>
				<td><c:out value="${p.id}" /></td>
				<td><c:out value="${p.orderCode}" /></td>
				<td><c:out value="${p.sCode.code}" /></td>
				<td><c:out value="${p.vendorType.code}" /></td>
				<td><c:out value="${p.prefenceNumber}" /></td>
				<td><c:out value="${p.qualityCheck}" /></td>
				<td><c:out value="${p.defaultStatus}" /></td>
				<td><c:out value="${p.dcpt}" /></td>

				<td><a href="delete?id=${p.id}">DELETE</a></td>
				<td><a href="edit?id=${p.id}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>