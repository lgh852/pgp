<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${msg=='회원가입성공'}">
	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center "
		style="width: 100%; background-image: url(/p/resources/images/roompic5.jpg);">
		<div class="col-md-5 p-lg-5 mx-auto my-5" style="color: white;">
			
			<h1 class="display-4 font-weight-normal">느그집</h1>
			<p class="lead font-weight-normal">
				회원가입 되셨습니다.<br> 느그집에 오신걸 환영합니다.
			</p>
			<a class="btn btn-outline-secondary" href="../" style="color: white;border:  solid;">느그집
				둘러보기</a>
		</div>
		<div class="product-device box-shadow d-none d-md-block"></div>
		<div
			class="product-device product-device-2 box-shadow d-none d-md-block"></div>
	</div>
</c:if>

<c:if test="${msg=='회원가입실패'}">
	<div
		class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light"
		style="width: 100%; background-image: url(/p/resources/images/roompic5.jpg);">
		<div class="col-md-5 p-lg-5 mx-auto my-5">
		
			<h1 class="display-4 font-weight-normal">느그집</h1>
			<p class="lead font-weight-normal">
				회원가입에 실패하였습니다.<br> 다시 회원가입을 해주세요.
			</p>
			<a class="btn btn-outline-secondary" href="../member/memberform"style="color: white;border:  solid;">회원가입하러가기</a>
		</div>
		<div class="product-device box-shadow d-none d-md-block"></div>
		<div
			class="product-device product-device-2 box-shadow d-none d-md-block"></div>
	</div>
</c:if>
