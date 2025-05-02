<%@page import="com.example.demo.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Member> list = (List<Member>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P2 Page</h1>
	<hr>

	<%
		for (Member m : list) {
	%>
	<ul>
		<li>ID: <%=m.getId()%><br></li>
		<li>PW: <%=m.getPw()%><br></li>
		<li>NAME: <%=m.getName()%><br></li>
	</ul>
	<hr>
	<%
		}
	%>
	<a href="test">test 페이지로 가기 </a>
	${member }

</body>
</html>