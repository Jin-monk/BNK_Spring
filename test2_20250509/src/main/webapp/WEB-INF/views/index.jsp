<%@page import="com.example.test2.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MemberDTO member= (MemberDTO)session.getAttribute("loginInfo");
    	String loginRes= (String)session.getAttribute("loginError");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>

	<a href="toJoin">회원가입하기</a><br>
	<a href="toLogin">로그인하기</a><br>
	<a href="showMember">회원정보보기</a><br>
	<a href="toOnlyMember">회원전용 게시판</a><br>
	<hr>
	
</body>
</html>