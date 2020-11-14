<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-stikcy-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
											data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/${path}">HOME</a>
		</div>
		<div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판 관리 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${path}/board/list">게시글 목록</a></li>
							<li><a href="${path}/board/insert">게시글 등록</a></li>
							<li class="divider"></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">회원 관리 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<!-- 세션이 있으면 로그아웃을 활성화 시킨다. -->
							<c:if test="${member != null}">
								<li><a href="${path}/member/logout">로그아웃 (Session)</a></li>
								<li><a href="${path}/member/memberUpdateView">회원정보수정 (Session)</a></li>
								<li><a href="${path}/member/memberDeleteView">회원탈퇴 (Session)</a></li>
							</c:if>
							<c:if test="${member == null}">
								<li><a href="${path}/member/address">우편번호</a></li>
								<li><a href="${path}/member/ResponseBodyCheck">ResponseBody</a></li>
								<li><a href="${path}/member/register">회원등록 (Session)</a></li>
								<li><a href="${path}/member/login">로그인 (Session)</a></li>
							</c:if>
							<li class="divider"></li>
							<li><a href="${path}/member/login.do">로그인 (Session)</a></li>
							<li><a href="${path}/member/logout.do">로그아웃 (Session)</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">AJAX <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${path}/ajax/ajax01">ajax01</a></li>
							<li><a href="${path}/board/insert">게시글 등록</a></li>
							<li class="divider"></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>

</nav>

















