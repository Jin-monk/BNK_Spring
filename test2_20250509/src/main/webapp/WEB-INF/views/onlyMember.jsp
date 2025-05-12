<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	if(session.getAttribute("loginInfo")==null){
    		response.sendRedirect("/toLogin");
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Only Member Page</h1>
	<hr>
	<a href="/pagination/1">게시물 보기</a><br>
	<a href="toWriteBoard">게시물 작성</a>
</body>
</html>