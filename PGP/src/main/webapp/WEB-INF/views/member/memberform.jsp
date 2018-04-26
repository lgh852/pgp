<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath()%>/member/memberform" method="post">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_id">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_pw">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_name">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">닉네임</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_nickname">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">생일</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_birth">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">핸드폰번호</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_phone">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">자기소개</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							aria-describedby="inputGroup-sizing-default" name="member_intro">
					</div>
					<input type ="submit" value="회원가입">
</form>

