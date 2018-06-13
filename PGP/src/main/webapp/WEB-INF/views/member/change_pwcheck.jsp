<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html >
<html>

<head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>비밀번호 찾기</title>
</head>
<body>
<h1>비밀번호 변경</h1>

<input type="hidden" value="${msg}" class="msg">

</body>
<script>
$(document).ready(function(){
	var msg = $('.msg');
	if(msg!=''){
		alert('비밀번호가 변경되었습니다'); 
		opener.parent.location='/p/member/loginform';
		window.close();
	}else{
		alert('정보를 확인해주세요'); 
		window.location='/p/member/change_pw';
	}
	
})

</script>
</html>
