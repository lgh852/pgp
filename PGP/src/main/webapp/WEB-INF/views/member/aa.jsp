<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>

<title>Insert title here</title>

</head>
<style>
</style>
<body>

</body>
<script>
	$(document).ready(function() {


		var url = window.location.href;
		var urlArr = url.split('access_token');


			alert(urlArr);
			var naverLogin = new naver.LoginWithNaverId({
				   clientId: "4zEiZaP09VSRXmZR87vq",
		            callbackUrl: "http://localhost:8080/p/member/naver",   
		            isPopup : true, /* 팝업을 통한 연동처리 여부 */
		            loginButton : {color: "green", type: 3, height: 50}
			/* 로그인 버튼의 타입을 지정  */
			}

			);
		
		/* 설정정보를 초기화하고 연동을 준비  */
	
			alert(naverLogin.getLoginStatus);

		naverLogin.getLoginStatus(function(status) {
			alert(status)
			if (status) {

				var email = naverLogin.user.getEmail();
				alert(email);
				var name = naverLogin.user.getNickName();
				alert(name);
				var profileImage = naverLogin.user.getProfileImage();
				var birthday = naverLogin.user.getBirthday();
				alert(profileImage)
				alert(birthday)
				$.ajax({

					type : 'GET',

					url : '/p/member/naverLogin',

					cache : false,
					
					data : {
						member_id : email,
						member_pw : 'naver',
						member_name : name,
						member_photo : profileImage,
						member_birth: birthday,
						member_gender :'naver'
						
					},
					success : function(data) {
						if(data=='y'){
							//계정없음 회원 가입처리 후 로그인 
							alert(data);
							//	window.location = "/p/";
							 window.close();
							 window.opener.location = "/p/";
						}else if(data=='n'){
							alert(data);
							//계정있음 세션만 만듬 
						//	window.location = "/p/";
							window.close();
							 window.opener.location = "/p/";
							 }
					},

					error : function(request, status, error) {

						alert('ERROR : ' + request + ' ' + status

						+ ' ' + error);
					}

				});

			} else {

				console.log("AccessToken이 올바르지 않습니다.");
			}

		});
	
	});
</script>
</html>