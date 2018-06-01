<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<h1>공지사항 입력 폼</h1>

<form action="<%=request.getContextPath()%>/manager/noticeinsert" method="post">


공지사항 제목
<input type="text" name="notice_title">



공지사항 내용
<input type="text" name="notice_contents">

		
			<input type="submit" value="등록">
			<input type="reset">
	



</form>

