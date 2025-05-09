<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardUpdate" method="GET">
		<table border ="1">
			<thead>
				<tr>
					<th>항목</th>
					<th>입력란</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>bno</th>
					<th><input type="text" name="bno" value="${board.bno }" readonly></th>
				</tr>
				<tr>
					<th>title</th>
					<th><input type="text" name="title" value="${board.title }"></th>
				</tr>
				<tr>
					<th>content</th>
					<th><input type="text" name="content" value="${board.content }"></th>
				</tr>
				<tr>
					<th>writer</th>
					<th><input type="text" name="writer" value="${board.writer }"></th>
				</tr>
				<tr>
					<th>regdate</th>
					<th><input type="text" name="regdate" value="${board.regdate }"></th>
				</tr>
				<tr>
					<th colspan=2><input type="submit" value="수정"><button onclick="boardDelete()" value="삭제">삭제</button></th>
				</tr>
			</tbody>
		</table>
	</form>
	
	<script>
	function boardDelete(){
		const paramBno = document.querySelector("input[name=bno]");
		location.href = "/delete/" + paramBno.value;
			
	}
	</script>
</body>
</html>