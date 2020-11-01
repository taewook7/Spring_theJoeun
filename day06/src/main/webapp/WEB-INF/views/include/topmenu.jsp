<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-stijcy-top">
<!-- 	컨테이너로 하면 일반적인 화면에서 일정부분 여백이있고 플루이드는 나머지여백을 쓰는것이다.플루이드가 화면을 좀더 넓게 쓰는 방식임 -->
	<div class="container-fluid">
		<div class="navbar-header">
		
<!-- 		한번 누르면 사라지고 한번누르면 뜨는 토글형태로 쓴다.  -->
<!-- 		눌렀을때 나타내는 것은 타겟을 쓸것이다. -->
		<button type="button" class="navbar-toggle" data-toggle="collapse" 
		data-target="#myNavbar"
		>
		
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		
<!-- 		상대경로에 따라 이동할수있게 패스를 지정한다 -->
		<a class="navbar-brand" href="/${path}">HOME</a>
		</div>	
		
		<div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a class="dropdown-toggle"  data-toggle="dropdown" href=#" >게시판 관리 <span class="caret"></span></a>
						
						<ul class="dropdown-menu">
							<li><a href="${path}/board/list">게시글 목록</a></li> 
							<li><a href="${path}/board/insert">게시글 등록</a></li>
							<li class="divider"></li>
							
						</ul>  
					</li>
					
					
					<li class="dropdown">
						<a class="dropdown-toggle"  data-toggle="dropdown" href=#" >회원 관리 <span class="caret"></span></a>
						
						<ul class="dropdown-menu">
							<li><a href="${path}/member/login.do">로그인 (Session)</a></li> 
							<li><a href="${path}/member/logout.do">로그아웃 (Session)</a></li>
						</ul>  
					</li>
					
				</ul>
			</div>	
		</div>
		
		
	</div>
	
</nav>































