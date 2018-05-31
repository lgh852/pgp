<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3>마이페이지 수정완료</h3>


<h1>아이디${member.member_id}</h1>
<h1>별명${member.member_nickname}</h1>
<h1>성별${member.member_gender}</h1>
<h1>휴대폰${member.member_phone}</h1>
<h1>생일${member.member_birth}</h1>
<h1>사진
	<img src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" width="300px" height="300px">
		</h1>		
<h1>소개${member.member_intro}</h1>




