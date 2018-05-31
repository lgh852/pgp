<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="myComment" items="${myComment}">

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">내용</th>
      <th scope="col">등록일</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${myComment.board_comment_contents}</td>
      <fmt:formatDate value="${myComment.board_comment_regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
      
    </tr>
   </tbody>
</table>

</c:forEach>


</body>
</html>