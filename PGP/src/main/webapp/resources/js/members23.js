$(document).ready(function() {


	$('#userId').focusout(function() {

		var id = $('#userId').val();
		if (id.trim().length < 8) {
			$('#useridck').text('필수정보입니다');
			$('#useridck').css('color', 'red');

		} else {
			alert('ss');
			$('#useridck').text('');
			$.ajax({
				type : 'GET',
				url : '/p/member/idck',
				dataType : 'text',
				data : {
					member_id : id
				},
				success : function(data) {
					if (data == 'y') {
						// y==정상적으로 처리
						$('#useridck').text('사용가능한 아이디입니다');
						$('#useridck').css('color', 'blue');
					} else if (data == 'n') {
						$('#useridck').text('이미 사용중인 아이디입니다');
						$('#useridck').css('color', 'red');
					} else {
						alert('에러');
					}
				}
			});
		}

	});

	$('#userPw').focusout(function() {
		var pws = $('#userPw').val();
		if (pws.trim().length < 8) {
			$('#userPwck').text('필수정보입니다');
			$('#userPwck').css('color', 'red');
		} else {
			$('#userPwck').css('color', 'blue');
			$('#userPwck').text('비밀번호');
		}

	});
	$('#userPw2').focusout(function() {
		var pw2 = $('#userPw2').val();
		var pw = $('#userPw').val();
		if (pw2.trim().length < 8) {
			$('#userPwck2').text('필수정보입니다');
			$('#userPwck2').css('color', 'red');
			if (pw2 != pw) {
				$('#userPwck2').text('비밀번호가 일치하지 않습니다');
			} else {
				$('#userPwck2').text('비밀번호 확인');
				$('#userPwck2').css('color', 'blue');
			}
		} else {
			$('#userPwck2').text('비밀번호 확인');
			$('#userPwck2').css('color', 'blue');
		}

	});

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
			if(phone2.trim().length<3&&phone3.trim().length<3){
				$('#phoneck').text('핸드폰 번호룰 확인해주세요');		
			}else{
		
						
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
	$('#memberform').submit(function() {

		var id = $('#userId').val();
		var userPw = $('#userPw').val();
		var userPw2 = $('#userPw2').val();
		var userName = $('#userName').val();
		var userNickName = $('#userNickName').val();
		var year = $('#year').val();
		var month = $('#month').val();
		var day = $('#day').val();
		var phone2 = $('#phone2').val();
		var phone3 = $('#phone3').val();

		if (id.trim().length < 8) {

			
			alert('8자 이상 입력해주세요');

			return false;

		}
		if (userPw.trim().length < 8) {

			
			
			alert('비밀번호 8자 이상 입력해주세요');

			return false;

		}

		if (userPw.trim().length < 8) {

			alert('비밀번호 8자 이상 입력해주세요');

			return false;

		}

		if (userName.trim().length < 1) {

			alert('이름을 입력해주세요');

			return false;

		}

		if (userNickName.trim().length < 1) {

			alert('별명을 입력해주세요');

			return false;

		}
		if (year == '0') {

			alert('생년월일을 입력해주세요');

			return false;

		}
		if (month == '0') {

			alert('생년월일을 입력해주세요');

			return false;

		}
		if (day == '0') {

			alert('생년월일을 입력해주세요');

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

});
