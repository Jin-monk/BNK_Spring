<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Show Board Page</h1>
	<hr>
	
	<table border = "1">
		<thead>
			<tr>
				<th>bno</th>
				<th>title</th>
				<th>content</th>
				<th>writer</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${board }" varStatus="status"> 
				<tr>
					<td>${board.bno }</td>
					<td><a href="/boardDetail?title=${board.title }">${board.title }</a></td>
					<td>${board.content }</td>
					<td>${board.writer }</td>
					<td>${board.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>