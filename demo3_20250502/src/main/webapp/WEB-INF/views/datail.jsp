<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>phone</th>
				<th>grade</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><a href="beforeupdate?id=${member.id}"> ${member.id}</a></td>
				<td>${member.pw}</td>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.grade}</td>
			</tr>
		</tbody>
	</table>
	<a href="/">홈으로</a>
</body>
</html>