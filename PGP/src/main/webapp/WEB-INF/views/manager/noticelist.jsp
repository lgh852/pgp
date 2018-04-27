<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<table border="1">

<tr>
<td>공지사항 제목</td>
<td>공지사항 내용</td>
<td>등록 날짜</td>
</tr>

<c:forEach var="notice" items="${notices}">


<tr>
<td><a href="${pageContext.request.contextPath}/manager/noticeview?notice_idx=${notice.notice_idx}">${notice.notice_title}</a></td>
<td>${notice.notice_contents}</td>
<td><fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
</tr>



</c:forEach> 



</table>
