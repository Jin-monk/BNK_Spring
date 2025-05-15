<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table border ="1">
		<thead>	
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${board1.bd1No}</td>
					<td>${board1.bd1Title}</td>
					<td>${board1.bd1Content}</td>
					<td>${board1.bd1Writer}</td>
					<td>${board1.bd1Date} </td>
				</tr>
		</tbody>
	</table>
	<a href="/">홈으로</a>
</body>
</html>