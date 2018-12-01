<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: red; text-align: center">Welcome To Document upload Page</h2>

<form action="upload" method="post" enctype="multipart/form-data">

<pre>
File:	<input type="file" name="file"/><br>
	<input type="submit" value="upload">
</pre>
</form>

<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>LINK</th>
<tr>
<c:forEach items="${docs}" var="doc">
<tr>
<td><c:out value="${doc[0]}"/></td>
<td><c:out value="${doc[1]}"/></td>
<td><a href="download?fileId=${doc[0]}">Download</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>