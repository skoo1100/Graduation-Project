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
</style>

<%@include file="../template/header.jsp"%>







<div class="container text-center text-center">
            <form class="form-horizontal" role="form"action="register_ok.do" method="post">
              <center>  <h2>회원 가입</h2>  </center>
			    
	
				<div class="form-group" >
                    <label for="lastName" class="col-sm-5 control-label">이름</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" name="Sname" placeholder="Full Name" class="form-control" autofocus>
                       
                    </div>
                </div>
				<div class="form-group">
                    <label for="ID Number" class="col-sm-5 control-label">학번</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" name="Sid" placeholder="ID NUMBER" class="form-control" autofocus>
                       
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="password" class="col-sm-5 control-label">비밀번호</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="Spw" placeholder="Password" class="form-control">
                    </div>
                </div>
                     
                <div class="form-group">
                    <label for="password" class="col-sm-5 control-label">학과</label>
                    <div class="col-sm-4">
                        <input type="text" id="password" name="Smajor" placeholder="major" class="form-control">
                    </div>
                </div>
                     
                <div class="form-group">
                    <label for="password" class="col-sm-5 control-label">전화번호</label>
                    <div class="col-sm-4">
                        <input type="text" id="password" name="Snum" placeholder="number" class="form-control">
                    </div>
                </div>
                          
                <div class="form-group">
                    <label for="password" class="col-sm-5 control-label">학년</label>
                    <div class="col-sm-4">
                        <input type="text" id="password" name="Sgrade" placeholder="grade" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-5 col-sm-offset-3">
                        <button type="submit" class="btn btn-info">Submit</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
		
	
	






<div class="footer">
<%@include file="../template/footer.jsp"%></div>
</body>
</html>