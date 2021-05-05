<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
<link rel="stylesheet" href="resources/css/template.css">
</head>
<body class="body">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>



<style type="text/css">


.jumbotron{
text-shadow:black 0.2em 0.2em 0.2em;
color:white;
height:300px;
background-image:url('resources/images/babyele.JPG');
background-size:70% 100%;
background-repeat : no-repeat;
background-position:center;

}

#testdiv{
width:100%;
height:500px;
}

</style>
<%@include file="header.jsp"%>
<div class="container">
	<div class="jumbotron" >

	<c:if test="${empty Sid }">
	<center><div><h2>로그인 이후 화면이 보입니다.</h2></div><center>
	</c:if>
	
	<c:if test="${not empty Sid }">

	<c:if test="${empty bank }">
	<p class="text-center">조회 할 수 있는 계좌가 없습니다. 소속 과 학생회에 문의 하세요</p>
	</c:if>
	<c:if test="${not empty bank }">
	<h1 class="text-center">${bank.getBname() }</h1>
	<p class="text-center">${bank.getBrest() }</p>	
	<c:if test="${Siscouncil>='1' }">
	<center><button onclick="location='/web/purchase.do'">구매 내역 등록하기</button></center>
	
	</c:if>
	<center><button onclick="location='/web/blistall.do'">회비 입출 내역 보기</button></center>
	</c:if>

	
	</c:if>
	</div>
	


<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>
			&nbsp;&nbsp;최신 강의 목록</h3>	
		</div>
		<div class="panel-body">
			<div class="media"><!-- 사진이나 동영상을 담는 클래스 -->
			<!-- 	<div class="media-left">
					<a href="lecture.jsp?lectureName=C">
					<img class="media-object" src="images/apple.png" alt="c언어 강의 이미지">
					</a>
				</div> -->
				<div class="media-body">
					<h4 class="media-heading">
					 <a href="lecture.jsp?lectureName=C">
					 Top 10 검색어&nbsp;
					 <span class="badge">Ranking Top 10!!</span></a></h4>
					 
					 
				
				  <c:if test="${!empty ranking }">
   <c:forEach var= "b" items="${ranking }">
   <tr>
    <th>${b }</th><br>

  </tr></c:forEach></c:if>
  
				</div>
			 </div><hr>
			 <div class="media">
				<!--  <div class="media-left">
					<a href="lecture.jsp?lectureName=Java"><img class="media-object" src="images/apple.png" alt="자바 강의 이미지"></a>
				</div>-->	
				<div class="media-body">
					<h4 class="media-heading"> 
					<a href="lecture.jsp?lectureName=Java">취업 뉴스&nbsp;<span class="badge">News</span></a></h4>
				
	<c:if test="${!empty news }">
   <c:forEach var= "b" items="${news }">
   <tr>
    <th>${b }</th><br>

  </tr></c:forEach></c:if>
				
				
				</div>
			 </div><hr>
			 <div class="media">
				<div class="media-left">
					<a href="lecture.jsp?lectureName=Android"><img class="media-object" src="images/apple.png" alt="안드로이드 강의 이미지"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading"> <a href="lecture.jsp?lectureName=Android">안드로이드&nbsp;<span class="badge">New</span></a></h4>
				안드로이드는 db연결이 어려우어요오ㅗ오오
				</div>
			 </div>
		</div>
	
	</div>
		






	
</div>


<div class="footer">
<%@include file="footer.jsp"%>
</div>
</body>
</html>