<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	
	<div>${errorMsg }</div>
	<div>${errorMsg2 }</div>
	
	<form action="/board/writeBoard" method="GET">
		제목: <input type="text" name="title"><br>
		내용: <textarea name="content"></textarea><br>
		작성자: <input type="text" name="writer"><br>
		<input type="submit" value="작성">
	</form>
	<hr>
	<a href="/board/showBoard">게시물 확인하기</a>
</body>
</html>