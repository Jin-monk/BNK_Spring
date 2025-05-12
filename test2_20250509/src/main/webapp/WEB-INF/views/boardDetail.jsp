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
					<th><input type="text" name="bno" id="checkBno" value="${board.bno }" readonly></th>
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
					<th><input type="text" name="writer" value="${board.writer }" readonly></th>
				</tr>
				<tr>
					<th>regdate</th>
					<th><input type="text" name="regdate" value="${board.regdate }"></th>
				</tr>
				<tr>
					<th colspan=2><input type="submit" value="수정"><input type="button" value="삭제" onclick="boardDelete()"></th>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<h4>댓글</h4>
	<form action="/writeCommnet" method="GET">
		작성자: <input type="text" name="writer" value="${loginInfo.id }" readonly><br>
		내용: <textarea name="content"></textarea>
		test: <input type="text" placeholder="${board.bno }">
		<input type="hidden" value="${board.bno }">
		<input type="submit" value="댓글작성">
	</form>
	<script>
	
	function boardDelete(){
		const paramBno = document.getElementById("checkBno");
		console.log(paramBno.value);
		location.href = "/delete/" + paramBno.value;
			
	}
	</script>
</body>
</html>