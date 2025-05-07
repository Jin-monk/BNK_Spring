<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page </h1>
	<hr>
	
	<h4>1. Ajax Get 요청</h4>
	<button onclick="getData()">1. Ajax Get 요청 </button>
	<div id="demo1">---------</div>
	<hr>
	
	<h4>2. Ajax Get 요청2-1 (user 정보 요청: JSON 직접 작성)</h4>
	<button onclick="getUserData()">2-1. Ajax Get 요청2-1 </button>
	<div id="demo2_1">---------</div>
	<hr>
	
	<h4>2. Ajax Get 요청2-2 (user 정보 요청: Jackson 라이브러리 활용)</h4>
	<button onclick="getUserData2()">2-2. Ajax Get 요청2-2 </button>
	<div id="demo2_2">---------</div>
	<hr>
	
	<h4>3. Ajax Get 요청 3 (파라미터 보내기)</h4>
	<button onclick="sendParameter()">3. Ajax Get 요청3</button>
	<div id="demo3">-----------</div>
	<hr>
	
	<h4>4. Ajax Get 요청 4 (파라미터 보내기- 패스 이용)</h4>
	<button onclick="sendParameter2()">4. Ajax Get 요청4</button>
	<div id="demo4">-----------</div>
	<hr>
	
	<h4>5. Ajax Get 요청 5 (파라미터 보내기 - DTO 이용)</h4>
	<button onclick="sendParameter3()">5. Ajax Get 요청5</button>
	<div id="demo5">-----------</div>
	<hr>
	
	<h4>6. Ajax POST 요청 1 </h4>
	<button onclick="regData()">1. Ajax Post 요청</button>
	<div id="demo6">-----------</div>
	<hr>
	
	<h4>7. Ajax POST 요청 2 (커맨드객체 사용)</h4>
	<button onclick="regData2()">2. Ajax Post 요청</button>
	<div id="demo7">-----------</div>
	<hr>
	
	<h4>8. Ajax POST 요청 3 (JSON 데이터 전송)</h4>
	<button onclick="regData3()">3. Ajax Post 요청</button>
	<div id="demo8">-----------</div>
	<hr>
	
	<script>
	
		// 1. Ajax Get 요청
		function getData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function () {
				document.getElementById("demo1").innerHTML = xhr.responseText;
			}
			xhr.open('GET',"req1");
			xhr.send();
		}
		
		// 2-1. Ajax Get 요청2 (user 정보 요청: name,age)
		const demo2_1 = document.getElementById("demo2_1");
		function getUserData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function () {
				const obj = JSON.parse( xhr.responseText);
				console.log(obj);
				document.getElementById("demo2_1").innerHTML = "<h3>"+ obj.name + "," + obj.age + "</h3>";
			}
			xhr.open('GET',"req2_1");
			xhr.send();
		}
		
		// 2-2. Ajax Get 요청2-2 (user 정보 요청: Jackson 라이브러리 활용)
		const demo2_2 = document.getElementById("demo2_2");
		function getUserData2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				const obj = JSON.parse( xhr.responseText);
				console.log(obj);
				demo2_2.innerHTML = "<h3>"+ obj.name + "," + obj.age + "</h3>";
			}
			xhr.open('GET',"req2_2");
			xhr.send();
		}
		
		// 3. Ajax Get 요청 3 (파라미터 보내기)
		const demo3 = document.getElementById("demo3");
		function sendParameter(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo3.innerHTML = xhr.responseText;
			}
			xhr.open("GEt","req3?param=aaa");
			xhr.send();
		}
		
		//4. Ajax Get 요청 4 (파라미터 보내기- 패스 이용)
		const demo4 = document.getElementById("demo4");
		function sendParameter2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo4.innerHTML = xhr.responseText;
			}
			xhr.open("GET","req4/Jane/33");
			xhr.send();
			
		}
		
		//5. Ajax Get 요청 5 (파라미터 보내기 - DTO 이용)
		const demo5 = document.getElementById("demo5");
		function sendParameter3 (){
			const xhr = new XMLHttpRequest();
			xhr.onload = function (){
				demo5.innerHTML = xhr.responseText;
			}
			xhr.open("GET","req5?name=Ann&&age=33");
			xhr.send();
		}
		
		//6. Ajax Post 요청 1
		const demo6 = document.getElementById("demo6");
		function regData(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo6.innerHTML = xhr.responseText;
			}
			xhr.open("POST","req6");
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("name=Jackson&&age=29");
		}
		
		//7. Ajax Post 요청 2
		const demo7 = document.getElementById("demo7");
		function regData2(){
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo7.innerHTML = xhr.responseText;
			}
			xhr.open("POST","req7");
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("name=Jackson&&age=29");
		}
		
		//8. Ajax Post 요청 3
		const demo8 = document.getElementById("demo8");
		function regData3(){
			const obj = {
					name: "Hong",
					age : 33 
			};
			const jsonStr = JSON.stringify(obj);
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				demo8.innerHTML = xhr.responseText;
			}
			xhr.open("POST","req8");
			xhr.setRequestHeader("Content-type", "application/json");
			xhr.send(jsonStr);
		}
		
		
	</script>
	
</body>
</html>