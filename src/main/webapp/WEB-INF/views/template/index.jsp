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
	<center><div><h2>�α��� ���� ȭ���� ���Դϴ�.</h2></div><center>
	</c:if>
	
	<c:if test="${not empty Sid }">

	<c:if test="${empty bank }">
	<p class="text-center">��ȸ �� �� �ִ� ���°� �����ϴ�. �Ҽ� �� �л�ȸ�� ���� �ϼ���</p>
	</c:if>
	<c:if test="${not empty bank }">
	<h1 class="text-center">${bank.getBname() }</h1>
	<p class="text-center">${bank.getBrest() }</p>	
	<c:if test="${Siscouncil>='1' }">
	<center><button onclick="location='/web/purchase.do'">���� ���� ����ϱ�</button></center>
	
	</c:if>
	<center><button onclick="location='/web/blistall.do'">ȸ�� ���� ���� ����</button></center>
	</c:if>

	
	</c:if>
	</div>
	

<div>

	<div id="header_input">
		<div id="input_div">

		<form accept-charset="UTF-8" role="form" action="search.do" method="get">
			<input class="input_company" placeholder=" �˻��� �Է�" />

			<select class="input_potal">
				<option>��ü (��Ż ����)</option>
				<option>Job-korea</option>
				<option>Saram-in</option>
				<option>Indeed</option>
			</select>

			<select class="input_location">
				<option selected>��ü(��� ����)</option>
				<option>����</option>
				<option>���</option>
				<option>��õ</option>
				<option>�λ�</option>
				<option>�뱸</option>
				<option>����</option>
				<option>����</option>
				<option>���</option>
				<option>����</option>
				<option>����</option>
				<option>�泲</option>
				<option>���</option>
				<option>����</option>
				<option>����</option>
				<option>�泲</option>
				<option>���</option>
				<option>����</option>
			</select>

			<select class="input_jobtype">
				<option selected>��ü(�ٹ� ����)</option>
				<option>������</option>
				<option>�����</option>
				<option>����</option>
				<option>�Ƹ�����Ʈ</option>
				<option>����Ư��</option>
			</select>

			<input type="submit" value="�˻�" class="search_btn">
				
			</form>
		</div>
	</div>
	</div>
<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>
			�˻� ��� <span class="glyphicon glyphicon-ok"></span>
			</h3>	
		</div>
		<div class="panel-body">
			<div class="media"><!-- �����̳� �������� ��� Ŭ���� -->
			<!-- 	<div class="media-left">
					<a href="lecture.jsp?lectureName=C">
					<img class="media-object" src="images/apple.png" alt="c��� ���� �̹���">
					</a>
				</div> -->
				<div class="media-body">
					<h4 class="media-heading">
					 <a href="lecture.jsp?lectureName=C">
					 Top 10 �˻���&nbsp;
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
					<a href="lecture.jsp?lectureName=Java"><img class="media-object" src="images/apple.png" alt="�ڹ� ���� �̹���"></a>
				</div>-->	
				<div class="media-body">
					<h4 class="media-heading"> 
					<a href="lecture.jsp?lectureName=Java">��� ����&nbsp;<span class="badge">News</span></a></h4>
				
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