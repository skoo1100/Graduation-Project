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
				&nbsp;&nbsp;�˻� ���&nbsp;
				
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
							placeholder=" �˻��� �Է�" /> <select class="input_potal"
							name="sitetype">
			
							<option>Job-korea</option>
							<option>Saram-in</option>
							<option>Indeed</option>
						</select> <select class="input_location" name="location">
			
							<option selected>����</option>
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
						</select> <select class="input_jobtype" name="jobtype">
			
							<option selected>������</option>
							<option>�����</option>
							<option>����</option>
							<option>�Ƹ�����Ʈ</option>
							<option>����Ư��</option>

						</select><select class="input_pay" name="pay">
							
							<option selected>2000���� �̻�</option>
							<option>3000���� �̻�</option>
							<option>4000���� �̻�</option>
							<option>5000���� �̻�</option>

						</select> <input type="submit" value="�˻�" class="search_btn">

					</form>
				</div>
			</div></td>

  			<td colspan="5" align="right"> �� ���� ��� : <b> ${count} </b>��

  			</tr>
			<tr>
			<th>Title</th>	<th>ȸ���</th>	
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