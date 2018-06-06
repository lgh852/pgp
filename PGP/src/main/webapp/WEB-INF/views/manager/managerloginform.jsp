<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<form action="<%=request.getContextPath()%>/manager/managerloginform" method="post">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-default">id</span>
		</div>
		<input type="text" class="form-control" aria-label="Default"
			aria-describedby="inputGroup-sizing-default" name="manager_id">
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-default">password</span>
		</div>
		<input type="text" class="form-control" aria-label="Default"
			aria-describedby="inputGroup-sizing-default" name="manager_pw">
	</div>
	<input type="submit" value="로그인">
</form>
    