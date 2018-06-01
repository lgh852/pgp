<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<h1>FAQ 업데이트폼 폼</h1>

<form action="<%=request.getContextPath()%>/manager/faqupdate" method="post">


FAQ제목
<input type="text" name="faq_title">

FAQ내용
<input type="text" name="faq_contents">

<input type="hidden" name="faq_idx" value="${faq.faq_idx}">
		
			<input type="submit" value="수정">
			<input type="reset">
	
</form>