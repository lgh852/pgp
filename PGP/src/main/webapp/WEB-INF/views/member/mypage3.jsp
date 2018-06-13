<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page3</title>
<style>

</style>
</head>
<body>



<h1>${msg}</h1><br>
<c:set var="msgs" value="${msg}" />
${msgs}
<c:if test="${msgs eq '임시 비밀번호가 발송되었습니다'}">
비밀번호 변경후 로그인 가능합니다 
<a href = "<%=request.getContextPath()%>/member/change_pw">비밀번호 변경하기</a>

</c:if>







</body>
</html>