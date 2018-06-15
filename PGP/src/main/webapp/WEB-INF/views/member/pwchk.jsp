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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>

<script type="text/javascript">

</script>
<title>비밀번호 찾기</title>
</head>
<body>
	<div class=" text-center" style="margin: auto; padding-top: 30px;">
		<img class="d-block mx-auto mb-4"
			src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
			width="64" height="64">
		<h3>비밀번호 찾기</h3>
	</div>


	<div class="col-md-8 order-md-1" style="margin: auto;">
		<hr class="mb-4">
		<form class="needs-validation" novalidate="" id="findPw"
			action="<%=request.getContextPath()%>/member/mypage3" method="post">

			<div class="mb-3">
				<label for="userId">아이디<span class="text-muted"></span> <span
					id="useridck"></span></label> <input type="text" class="form-control"
					id="userId" placeholder="" name="member_id">
			</div>


			<div class="mb-3">
				<label for="userName">이름 <span id="userNameck"></span></label> <input
					type="text" class="form-control" name="member_name" id="userName"
					placeholder="" value="" required="">
				<div class="invalid-feedback">Valid first name is required.</div>
			</div>


			<div class="mb-3"></div>
			<label>전화번호</label> <span id="phoneck"></span>
			<div class="row">
				<div class="col-4">
					<select class="custom-select" id="phone1" name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="018">018</option>
					</select>
				</div>
				<div class="col-4">
					<input type="text" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" name="phone2"
						id="phone2" placeholder="0000" style="height: 38px;"
						class="form-control">
				</div>
				<div class="col-4">
					<input type="text" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" name="phone3"
						id="phone3" placeholder="0000" style="height: 38px;"
						class="form-control">
				</div>
			</div>
			<div class="mb-3"></div>
			<div class="row">
				<div class="col">
					<button class="btn btn-primary  btn-block" type="submit">찾기</button>
				</div>
				<div class="col">
					<button class="btn btn-secondary  btn-block" type="reset" onclick="javascript:window.close();" id="closeBtn">닫기</button>
				</div>
			</div>

			<hr class="mb-4">
		</form>
		<div style="text-align: center;">© Playground 느그집</div>
		<div style="height: 30px;"></div>
	</div>



</body>
</html>