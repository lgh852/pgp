<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="report" items="${report}">

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">게시글 번호</th>
      <th scope="col">신고사유</th>
      <th scope="col">회원번호</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${report.board_idx}</td>
      <td>${report.report_contents}</td>
      <td>${report.member_idx}</td>
    
    </tr>
   </tbody>
</table>

</c:forEach>

