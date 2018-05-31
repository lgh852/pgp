$(document).ready(

function() {

	// 버튼 클릭시 아작스 처리 tag 저장
	$('#logout').click(function() {

		$.ajax({
			type : 'GET',
			url : '/p/member/logout',
			success : function(data) {

				if (data == 'U') {
					alert('회원님 로그아웃');

				} else if (data == 'M') {
					alert('관리자 로그아웃');
				} else {
					alert('로그인후 사용 요망')
				}

			}
		});

	});

});
