<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
alert('${msg}');
var k='${key}';
if(k==1)
	location="/web/login_form.do";
else
	location="/web/index.do";
</script>

</body>
</html>