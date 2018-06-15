<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="py-5 text-center" style="margin: auto">
	<img class="d-block mx-auto mb-4"
		src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
		width="72" height="72">
	<h2>Checkout form</h2>
	<p class="lead">회원가입을 하고 많은 정보를 공유하고 소통해보세요~</p>
</div>

<hr class="featurette-divider" style="width: 100%">
<div class="col-md-8 order-md-1" style="margin: auto;">
	<h4 class="mb-3">회원가입</h4>
	<hr class="featurette-divider" style="width: 100%">
	<form class="needs-validation" novalidate=""
		action="<%=request.getContextPath()%>/member/memberform" method="post"
		id="memberform">

		<div class="mb-3">
			<label for="userId">아이디<span class="text-muted"></span> 
			<span id="useridck"></span></label> 
			<input type="text" class="form-control"
				id="userId" placeholder="" name="member_id">
		</div>

		<div class="row">
			<div class="col-md-6 mb-3">
				<label for="userPw">비밀번호<span id="userPwck"></span></label> <input
					type="password" class="form-control" name="member_pw" id="userPw"
					placeholder="" value="" required="">
				<div class="invalid-feedback">Valid first name is required.</div>
			</div>
			<div class="col-md-6 mb-3">
				<label for="userPw2">비밀번호 확인 <span id="userPwck2"></span></label> <input
					type="password" class="form-control" name="userPw" id="userPw2"
					placeholder="" value="" required="">
				
			</div>
		</div>

		<div class="mb-3">
			<label for="userName">이름 <span id="userNameck"></span></label> <input
				type="text" class="form-control" name="member_name" id="userName"
				placeholder="" value="" required="">
			<div class="invalid-feedback">Valid first name is required.</div>
		</div>
		<div class="mb-3">
			<label for="userNickName">닉네임<span id="NickNameck"></span></label> <input
				type="text" class="form-control" name="member_nickname"
				id="userNickName" placeholder="" value="" required="">
			<div class="invalid-feedback">Valid first name is required.</div>
		</div>

		<label>성별</label>
		<div class="row">
			<div class="col-md-6 mb-3 btn-group btn-group-toggle"
				data-toggle="buttons">
				<label class="btn btn-secondary active" style="width: 200px;">
					<input type="radio" name="member_gender" id="option1"
					autocomplete="off" checked value="man"> 남성
				</label> <label class="btn btn-secondary" style="width: 200px;"> <input
					type="radio" name="member_gender" id="option2" autocomplete="off"
					value="woman ">여성
				</label>
			</div>
		</div>
		<label>생년월일</label><span id="birthck"></span>
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

		<div class="mb-3">
			<label for="firstName">자기소개</label>
			<div class="form-control">
				<!--   <span style="display: block; height: 30px;">자기소개</span> -->
				<textarea aria-label="Default"
					aria-describedby="inputGroup-sizing-default" name="member_intro"
					id="member_intro" placeholder="자기소개를 해주세요"
					style="width: 100%; resize: none;" cols="40" rows="8"></textarea>
		
			</div>
		</div>
	

		<button class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button>
		<hr class="mb-4">
	</form>
	<div style="text-align: center;">© Playground 느그집</div>
	<div style="height: 30px;"></div>
</div>





