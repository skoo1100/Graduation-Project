<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
<link rel="stylesheet" href="resources/css/template.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script>
</script>

<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
blockquote{
background:#f9f9f9;
border-left:10px solid #cccccc;
margin: 1.5em 10px;
padding: 0.5em 10px;
quotes: "\201C""\201D""\2018""\2019"
}
blockquote:before{
color:#cccccc;
content:open-quote;
font-size:3em;
line-height:0.1em;
margin-left:0.25em;
vertical-align:-0.4em;
}
blockquote:after{
color:#cccccc;
content:close-quote;
font-size:3em;
line-height:0.1em;
margin-left:0.25em;
vertical-align:-0.4em;
}
</style>
</head>

<body class="body">

<%@include file="./template/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
		<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-tags"></span>
				&nbsp;&nbsp;검색 결과&nbsp;
				
			</h3>
		</div>
	
		<table class="table">
			<thead>
			  <tr>
			  <td><div id="header_input">
				<div id="input_div">

					<form accept-charset="UTF-8" role="form" action="search.do"
						method="get">
						<input type="text" name="searchvalue" class="input_company"
							placeholder=" 검색어 입력" /> <select class="input_potal"
							name="sitetype">
			
							<option>Job-korea</option>
							<option>Saram-in</option>
							<option>Indeed</option>
						</select> <select class="input_location" name="location">
			
							<option selected>서울</option>
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
						</select> <select class="input_jobtype" name="jobtype">
			
							<option selected>정규직</option>
							<option>계약직</option>
							<option>인턴</option>
							<option>아르바이트</option>
							<option>병역특례</option>

						</select><select class="input_pay" name="pay">
							
							<option selected>2000만원 이상</option>
							<option>3000만원 이상</option>
							<option>4000만원 이상</option>
							<option>5000만원 이상</option>

						</select> <input type="submit" value="검색" class="search_btn">

					</form>
				</div>
			</div></td>

  			<td colspan="5" align="right"> 총 내역 목록 : <b> ${count} </b>개

  			</tr>
			<tr>
			<th>Title</th>	<th>회사명</th>	
			</tr>
			</thead>
			<tbody>
	  <c:if test="${!empty result }">
	  
   <c:forEach var= "list" items="${result }">
  
   <tr>
    <th><a href="${list.getUrl() }" target="top">${list.getTitle() }</a></th>
    <th>${list.getCorp() }</th>


    
    
  </tr> 
  </c:forEach>
  </c:if>
  

			</tbody>
	
		</table>

		
		</div></div>
	</div>
</div>
<div style="height:200px"></div>

<div class="footer">
<%@include file="./template/footer.jsp"%></div>
</body>
</html>