<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	
	<c:if test="${empty loginInfo }">
		<a href="/login">로그인 하러가기</a><br>
	</c:if>
	<c:if test="${not empty loginInfo }">
		<h3>${loginInfo }님, 사용 중 ..</h3><br>
		<a href="/logout">로그아웃 하러가기</a><br>
	</c:if>
		<a href="/sessionTest">Session 테스트하러가기</a>

</body>
</html>