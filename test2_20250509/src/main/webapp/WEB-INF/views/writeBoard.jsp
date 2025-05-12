<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Write Board Page</h1>
	<hr>
	
	<form action="/writeBoard" method="GET">
		<table border="1" cellpadding="10">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" style="width: 100%"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" style="width: 100%"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${loginInfo.id }" style="width: 100%" readonly></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>