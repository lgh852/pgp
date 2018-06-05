<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<form action="<%=request.getContextPath()%>/manager/faqinsert" method="post">


FAQ제목
<input type="text" name="faq_title">


FAQ내용
<input type="text" name="faq_contents">

		
			<input type="submit" value="등록">
			<input type="reset">
	
</form>

