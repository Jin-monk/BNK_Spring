<%@page import="com.example.test03.dto.MemberDTO"%>
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
	<h2>successReserve</h2>
	<hr>
	<h2>예약 현황</h2>
	예약자 이름: ${loginInfo.name }<br>
	예약자: ${loginInfo.id }<br>
	예약 영화: ${reserveInfo.movTitle}<br> 
	상영날짜: ${reserveInfo.watchDate}<br> 
	인원수: ${reserveInfo.seatCount} <br>
	
	
	<a href="/">홈으로 가기</a>
	<script>
		console.log(${reserveInfo});
	</script>
</body>
</html>	