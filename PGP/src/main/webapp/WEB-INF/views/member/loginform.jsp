<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<style>

</style>
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

						if (email === undefined || email === null) {

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
		
		<div class="find" style="margin-top:20px;">
		<div class="checkbox mb-3">
			
			<div class="container">
			 <div class="row">
			  <div class="col">
      <a href="#" onclick="memberidfind()" style="color:black;">아이디찾기</a>
    </div>
    <div class="col">
       <a href="#" onclick="memberpwfind()" style="color:black;">비밀번호찾기</a>
    </div>
 
  </div>
       </div>
		
		</div>
		</div>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3" style="color: black; font-weight: 600;">
			© Playground <br>2017.12-2018.06
		</p>
	</form>
	
</body>



<div class="my-3 p-3 bg-white rounded box-shadow" style="margin: auto">
	<h6 class="border-bottom border-gray pb-2 mb-0">SNS계정으로 간편 로그인/회원가입</h6>
	
		<div class="media text-muted pt-3">
		<!-- <div id="naverIdLogin"></div> -->
		<div id="naverIdLogin"></div>
		</div>  
			<div class="media text-muted pt-3">
			
		<a href="javascript:void(0);" onclick="fbLoginAction();"> <img
			src="<%=request.getContextPath()%>/resources/images/facebookbtn.PNG"
			 width="300px" style="margin-left:5px;margin-right:5px;border-radius: 5px 5px 5px 5px;margin-left: 0px">
		</a>
		</div>
		
		<div class="media text-muted pt-3">
			
<div id="kakao-login-btn"></div> 

</div>
</div>
<input type="hidden" value="${longinCheck}" class="longinCheck">


<script>
$(document).ready(function(){
	
	var check = ('.longinCheck').val();
	
	if(check.trim().length<0){
		alert('아이디와 비밀번호가 틀렸습니다 ')
	}
	
})


function memberidfind() {
	
	window.open('/p/member/idchk', '아이디찾기',
			'width=600px , height=600', '_blank',
			left = '500', top = '500');
}

function memberpwfind() {
	
	window.open('/p/member/pwchk', '비밀번호찾기',
			'width=620px , height=670px', '_blank',
			left = '500', top = '500');
}


</script>


