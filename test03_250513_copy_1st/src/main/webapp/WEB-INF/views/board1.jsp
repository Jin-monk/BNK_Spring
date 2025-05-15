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
<jsp:include page="fragments/header.jsp"></jsp:include>
	<h2>공지사항 게시판</h2>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${board1List}">
				<tr>
					<td>${b.bd1No}</td>
					<td><a href="/board1Detail/${b.bd1No}">${b.bd1Title}</a></td>
					<td>${b.bd1Writer}</td>
					<td>${b.bd1Date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">홈으로</a>
</body>
</html>