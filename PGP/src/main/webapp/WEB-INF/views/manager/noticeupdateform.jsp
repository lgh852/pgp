<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<h1>공지사항 업데이트폼 폼</h1>


<form action="<%=request.getContextPath()%>/manager/noticeupdate" method="post">


공지사항 제목
<input type="text" name="notice_title">

공지사항 내용
<input type="text" name="notice_contents">

<input type="hidden" name="notice_idx" value="${notice.notice_idx}">
		
			<input type="submit" value="수정">
			<input type="reset">
	



</form>