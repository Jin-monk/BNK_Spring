<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		text-align: center;
		margin: 0;
		padding: 0;
	}
	
	#headTitle {
		margin: 20px 0px;
		font-size: 35px;
		font-weight: bold;
	}
	
	.container {
		border: 2px solid #cfd8dc;
		max-width: 650px;
		margin: 0 auto 30px auto; /* 중앙 정렬 */
		border-radius: 12px;
		background: #fcfcfc;
		box-shadow: 0 4px 16px rgba(40, 60, 90, 0.08);
		padding: 32px 0 36px 0;
	}
	
	.content {
		margin: 30px 24px;
		padding: 18px 16px;
		background: #f8fafc;
		border-radius: 8px;
		width: auto;
		text-align: left;
		font-size: 17px;
		border: 1px solid #e0e4ea !important; /* 기존 border와 통일 */
	}
	
	.choices {
		margin-top: 20px;
	}
	
	#leftTime {
		font-weight: bold;
		font-size: 22px;
		margin-bottom: 15px;
	}
	/* .userInfo{
				display: grid;
			} */
	#btn {
		width: 100px;
		height: 50px;
		background-color: #qqq;
		margin-bottom: 50px;
	}
	
	.choice2 {
		margin: 5px 0px;
	}
	
	.choice3 {
		margin-bottom: 5px;
	}
	
	.radio {
		margin: 0px 10px;
	}
	
	.userInfo {
		margin: 24px auto 20px auto;
		text-align: center;
	}
	
	.userInfo p {
		margin: 0 0 5px 0;
		padding: 0;
	}
</style>
</head>
<body>
	<p id="headTitle">Exam Page</p>
	<p id="leftTime">--</p>
	<form action="/checkResult" method="POST">
	<input type="hidden" name="testNo" value="${tester.testNo}">
		<div class="container">
			<div class="userInfo">
				<p>이름: ${tester.name}</p>
				<p>생년월일: ${tester.birthDate }</p>
				<p>성별: ${tester.gender }</p>
			</div>
			<div class="title">
				<div class="content" style="border: 1px solid">
					1. Spring MVC에서 Controller 클래스에 주로 사용되는 어노테이션은 무엇인가?
					<div class="choices">
						<div class="choice1">
							<input type="radio" name="q1Choice" value="1" class="radio" />@Controller
						</div>
						<div class="choice2">
							<input type="radio" name="q1Choice" value="2" class="radio" />@Service
						</div>
						<div class="choice3">
							<input type="radio" name="q1Choice" value="3" class="radio" />@Mapper
						</div>
						<div class="choice4">
							<input type="radio" name="q1Choice" value="4" class="radio" />@Control
						</div>
					</div>
				</div>


				<div class="content" style="border: 1px solid">
					2. 아래 중 JavaScript 상수 선언 방법으로 올바른 것은 무엇인가?
					<div class="choices">
						<div class="choice1">
							<input type="radio" name="q2Choice" value="1" class="radio" />const
							num = 10;
						</div>
						<div class="choice2">
							<input type="radio" name="q2Choice" value="2" class="radio" />let
							num == 10;
						</div>
						<div class="choice3">
							<input type="radio" name="q2Choice" value="3" class="radio" />var
							num = 10;
						</div>
						<div class="choice4">
							<input type="radio" name="q2Choice" value="4" class="radio" />const
							num == 10;
						</div>
					</div>
				</div>



				<div class="content" style="border: 1px solid">
					3. jQuery로 id가 “btn”인 버튼을 클릭했을 때 실행되는 이벤트 등록 방법으로 옳은 것은?
					<div class="choices">
						<div class="choice1">
							<input type="radio" name="q3Choice" value="1" class="radio" />$('#btn').on('click',
							function() { /* ... */ });
						</div>
						<div class="choice2">
							<input type="radio" name="q3Choice" value="2" class="radio" />$('#btn').click()
							= function() { /* ... */ };
						</div>
						<div class="choice3">
							<input type="radio" name="q3Choice" value="3" class="radio" />$('#btn').addEventListener('click',
							function() { /* ... */ });
						</div>
						<div class="choice4">
							<input type="radio" name="q3Choice" value="4" class="radio" />$('#btn').trigger('click',
							function() { /* ... */ });
						</div>
					</div>
				</div>

				<div class="content" style="border: 1px solid">
					4. 아래 중 Controller → JSP → JavaScript로 데이터를 전달할 때 올바른 설명은 무엇인가?
					<div class="choices">
						<div class="choice1">
							<input type="radio" name="q4Choice" value="1" class="radio" />Controller에서
							setAttribute로 값을 저장하면, JSP에서 EL표기법으로 출력할 수 있다.
						</div>
						<div class="choice2">
							<input type="radio" name="q4Choice" value="2" class="radio" />JSP에서
							선언한 자바 변수를 JavaScript에서 그대로 사용할 수 있다.
						</div>
						<div class="choice3">
							<input type="radio" name="q4Choice" value="3" class="radio" />Controller에서
							저장한 값은 반드시 DB에 저장되어야 JSP에서 읽을 수 있다.
						</div>
						<div class="choice4">
							<input type="radio" name="q4Choice" value="4" class="radio" />JSP에서
							값을 저장하면 Controller에서 그 값을 읽을 수 있다.
						</div>
					</div>
				</div>
				<div class="content" style="border: 1px solid">
					5. jQuery를 이용해 클래스가 “box”인 모든 요소의 배경색을 파란색으로 변경하려고 한다. 올바른 코드로 알맞은
					것은?
					<div class="choices">
						<div class="choice1">
							<input type="radio" name="q5Choice" value="1" class="radio" />$('.box').css('background-color',
							'blue');
						</div>
						<div class="choice2">
							<input type="radio" name="q5Choice" value="2" class="radio" />$('.box').style.backgroundColor
							= 'blue';
						</div>
						<div class="choice3">
							<input type="radio" name="q5Choice" value="3" class="radio" />$('#box').css('background-color',
							'blue');
						</div>
						<div class="choice4">
							<input type="radio" name="q5Choice" value="4" class="radio" />$('box').css('background',
							'blue');
						</div>
					</div>

				</div>
				
				<input type="submit" value="제출" id="btn">
				<!-- <input type="button" value="제출" id="btn" onclick="finishExam()"> -->

			</div>
		</div>
	</form>



	<script>
		console.log("${tester.testNo}");
		const result = confirm("시험을 시작하시겠습니까? ");
		console.log(result);
		if(result === false){
			location.href="/";
			
		}else{
			timer();
		}
		
		let intervalId;
		const leftTime = document.getElementById("leftTime");
			let cnt = 10000	;
		
		function timer (){
			let intervalId = setInterval(()=>{
				cnt --;
				leftTime.innerText = cnt;
				
				if(cnt === 0 ){
					clearInterval(intervalId);
					alert("시험이 끝났습니다.");
					location.href="/examResult"
				}
			},1000);
				
			
		}
		
		
	</script>
</body>
</html>