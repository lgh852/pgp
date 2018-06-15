<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="margin: auto; width: 70%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


<title>비밀번호 찾기</title>
</head>
<body>
	<div class=" text-center" style="margin: auto; padding-top: 30px;">
		<img class="d-block mx-auto mb-4"
			src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
			width="64" height="64">
		<h3></h3>
	</div>


	<div class="col-md-8 order-md-1" style="margin: auto;">
		<hr class="mb-4">

		<div class="mb-3" style="text-align: center;">
			<h4>${member.member_name}님의 ID는</h4>
			<h4>${member.member_id}입니다</h4>
			<br>
			</div>


		<hr class="mb-4">

		<div style="text-align: center;">© Playground 느그집</div>
		<div style="height: 30px;"></div>
	</div>



</body>
</html>