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
	
<div id="testdiv">
<iframe src="https://www.jobkorea.co.kr/" seamless="yes"  
width="50%" height="100%"
allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" ></iframe></div>

<iframe width="560" height="315" src="https://www.youtube.com/embed/iDjQSdN_ig8"
 frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<script>   
function f(){
alert("?");
    $.ajax({
        url: "/web/serialize",
        type: "POST",
        data: $("#frm").serialize(),
        success: function(data){
        	console.log(data.toString());
            $('#result').text(data);
        },
        error: function(){
            alert("serialize err");
        }
    });
}</script>
<form id="frm">
    name : <input type="text" name="smajor" id="name"><br>
    age : <input type="text" name="sid" id="age">
</form>
    <button id="btn2" onclick="f()">serialize</button>
    <div id="result"></div>




<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>
			&nbsp;&nbsp;�ֽ� ���� ���</h3>	
		</div>
		<div class="panel-body">
			<div class="media"><!-- �����̳� �������� ��� Ŭ���� -->
				<div class="media-left">
					<a href="lecture.jsp?lectureName=C"><img class="media-object" src="images/apple.png" alt="c��� ���� �̹���"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading"> <a href="lecture.jsp?lectureName=C">c��� ���� ����&nbsp;<span class="badge">New</span></a></h4>
				c���� �����Ͱ� ��ƽ��ϴپƾƾƾƾƤ���������
				</div>
			 </div><hr>
			 <div class="media">
				<div class="media-left">
					<a href="lecture.jsp?lectureName=Java"><img class="media-object" src="images/apple.png" alt="�ڹ� ���� �̹���"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading"> <a href="lecture.jsp?lectureName=Java">�ڹ� ���� ����&nbsp;<span class="badge">New</span></a></h4>
				�ڹٴ� ��Ƽ �����尡 ��ƽ��ϴپƾƾƾƾƤ���������
				</div>
			 </div><hr>
			 <div class="media">
				<div class="media-left">
					<a href="lecture.jsp?lectureName=Android"><img class="media-object" src="images/apple.png" alt="�ȵ���̵� ���� �̹���"></a>
				</div>
				<div class="media-body">
					<h4 class="media-heading"> <a href="lecture.jsp?lectureName=Android">�ȵ���̵�&nbsp;<span class="badge">New</span></a></h4>
				�ȵ���̵�� db������ ���������ǿ���
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