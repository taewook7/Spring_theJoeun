<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jQuery Test</title>
	<style>
	#divSmallBox {
		width:				300px;
		height:				400px;
		background-color:	magenta;
		border:				8px dotted blue;
		margin-top:			30px;
	}
	</style>
</head>
<body>
	<h1>jQuery Test</h1><hr>

	<p id="pid">지금부터 <span>제이쿼리를 다함께</span>공부하겠습니다.</p><br>
	마우스를 가지고 글자를 클릭해보십시요.
	
	<hr>
	<ul>
		<li>첫번째 아이템</li>
		<li>두번째 아이템</li>
		<li>세번째 아이템</li>
	</ul>
	<button>아이템은 몇개?</button>
	<p id="li_length"></p>
	
	<hr>
	<form>
		<input type="checkbox" name="study" value="html"><span>HTML</span><br>
		<input type="checkbox" name="study" value="java"><span>SPRING</span><br>
		<input type="checkbox" name="study" value="python"><span>PYTHON</span><br>
		<input type="checkbox" name="study" value="spring"><span>SPRING</span><br>
	</form>
	<button id="checkBtn">확인</button>
	
	<hr>
	<h1>마우스 이벤트</h1>
	<button id="mEvent">마우스이벤트</button>
	<p id="mtext"></p>
	
	<hr>
	<h1>요소을 표시하기, 숨기기</h1>
	<button id="showBtn">요소 보이기</button>
	<button id="hideBtn">요소 숨기기</button>
	<button id="toggleBtn">토클 버튼</button>
	<p>CSS의 속성값을 변경하여 사라지게 하겠습니다.</p>
	<p id="shtext">이 문장을 사라지게 하거나 나타나게 할께요.</p>
	
	<hr>
	<h1>슬라이드</h1>
	<button id="slideUpBtn">UP</button>
	<button id="slideDnBtn">DOWN</button>
	<button id="slideTgBtn">TOGGLE</button>
	<div id="divSmallBox"></div>
	
	<hr>
	<h1>이펙트 효과 주기, 정지</h1>
	<p></p>
	<button id="toggleBtn2">이펙트 시작</button>
	<button id="stopBtn2">이펙트 정지</button>
	<button id="finishBtn2">이펙트 중지</button>
	
<!-- JQuery -->  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
	
	$("p").on("click", function() { // <p>요소를 선택
		$("span").css("fontSize", "38px");	// <span>요소의 css를 수정
		$("#pid").css("border", "3px solid red");
	});

	var items = $("li");
	$("button").on("click", function() {
		$("#li_length").text("<li>요소의 갯수는 : " + items.length + "입니다.");
	});

	$("#checkBtn").on("click", function() {
		$(":checked").next().text("이 요소가 체크되어 있는 요소입니다.");
	});

	$("#mEvent").on({
		mouseenter: function() { //마우스가 버튼 위로 올라갔을 때
			$("#mtext").append("마우스가 버튼 위로 올라갔습니다.");
		},
		click: function() { //마우스로 버튼을 클릭한 경우
			$("#mtext").append("버튼을 클릭하였습니다.");
		},
		mouseleave: function() { //마우스가 버튼을 벗어난 경우
			$("#mtext").append("마우스가 버튼 위에서 벗어났습니다.");
		}
	});

	$("#showBtn").on("click", function() {
		$("#shtext").show(3000); //3000 => 3초
	});
	$("#hideBtn").on("click", function() {
		$("#shtext").hide();
	});
	$("#toggleBtn").on("click", function() {
		$("#shtext").toggle("slow");
	});

	$("#slideUpBtn").on("click", function() {
		$("#divSmallBox").slideUp();
	});
	$("#slideDnBtn").on("click", function() {
		$("#divSmallBox").slideDown();
	});
	$("#slideTgBtn").on("click", function() {
		$("#divSmallBox").slideToggle("fast");
	});

	$("#toggleBtn2").on("click", function() {
		$("#divSmallBox").slideToggle(3000);
	});
	$("#stopBtn2").on("click", function() {
		$("#divSmallBox").stop();
	});
	$("#finishBtn2").on("click", function() {
		$("#divSmallBox").finish();
	});
	
});
</script>




</body>
</html>











