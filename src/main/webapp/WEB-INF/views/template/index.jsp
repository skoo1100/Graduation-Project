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
	

<div>

	<div id="header_input">
		<div id="input_div">

		<form accept-charset="UTF-8" role="form" action="search.do" method="get">
			<input class="input_company" placeholder=" 검색어 입력" />

			<select class="input_potal">
				<option>전체 (포탈 선택)</option>
				<option>Job-korea</option>
				<option>Saram-in</option>
				<option>Indeed</option>
			</select>

			<select class="input_location">
				<option selected>전체(희망 지역)</option>
				<option>서울</option>
				<option>경기</option>
				<option>인천</option>
				<option>부산</option>
				<option>대구</option>
				<option>광주</option>
				<option>대전</option>
				<option>울산</option>
				<option>세종</option>
				<option>강원</option>
				<option>경남</option>
				<option>경북</option>
				<option>전남</option>
				<option>전북</option>
				<option>충남</option>
				<option>충북</option>
				<option>제주</option>
			</select>

			<select class="input_jobtype">
				<option selected>전체(근무 형태)</option>
				<option>정규직</option>
				<option>계약직</option>
				<option>인턴</option>
				<option>아르바이트</option>
				<option>병역특례</option>
			</select>

			<input type="submit" value="검색" class="search_btn">
				
			</form>
		</div>
	</div>
	</div>
<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>
			검색 결과 <span class="glyphicon glyphicon-ok"></span>
			</h3>	
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
  
    <th><a href="${b[0] }">${b[1] }</a></th><br>

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
    <th><a href="https://www.jobkorea.co.kr${b[0] }">${b[1] }</a></th><br>

  </tr></c:forEach></c:if>
				
				
				</div>
			 </div><hr>

		</div>
	
	</div>
		





	
</div>

<div style="height:200px"></div>

<div class="footer">
<%@include file="footer.jsp"%>
</div>
</body>
</html>