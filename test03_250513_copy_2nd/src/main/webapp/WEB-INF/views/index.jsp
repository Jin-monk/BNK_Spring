<%@page import="org.springframework.ui.Model"%>
<%@page import="com.example.test03.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%
		MemberDTO loginInfo = (MemberDTO)session.getAttribute("loginInfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="fragments/header.jsp"></jsp:include>
	<hr>
		
	<ul>
		<c:if test="${not empty loginInfo}">
			 <h3 >${loginInfo.name }님, 환영합니다.</h3>
			<li><a href="">마이페이지</a></li>
			<li><a href="/logOut">로그아웃</a></li>
		</c:if>
		<c:if test="${empty loginInfo}">
			<li><a href="/toLogin">로그인</a></li>
			<li><a href="/toJoin">회원가입하기</a></li>
		</c:if>

	</ul>
	<hr>
	<ul>
		<li><a href="/toShowMovie">영화 안내</a></li>
		<li><a href="/toBoard1">공지사항</a></li>
		<li><a href="">QnA</a></li>
		<li><a href="toEvent">이벤트</a></li>
	</ul>
	<script>
		if( "${loginFail}" !== ""){
			alert("${loginFail}");
		}
	</script>
</body>
</html>