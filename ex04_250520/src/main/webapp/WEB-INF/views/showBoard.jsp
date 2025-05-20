<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border ="1">
		<thead>
			<tr>
				<th>no</th>
				<th>title</th>
				<th>content</th>
				<th>writer</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bod" items="${list }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${bod.title }</td>
					<td>${bod.content }</td>
					<td>${bod.writer }</td>
					<td>${bod.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>