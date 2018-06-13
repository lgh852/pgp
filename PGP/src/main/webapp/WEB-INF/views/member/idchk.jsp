<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Find ID</title>
</head>
<body>
<h1>아이디 찾기</h1>

<form id ="findId" action="${request.getContextPath()}mypage2" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name"></td>
			</tr>
			<tr>
			
			
				<td>생년월일</td>
				<td><input type="text" name="member_birth"></td>
					
					
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="member_phone"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="찾기"> <input
					type="reset"></td>
			</tr>
		</table>
</form>

</body>
</html>
<script>

$(document).ready(function(){
	$('#findId').sumbit(function(){
		
		
		
		
	
		
		
	})
	
	
})

</script>