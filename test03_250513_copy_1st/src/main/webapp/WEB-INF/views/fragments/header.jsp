<%@page import="com.example.test03.dto.MemberDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
	MemberDTO loginInfo = (MemberDTO)session.getAttribute("loginInfo");
%>

<style>
	.navbar {
		background-color: #333;
		padding: 10px;
		color: white;
		font-family: Arial, sans-serif;
	}

	.navbar h3 {
		margin: 0 0 10px 0;
		color: #ffd700;
	}

	.navbar ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
		display: flex;
		gap: 15px;
	}

	.navbar li {
		display: inline;
	}

	.navbar a {
		color: white;
		text-decoration: none;
		padding: 6px 12px;
		border-radius: 4px;
		transition: background-color 0.2s ease;
	}

	.navbar a:hover {
		background-color: #555;
	}

	.separator {
		border-top: 1px solid #ccc;
		margin: 10px 0;
	}
</style>

<div class="navbar">
	<!-- 로그인 상태 출력 -->
	<c:if test="${not empty loginInfo}">
		<h3>${loginInfo.name}님, 환영합니다.</h3>
		<ul>
			<li><a href="#">마이페이지</a></li>
			<li><a href="/logOut">로그아웃</a></li>
		</ul>
	</c:if>
	<c:if test="${empty loginInfo}">
		<ul>
			<li><a href="/toLogin">로그인</a></li>
			<li><a href="/toJoin">회원가입하기</a></li>
		</ul>
	</c:if>

	<div class="separator"></div>

	<!-- 공통 메뉴 -->
	<ul>
		<li><a href="/toShowMovie">🎬 영화 안내</a></li>
		<li><a href="/toBoard1">📢 공지사항</a></li>
		<li><a href="#">❓ QnA</a></li>
		<li><a href="/toEvent">🎁 이벤트</a></li>
		<li><a href="/">✔홈으로</a></li>
	</ul>
</div>
