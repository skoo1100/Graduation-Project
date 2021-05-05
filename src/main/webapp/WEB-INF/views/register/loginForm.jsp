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
body{padding-top:20px;}
</style>

<%@include file="../template/header.jsp"%>

<a id="custom-login-btn" href="javascript:loginWithKakao()">
  <img
    src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
    width="222"
  />
</a>
<p id="token-result"></p>
<script type="text/javascript">
  // 웹 플랫폼 도메인 등 초기화한 앱의 설정이 그대로 적용됩니다.
  // 초기화한 앱에 현재 도메인이 등록되지 않은 경우 에러가 발생합니다.
  Kakao.init('bd58f9efb5e4c0637a9ddfa8c81a3920')
  function loginWithKakao() {
    Kakao.Auth.authorize({
      // 초기화한 앱의 로그인 Redirect URI에 등록된 URI여야 합니다.
      redirectUri: 'http://localhost:8052/web/login_form.do';
    })
  }
  // 아래는 데모를 위한 UI 코드입니다.
  getToken()
  function getToken() {
    const token = getCookie('authorize-access-token')
    if(token) {
      Kakao.Auth.setAccessToken(token)
      document.getElementById('token-result').innerText = 'login success. token: ' + Kakao.Auth.getAccessToken()
    }
  }
  function getCookie(name) {
    const value = "; " + document.cookie;
    const parts = value.split("; " + name + "=");
    if (parts.length === 2) return parts.pop().split(";").shift();
  }
</script>

<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form" action="login_ok.do" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="ÇÐ¹ø" name="Sid" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="password" name="Spw" type="password">
			    		</div>

			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>

<div class="footer">
<%@include file="../template/footer.jsp"%></div>

</body>
</html>