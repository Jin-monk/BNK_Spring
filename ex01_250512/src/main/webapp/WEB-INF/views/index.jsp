<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	
	<button onclick="f1()">getMember 실행 - xhr </button><br>
	<p id="f1Res">----</p>
	
	<button onclick="f2()">getMember 실행 - fetch - GET </button><br>
	<p id="f2Res">----</p>
	
	<button onclick="f3()">getMember 실행 - fetch - POST  </button><br>
	<p id="f3Res">----</p>
	
	<script>
		function f1(){
			const res1 = document.getElementById("f1Res");
			const xhr = new XMLHttpRequest();
			xhr.open('GET','getMember');
			xhr.onload = function(){
				res1.innerText = xhr.responseText;
				
			}
			xhr.send();
		}
		
		function f2(){
			const res2 = document.getElementById("f2Res");
			fetch('getMember',{
				header: 'GET'
			})
			.then(response => response.text())
			.then(data => {
				console.log(data);
				const m1= JSON.parse(data);
				console.log(m1.id);
			} )
			.catch(error => console.error('Error',error));
		}
		
		function f3(){
			const res3 = document.getElementById("f3Res");
			
			fetch('getMember',{
				method : 'POST',
				headers: {
				    "Content-Type": "application/json"
				  },
				body : JSON.parse(m1)
				
			})
			.then(response => response.text())
			.then(data => console.log(data))
			.catch(error => console.error('Error',error));
		}
		
		
	</script>	
</body>
</html>