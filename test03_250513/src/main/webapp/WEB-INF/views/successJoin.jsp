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
	<h2>Success Join Page</h2>
	<hr>
	<h2>${member.name }님, 가입을 환영합니다 ! </h2>
	
	<h4>회원가입 정보</h4>
	ID: ${member.id }<br>
	PW: ${member.pw}<br>
	NAME: ${member.name }<br>
	PHONE: ${member.phone}<br>
	<br>
	<a href="/">홈으로 가기</a>
</body>
</html>