<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Find PW</title>
</head>
<body>
<h1>비밀번호 찾기</h1>

<form id ="findPw" action="${request.getContextPath()}mypage3" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member_id"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="member_phone"></td>
			</tr>
			<!-- <tr>
				<td>이메일</td>
				<td><input type="text" name="member_intro"></td>
			</tr> -->
			<tr>
				<td></td>
				<td><input type="submit" value="찾기"> <input
					type="reset"></td>
			</tr>
		</table>
</form>

</body>
</html>