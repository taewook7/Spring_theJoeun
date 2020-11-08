<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>

<!-- 부트스트랩의 css부분을 불러들인다.. -->
<%@ include file="../include/header.jsp" %>
</head>
<body>

<!-- 화면 상단의 보여줄 메뉴를 가져온다 -->
<%@ include file="../include/topmenu.jsp" %>

<div class="container">
	<form class="form-horizontal" method="post" action="/member/memberUpdate">
		<div class="form-group">
			<div class="col-sm-2">	</div>
			<div class="col-sm-6"><h2 align="left">회원정보수정</h2></div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">아이디</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="userid" name="userid"
				value="${member.userid}" readonly="readonly" maxlength="16" placeholder="아이디 입력">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">비밀번호</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="passwd" name="passwd"
				maxlength="16" placeholder="비밀번호 입력">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">이 름</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="name" name="name"
				value="${member.name}" maxlength="10" placeholder="이름 입력">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
				<button class="cancle btn btn-danger" type="button">취소</button>
			</div>
		</div>
	</form>
</div>




<!-- jQuery와 부트스트랩의 스크립트를 사용하기 위해서 불러들인다. -->
<%@ include file="../include/footer.jsp" %>

<script>
$(document).ready(function(){
	//취소
	$(".cancle").on("click",function(){
		location.href="/member/login";
	});

	//정보 수정 

	$("#submit".on("click").function() {
		if($("#passwd").val() == "") {
			alert("비밀번호를 입력하셔야 합니다.");
			$("#passwd").focus();
			return false;
		}
		if($("#name").val() == "") {
			alert("이름을 입력하셔야 합니다.");
			$("#name").focus();
			return false;	
		}
	});
});
</script>

</body>
</html>