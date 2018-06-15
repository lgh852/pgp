<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>



<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>아이디 찾기</title>



<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {

		$('#userName').focusout(function() {
			var name = $('#userName').val();

			if (name.trim().length < 2) {
				$('#userNameck').text('필수정보입니다');
				$('#userNameck').css('color', 'red');
			} else {
				$('#userNameck').text('이름');
			}

		});

		$('#userBirth').focusout(function() {
			var birth = $('#userBirth').val();

			if (birth.trim().length < 8) {
				$('#birthck').text('필수정보입니다');
				$('#birthck').css('color', 'red');
			} else {
				$('#birthck').text('생년월일');
			}

		});

		$('#phone2').focusout(function() {
			var phone2 = $('#phone2').val();
			if (phone2.trim().length <= 3) {
				$('#phoneck').text('핸드폰 번호를 확인해주세요');
				$('#phoneck').css('color', 'red');
			} else {
				var phone2 = $('#phone2').val();
				var phone3 = $('#phone3').val();
				if (phone2.trim().length < 3 && phone3.trim().length < 3) {
					$('#phoneck').text('핸드폰 번호룰 확인해주세요');
				} else {

				}
			}
		});
		$('#phone3').focusout(function() {
			var phone3 = $('#phone3').val();
			if (phone3.trim().length <= 3) {
				$('#phoneck').text('핸드폰 번호를 확인해주세요');
				$('#phoneck').css('color', 'red');
			} else {
				$('#phoneck').text('');
			}
		});

		var date = new Date();

		var year = date.getFullYear();

		for (var i = year - 100; i <= year; i++) {

			$('#year').append('<option value='+i+'>' + i + '년' + '</option>');
		}
		;

		for (var i = 1; i <= 12; i++) {

			$('#month').append('<option value='+i+'>' + i + '월' + '</option>');
		}
		;

		for (var i = 1; i <= 31; i++) {

			$('#day').append('<option value='+i+'>' + i + '일' + '</option>');
		}
		;

	});
</script>

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
		<form class="needs-validation" id="findPw"
			action="<%=request.getContextPath()%>/member/idcks" method="post">
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
			<label>생년월일</label> <span id="phoneck"></span>
   <div class="row">
   
   
   <div class="col-4">
      <select class="custom-select" id="year" name="year">
         <option value="0">선택하세요</option>
      </select>
   </div>
   <div class="col-4">
      <select class="custom-select" id="month" name="month">

         <option value="0">선택하세요</option>
      </select>
   </div>
   <div class="col-4">
      <select class="custom-select" id="day" name="day">
         <option value="0">선택하세요</option>

      </select>
   </div>
</div>
				
			
			
			
			<div class="mb-3"></div>

				
			<div class="row">
				<div class="col">
					<button class="btn btn-primary  btn-block" type="submit">찾기</button>
				</div>
				<div class="col">
					<button class="btn btn-secondary  btn-block" type="reset">초기화</button>
				</div>
			</div>

			<hr class="mb-4">
		</form>
		<div style="text-align: center;">© Playground 느그집</div>
		<div style="height: 30px;"></div>
	</div>



</body>
</html>