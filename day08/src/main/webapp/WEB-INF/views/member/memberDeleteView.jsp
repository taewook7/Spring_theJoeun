<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/topmenu.jsp" %>

<div class="container-fluid"> 
	<form class="form-horizontal" method="post" action="/member/memberDelete">
		<div class="form-group">
			<div class="col-sm-off-2 col-sm-6">
				<h2 align="center">회원 탈퇴</h2>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">아이디</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="userid" name="userid" 
				value="${member.userid}" readonly="readonly" maxlength="16" placeholder="Enter ID">
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="control-label col-sm-2">비밀번호</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="passwd" name="passwd" 
					maxlength="16" placeholder="Enter Password">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">이 름</label>		
			<div class="col-sm-3">
				<input type="text" class="form-control" id="name" name="name" 
				value="${member.name}" maxlength="10" placeholder="Enter name">
			</div>
		</div>
		
		<div class="form group">
			<div class="col-sm-offset-2 col-sm-4">
				<button class="btn btn-success" type="submit" id="submit">회원탈퇴</button>
				<button class="cancle btn btn-danger" type="button">취소</button>
			</div>
		</div>		
	</form>
<!-- 	회원탈퇴 버튼을 눌렀는데, 비밀번호가 맞지 않으면 메시지를 보여준다. -->
	<div class="col-sm-offset-2 col-sm-8">
		<c:if test="${msg == false}">
			<p style="color:red; background: #dcdcdc;"><h3>비밀번호가 맞지 않습니다.</h3></p>
		</c:if>
	</div>
	
</div>


<%@ include file="../include/footer.jsp" %>


<script>
$(document).ready(function() {
	//회원탈퇴 버튼을 누른 경우
	$("#submit").on("click",function() {
		if($("#passwd").val() == "")
			alert("비밀번호를 입력해주세요");
			$("#passwd").focus();
			return false;
	}
		if($("#name").val() == "") {
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		});

	$(".cancle").on("click",function() {
		location.href="/member/login";
	});
});
</script>
</body>
</html>












