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
	<a href="list">list 페이지 가기</a>
	<br>
	<hr>
	<button onclick="showJoinF()">회원가입</button>
	<button onclick="showLoginF()">로그인</button>
	<button onclick="showMemberList()">회원정보보기</button>
	<a href="toJoin">회원가입</a>
	<a href="toLogin">로그인 </a>
	<hr>
	<div id="content"></div>	
	
	
	<script>
		//Ajax 출력부분
		const content = document.getElementById("content");
		let isCheckId = false;
		let isCheckPw = false;
		
		//=======================================================
		//회원가입 폼 Ajax
		window.showJoinF = function(){
			isCheckId = false;
			isCheckPw = false;
			const xhr = new XMLHttpRequest();
			xhr.open("GET","joinForm");
			xhr.onload = function(){
				content.innerHTML = xhr.responseText;
				
				// submit 전 최종 확인
				document.getElementById("frm").addEventListener("submit",lastCheck); //submit이 오면 lastCheck 함수 실행 
				
			}
			xhr.send();
		}
		
		//=======================================================
		//아이디 유효성검사
		window.checkIdF = function () {
			isCheckId = false;
			const form = document.forms["frm"];
			const inputId = form.id.value.trim();
			const resEl = document.getElementById("checkIdRes");
			//아이디 공란확인
			if (inputId === "") {
				alert("ID 입력하세요.")
				form.id.focus();
				isCheckId = false;
				return;
			}

			//아이디 중복확인
			const xhr = new XMLHttpRequest();
			xhr.open("POST", "checkId", true);
			xhr.setRequestHeader("Content-type" , "application/x-www-form-urlencoded");
			xhr.send("id="+inputId);
			
			xhr.onload = function(){
				const result  = xhr.responseText;
				resEl.innerText = result ;
				
				if(result.includes("이미 사용 중인 ID입니다.")){
					isCheckId = false;
					resEl.style.color= "red";
				}else{
					isCheckId = true;
					resEl.style.color= "green";
				}
			}
		}
		
		window.checkPwF = function() {
			//비밀번호 동일 확인
			const form = document.forms["frm"];
			const pw = form.pw.value.trim();
			const checkPw = form.checkPw.value.trim();
			const checkPwRes = document.getElementById("checkPwRes");

			if (pw === "" || checkPw === "") {
				alert("비밀번호를 입력하세요.");
				form.pw.focus();
				checkPwRes.innerText = "비밀번호를 입력하세요.";
				checkPwRes.style.color = "red";
				isCheckPw = false;
				return;
			} else if (pw !== checkPw) {
				checkPwRes.innerText = "비밀번호가 일치하지 않습니다.";
				checkPwRes.style.color = "red";
				isCheckPw = false;
				return;
			} else if (pw === checkPw) {
				checkPwRes.innerText = "비밀번호가 일치합니다.";
				checkPwRes.style.color = "green";
				isCheckPw = true;
			}
		}
		//=======================================================
		// 최종 유효성검사
		window.lastCheck = function(event){
			const form = document.forms["frm"];
			const nameId = document.getElementById("nameId");
			const phoneId = document.getElementById("phoneId");
			
			event.preventDefault(); // submit 중지
			if(isCheckId === false || isCheckPw === false){
				alert("아이디 중복 확인 또는 비밀번호 확인이 필요합니다.");
				return;
			}
			if(nameId.value.trim() ===""){
				alert("이름을 입력하세요.")
				return;
			}
			if(phoneId.value.trim() ===""){
				alert("휴대폰 번호를 입력하세요.")
				return;
			}
			form.submit();
		}
		//=======================================================
		//로그인 폼 Ajax
		function showLoginF(){
			const xhr = new XMLHttpRequest();
			xhr.open("GET","loginForm");
			xhr.onload = function(){
				content.innerHTML = xhr.responseText;
			}
			xhr.send()
		}
		//=======================================================
		// 회원 목록 Ajax
		 function showMemberList(){
			const xhr = new XMLHttpRequest();
			xhr.open("GET","showMemberList");
			xhr.onload = function(){
				xhr.responseText;
			}
			xhr.send();
		}
	</script>
</body>
</html>