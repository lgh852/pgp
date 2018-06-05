<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:forEach var="faq" items="${faq}">

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">공지사항 제목</th>
      <th scope="col">공지사항 내용</th>
      <th scope="col">등록날짜</th>
      <th scope="col">삭제</th>
      <th scope="col">수정</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><a href="${pageContext.request.contextPath}/manager/faqview?faq_idx=${faq.faq_idx}">${faq.faq_title}</a></td>
      <td>${faq.faq_contents}</td>
      <td><fmt:formatDate value="${faq.faq_regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
      <td><a href="<%=request.getContextPath()%>/manager/faqdelete?faq_idx=${faq.faq_idx}">삭제</a></td>
      <td><a href="<%=request.getContextPath()%>/manager/faqupdate?faq_idx=${faq.faq_idx}">수정</a></td>
       
    </tr>
   </tbody>
</table>

</c:forEach>

