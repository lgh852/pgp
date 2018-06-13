<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page3</title>
<style>
	div{
		width: 200px;
		height: 200px;
		
		border-radius : 100px; 
		
		
		
	}
</style>
</head>
<body>

<div id="my"> </div>

<h1>임시 비밀번호가 발송되었습니다.</h1><br>
<%-- <input type="hidden" name="member_id" value="${aaa.member_id }"> --%>
<%-- ${aaa.member_id } --%>
<!-- <form id = "change_pw" action="login" method="get"> -->
<table>
	<tr>
	<td><td>
	<td><a href = "change_pw">비밀번호 변경하기</a></td>
	<!-- <td><a target = "_blank" href = "http://localhost:8080/pg5/member/change_pw" onclick="try{nclks('log.searchid',this,event)}catch(e){}">비밀번호 변경하기</a></td> -->
<%-- change_pw?member_id=${aaa.member_id } --%>
</table>


<!-- </form> -->






</body>
</html>