<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="py-5 text-center" style="margin: auto">
	<img class="d-block mx-auto mb-4"
		src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
		width="72" height="72">
	<h2>Checkout form</h2>
</div>

<hr class="featurette-divider" style="width: 100%">
<div class="col-md-8 order-md-1" style="margin: auto;">
	<h4 class="mb-3">회원 정보 수정</h4>
	<hr class="featurette-divider" style="width: 100%">
	<form class="needs-validation"
		action="<%=request.getContextPath()%>/mypage/mp_update" method="post"
		id="changemember" enctype="multipart/form-data">

		<div class="mb-3">
			<label for="userId">아이디<span class="text-muted"></span> <span
				id="useridck"></span></label> <input type="text" class="form-control"
				id="userId" value="${member.member_id}" name="member_id"
				readonly="readonly">
		</div>



		<div class="mb-3">
			<label for="userName">이름 <span id="userNameck"></span></label> <input
				type="text" class="form-control" name="member_name" id="userName"
				value="${member.member_name}" readonly>
			<div class="invalid-feedback">Valid first name is required.</div>
		</div>
		<div class="mb-3">
			<label for="userNickName">닉네임<span id="NickNameck"></span></label> <input
				type="text" class="form-control" name="member_nickname"
				id="userNickName" value="${member.member_nickname}">
			<div class="invalid-feedback">Valid first name is required.</div>
		</div>



		<label>생년월일</label><span id="birthck"></span> <input type="hidden"
			value="${year}" id="years"> <input type="hidden"
			value="${month}" id="months"> <input type="hidden"
			value="${day}" id="days">
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
		<label>전화번호</label> <span id="phoneck"></span>
		<div class="row">
			<div class="col-4">
				<input type="text" aria-label="Default"
					aria-describedby="inputGroup-sizing-default" name="phone1"
					id="phone1" placeholder="0000" style="height: 38px;"
					class="form-control" value="${phone1}">
			</div>
			<div class="col-4">
				<input type="text" aria-label="Default"
					aria-describedby="inputGroup-sizing-default" name="phone2"
					id="phone2" placeholder="0000" style="height: 38px;"
					class="form-control" value="${phone2}">
			</div>
			<div class="col-4">
				<input type="text" aria-label="Default"
					aria-describedby="inputGroup-sizing-default" name="phone3"
					id="phone3" placeholder="0000" style="height: 38px;"
					class="form-control" value="${phone3}">
			</div>
		</div>
		<div class="mb-3"></div>


		<label>프로필 사진</label>
		<div class="input-group mb-3">
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="inputGroupFile02"
					name="photofile"> <label class="custom-file-label"
					for="inputGroupFile02">Choose file</label>
			</div>
			<div class="input-group-append">
				<span class="input-group-text" id="">Upload</span>
			</div>
		</div>

		<div class="mb-3"></div>

		<div class="mb-3">
			<label for="firstName">자기소개</label>
			<div class="form-control">
				<!--   <span style="display: block; height: 30px;">자기소개</span> -->
				<textarea aria-label="Default"
					aria-describedby="inputGroup-sizing-default" name="member_intro"
					id="member_intro" placeholder="자기소개를 해주세요"
					style="width: 100%; resize: none;" cols="40" rows="8">${member.member_intro}</textarea>

			</div>
		</div>
		<hr class="mb-4">


		<button class="btn btn-primary btn-lg btn-block" type="submit">회원정보
			수정</button>
		<hr class="mb-4">
	</form>
	<div style="text-align: center;">© Playground 느그집</div>
	<div style="height: 30px;"></div>
</div>

<script>
	$(document).ready(
			function() {

				$("#year option").each(function() {

					if ($(this).val() == $('#years').val()) {

						$(this).prop("selected", "selected"); // attr적용안될경우 prop으로 

					}

				});
				$("#month option").each(function() {

					if ($(this).val() == $('#months').val()) {

						$(this).prop("selected", "selected"); // attr적용안될경우 prop으로 

					}

				});
				$("#day option").each(function() {

					if ($(this).val() == $('#days').val()) {

						$(this).prop("selected", "selected"); // attr적용안될경우 prop으로 

					}

				});

				$('#changemember').submit(
						function() {

							var userPw = $('#member_password').val();

							var userName = $('#userName').val();

							var userNickName = $('#userNickName').val();

							var phone1 = $('#phone1').val();
							var phone2 = $('#phone2').val();
							var phone3 = $('#phone3').val();

							var changepw1 = $('#changePw1').val();
							var changepw2 = $('#changePw2').val();

							var pw = $('#pw').val();//현재 비밀번호값 

							if (changepw1.trim().length > 1
									&& changepw2.trim().length > 1) {
								//변경할 비밀번호에 값이 존재할 경우 
								//넘어갈 member_pw에 값에 새로 입력한 pw 의 값을 넣어줌 

								if (pw == userPw) {
									//현재 비밀번호와 새로 입력한 현재 비밀번호 값이 동일할경우 

									//현재 비밀번호 값에 changepw1인 변경할 비밀번호값을 넣어줌 
									if (changepw1 == changepw2
											&& changepw1.trim().length >= 8) {
										$('#member_password').val(changepw1)

									} else {

										/* 비번 확인  */
										return false;

									}

								} else {

									/* 현재 비번 일치 안함  */
									return false;
								}

							} else {
								//존재하지 않을 경우 
								$('#member_password').val(pw);
							}

							if (userNickName.trim().length < 1) {

								alert('별명을 입력해주세요');

								return false;

							}
							if (phone1.trim().length < 2) {

								alert('전화번호를 입력해주세요')
								return false;
							}

							if (phone2.trim().length < 3) {

								alert('전화번호를 입력해주세요')
								return false;
							}
							if (phone3.trim().length < 3) {

								alert('전화번호를 입력해주세요')
								return false;
							}

						})

				//현재 사용중 비번 체크 
				$('#member_password').focusout(
						function() {

							var member_pw = $('#member_password').val();
							var pw = $('#pw').val();//현재 비밀번호값 
							if (member_pw.trim().length <= 0) {
								$('#member_pwmsg').text('')
								$('#member_pwmsg').css('color', 'black');
							} else if (member_pw.trim().length > 0
									&& member_pw.trim().length < 8) {
								// 값이 있음 
								$('#member_pwmsg').text('8자리 이상 입력해주세요.')
								$('#member_pwmsg').css('color', 'red');
							} else if (pw == member_pw) {
								$('#member_pwmsg').text('비밀번호 확인 완료.')
								$('#member_pwmsg').css('color', 'blue');
							}

							else if (pw != member_pw) {
								$('#member_pwmsg').text('비밀번호를 다시 확인해주세요.')
								$('#member_pwmsg').css('color', 'red');
							}

						})
				$('#changePw1').focusout(function() {
					var pw = $('#changePw1').val();
					var pw2 = $('#changePw2').val();
					if (pw.trim().length < 8) {
						$('#userPwck').text('8자리 이상 입력해주세요.');
						$('#userPwck').css('color', 'red');
						
					} else if(pw.trim().length >= 8 && pw==pw2){
						$('#userPwck2').text('비밀번호 확인 완료.');
						$('#userPwck2').css('color', 'blue');
					}else{
						$('#userPwck').text('');
						$('#userPwck').css('color', 'black');
						$('#userPwck2').text('비밀번호가 일치하지 않습니다');
						$('#userPwck2').css('color', 'red');
						
					}

				});

				$('#changePw2').focusout(function() {
					var pw = $('#changePw1').val();
					var pw2 = $('#changePw2').val();
					 if(pw2.trim().length<8){
						$('#userPwck2').text('8자리 이상 입력해주세요.');
						$('#userPwck2').css('color', 'red');
					}else if(pw2.trim().length >= 8 && pw==pw2){
						$('#userPwck2').text('비밀번호 확인 완료.');
						$('#userPwck2').css('color', 'blue');
					}else{
						$('#userPwck2').text('비밀번호가 일치하지 않습니다');
						$('#userPwck2').css('color', 'red');
						
					}

				});

				$('#phone2').focusout(
						function() {
							var phone2 = $('#phone2').val();

							if (phone2.trim().length <= 3) {
								$('#phoneck').text('핸드폰 번호를 확인해주세요');
								$('#phoneck').css('color', 'red');
							} else {
								var phone2 = $('#phone2').val();
								var phone3 = $('#phone3').val();
								if (phone2.trim().length < 3
										&& phone3.trim().length < 3) {
									$('#phoneck').text('핸드폰 번호룰 확인해주세요');
								} else {
									$('#phoneck').text('');

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
				$('#phone1').focusout(function() {
					var phone1 = $('#phone1').val();
					if (phone3.trim().length <= 2) {
						$('#phoneck').text('핸드폰 번호를 확인해주세요');
						$('#phoneck').css('color', 'red');
					} else {
						$('#phoneck').text('');
					}
				});

			});
</script>




