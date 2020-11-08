<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body>

<%@ include file="../include/topmenu.jsp" %>

<div class="container">
	<form class="form-horizontal" method="post" action="/member/register">
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-6">
				<h2 align="center">회원가입</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">아이디</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="userid" 
					name="userid" maxlength="16" placeholder="Enter ID">
			</div>
			<div class="col-sm-2">
				<button class="idCheck btn btn-info" type="button" id="idCheck" onclick="FidCheck();" value="N">중복검사</button>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">비밀번호</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="passwd" 
					name="passwd" maxlength="16" placeholder="Enter Password">
			</div>		
		</div>	
		<div class="form-group">
			<label class="control-label col-sm-2">이 름</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="name" 
					name="name" maxlength="10" placeholder="Enter Name">
			</div>		
		</div>	
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
			</div>
		</div>
	</form>
</div>


<%@ include file="../include/footer.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	// 취소
	$(".cencle").on("click", function(){
		
		location.href = "/login";
				    
	})

	$("#submit").on("click", function(){
		if($("#userid").val()==""){
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			return false;
		}
		if($("#passwd").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#passwd").focus();
			return false;
		}
		if($("#name").val()==""){
			alert("성명을 입력해주세요.");
			$("#name").focus();
			return false;
		}
	});
})

// 아이디 중복 검사
function FidCheck() {
	$.ajax({
		url: "/member/idCheck", 
		type: "post",
		dataType: "json",
		data: {"userid" : $("#userid").val() },
		success: function(data) {
			if(data == 1 ) {
				alert("이미 사용중인 아이디 입니다.\n다른 아이디를 입력하세요.");
			} else if (data == 0){
				$("#idCheck").attr("value","Y");
				alert("사용 가능한 아이디 입니다.");
			}
		} 
	});	
}
</script>

</body>
</html>









