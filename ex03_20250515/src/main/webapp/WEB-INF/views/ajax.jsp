<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<button onclick="f1()">GET $Ajax</button><br>
	<p id="demo1"></p>
	<hr>
	<button onclick="f1_2()">GET $Ajax</button><br>
	<p id="demo1-2"></p>
	<hr>
	<button onclick="f2()">POST $Ajax</button><br>
	<p id="demo2"></p>
	<script>
		function f1(){
			$.ajax({
				url: '/api/data', 
				type: 'GET',
				success: function(response){
					console.log("성공: "+response);
					$('#demo1').html(response);
				},
				error: function(xhr){
					console.error("실패: "+xhr);
				}
			});
			
		}
		function f1_2(){
			$.ajax({
				url: '/api/data1?name=James&age=5', 
				type: 'GET',
				success: function(response){
					console.log("성공: "+response);
					$('#demo1-2').html(response);
				},
				error: function(xhr){
					console.error("실패: "+xhr);
				}
			});
			
		}
		
		
		
		
		function f2(){
			$.ajax({
				url: '/api/post',
				type:  'POST',
				contentType: 'application/json'	,
				data: 	JSON.stringify({
					name: '홍길동',
					age: 30
				}),
				success: function(response){
					console.log("POST 성공:"+response);
					$('#demo2').html(response);
				}	,
				error: function(xhr){
					console.error("POST 실패: "+ xhr);
				}
			});	
		}
		
		
		
	</script>
</body>
</html>