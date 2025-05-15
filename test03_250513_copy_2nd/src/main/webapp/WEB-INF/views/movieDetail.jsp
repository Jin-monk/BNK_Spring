<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		table {
			border-collapse: collapse;
			width: 100%;
			margin-bottom: 20px;
		}
		th, td {
			border: 1px solid #999;
			padding: 10px;
		}
	</style>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
	<h2>Movie Detail Page</h2>
	<hr>

	<table>
		<thead>
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>내용</th>
				<th>개봉일</th>
				<th>종료일</th>
				<th>감독</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="${movie.posterUrl}" alt="${movie.movTitle}" width="100">
				</td>
				<td>${movie.movTitle}</td>
				<td>${movie.movContent}</td>
				<td>${movie.openDate}</td>
				<td>${movie.endDate}</td>
				<td>${movie.supervision}</td>
			</tr>
		</tbody>
	</table>
	
	<button type="button" onclick="reserveMovieF()">예매하기</button><br>
	<p id="showReserveForm"></p>
	<%-- <jsp:include page="fragments/showReview.jsp"></jsp:include> --%>
	<button type="button" onclick="showReviewF()">리뷰보기</button><br>
	<a href="/">홈으로 </a>
	<hr>
	<p id="showReview"></p>

	<script>
		const showReview = document.getElementById("showReview");
		
		function showReviewF(){
			const movNo = ${movie.movNo};
			location.href = "/getReview/" + movNo ;
			
		}
		
		function reserveMovieF(){
			const movNo = ${movie.movNo};
			const movTitle = "${movie.movTitle}";
			location.href = "/reserveMovie/"+movNo+"/"+encodeURIComponent(movTitle);
		}
		
		
	</script>
</body>
</html>