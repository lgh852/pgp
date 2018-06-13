<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script>

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8&appId=APPID";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	window.fbAsyncInit = function() {
		FB.init({
			appId : '169031320443873',
			cookie : true,
			xfbml : true,
			version : 'v2.8'
		});

		FB.getLoginStatus(function(response) {

			console.log('statusChangeCallback');
			console.log(response);

			if (response.status === 'connected') {
				$("#result").append("status : connected");
			} else {
				$("#result").append(response);
			}
		});
	};

	function fbLoginAction() {
		FB.login(function(response) {
			var fbname;
			var accessToken = response.authResponse.accessToken;
			FB.api('/me?fields=id,name,age_range,birthday,gender,email',
					function(response) {
						var fb_data = jQuery
								.parseJSON(JSON.stringify(response));
						alert(fb_data);
						var member_id = fb_data.id;
						var email = fb_data.email;
						var member_name = fb_data.name;

						/*     alert(email);
						   	alert(member_id);
						   	alert(member_name);
						 */if (email === undefined || email === null) {

						} else {
							//email 값이 있으면 id값으로 사용 
							member_id = email + '_facebook';
						}
						$.ajax({
							type : "get",
							url : "facebook",
							data : {
								member_id : member_id,
								member_pw : 'facebook',
								member_name : member_name,
								member_photo : 'facebook',
								member_birth : 'facebook',
								member_gender : 'facebook'

							},
							success : function(date) {
								alert(date);
								if (date == 'y') {
									window.location = "/p/";
								} else if (date == 'n') {

									window.location = "/p/";
								}

							},
							fail : function(error) {
								alert('에러');
							}

						})

					});
		}, {
			scope : 'public_profile, email'
		});
	}
</script>


<hr class="featurette-divider" style="width: 100%">
<body class="text-center">
	<form class="form-signin" style="margin: auto;"
		action="<%=request.getContextPath()%>/member/loginform" method="post">
		<img class="mb-4"
			src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
			width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="text" id="inputEmail" class="form-control" name="member_id"
			placeholder="Email address" required="" autofocus=""
			style="width: 300px;"> <label for="inputPassword"
			class="sr-only">Password</label> <input type="password"
			id="inputPassword" class="form-control" placeholder="Password"
			name="member_pw" required="">
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">
			© Playground <br>2017.12-2018.06
		</p>
	</form>
	
</body>



<div class="my-3 p-3 bg-white rounded box-shadow" style="margin: auto">
	<h6 class="border-bottom border-gray pb-2 mb-0">다른 계정으로 연동하기</h6>
	<div class="media text-muted pt-3">
		<!--네이버  -->
		<button class="btn btn-lg btn-primary btn-block" onclick="memberidfind()">아이디 찾기</button>
	<button class="btn btn-lg btn-primary btn-block" onclick="memberpwfind()">비밀번호 찾기</button>
		<div id="naverIdLogin"></div>
		<!--페이스북 -->
		<!-- style="display: block; width: 150px; color: white; background-color: rgb(54, 88, 153); text-align: center; font-weight: 500; border-radius: 8px 8px 8px 8px; text-decoration: none" -->
		<a href="javascript:void(0);" onclick="fbLoginAction();"> <img
			src="<%=request.getContextPath()%>/resources/images/facebook.png"
			width="45px" height="45px" style="margin-left:5px;margin-right:5px">
		</a>
		<!--카카오  -->
		<%-- 	<img
			src="<%=request.getContextPath()%>/resources/images/kakao.png"width="45px" height="45px"> --%>
<a id="kakao-login-btn"></a> <a
			href="http://developers.kakao.com/logout"></a>

</div>
</div>

 href="<%=request.getContextPath()%>













<%-- <hr class="featurette-divider" style="width: 100%">


<div class="row" style="margin: 0 0 20px 100px;">
	<a href="javascript:;"><img id="facebookLoginBtn"
		src="/resources/img/account_facebook_login_button.png"
		style="width: 200px; height: auto;" alt="페이스북아이디로로그인"></a>
</div>

<form action="<%=request.getContextPath()%>/member/loginform"
	method="post">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-default">id</span>
		</div>
		<input type="text" class="form-control" aria-label="Default"
			aria-describedby="inputGroup-sizing-default" name="member_id">
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-default">password</span>
		</div>
		<input type="text" class="form-control" aria-label="Default"
			aria-describedby="inputGroup-sizing-default" name="member_pw">
	</div>
	<input type="submit" value="로그인"> <a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/logout"></a>

	<div id="naverIdLogin"></div>
	<div id="fb-root"></div>
	<a href="javascript:void(0);" onclick="fbLoginAction();"
		style="display: block; width: 150px; color: white; background-color: rgb(54, 88, 153); text-align: center; font-weight: 500; border-radius: 8px 8px 8px 8px; text-decoration: none">
		FACEBOOK LOGIN</a>
</form> --%>

<script>
function memberidfind() {
	
	window.open('/p/member/idchk', '아이디찾기',
			'width=600px , height=600', '_blank',
			left = '500', top = '500');
}

memberpwfind
function memberpwfind() {
	
	window.open('/p/member/pwchk', '비밀번호찾기',
			'width=600px , height=600', '_blank',
			left = '500', top = '500');
}


</script>
