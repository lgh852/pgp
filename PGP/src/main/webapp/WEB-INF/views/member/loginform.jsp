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
							member_id = email+'_facebook';
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
	<a href="javascript:void(0);" onclick="fbLoginAction();"style="display: block; width: 150px; color: white;background-color:rgb(54,88,153); text-align: center; font-weight: 500; border-radius: 8px 8px 8px 8px;text-decoration:none">FACEBOOK
		LOGIN</a>
</form>
