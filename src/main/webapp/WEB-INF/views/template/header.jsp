<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
	<div class="container-fluid">
	
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1" aria-expanded="false"><!-- 크기를 줄였을때 나타나는 버튼 -->
				<span class="sr-only"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.do">Every dongguk</a>
			
			<c:if test="${Siscouncil==10}">
			<a class="navbar-brand" href="userall.do">유저 권한 관리</a>
			<a class="navbar-brand" href="bankall.do">단과별 학생회비 계좌 관리</a>
			
			</c:if>
		</div>	
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"><!-- 네비 중간 대부분을 차지함 -->
			
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"><c:if test="${empty Sid }">login or register</c:if><c:if test="${not empty Sid }">${Sid } 님 환영합니다.</c:if><span class="caret"></span></a>
					<ul class="dropdown-menu">
					
					<c:choose>
					<c:when test="${empty Sid }">
						<li><a href="login_form.do">로그인</a></li>
						<li><a href="register_form.do">회원가입</a></li>	
					</c:when>
					<c:otherwise>
						<li><a href="logout.do">로그아웃</a></li>
						<li><a href="mypage.do">마이페이지(${Sid})</a></li>
						</c:otherwise>
						</c:choose>
					
					</ul>
			
				</li>
			</ul>
			
		</div>
	</div>
</nav>



</body>
</html>