<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>

<head>
<title>비밀번호 찾기</title>
</head>
<body>
<h1>비밀번호 변경</h1>



 <form id = "change_pw" action="<%=request.getContextPath()%>/member/change_pw" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member_id"/></td>
			</tr>
			<tr>
				<td>현재 비밀번호</td>
				<td><input type="text" name="member_pw"/></td>
			</tr>
			<tr>
				<td>변경할 비밀번호</td>
				<td><input type="text" name="member_pw1" id='1'/></td>
			</tr>
			<tr>
				<td>변경 비밀번호 확인</td>
				<td><input type="text" name="member_pw2" id='2'/></td>
			</tr>	
			<tr>
				<td></td>
				<td><input type="submit" value="변경"/> <input
					type="reset"/></td>
			</tr>
		</table>
</form>

</body>
</html>
