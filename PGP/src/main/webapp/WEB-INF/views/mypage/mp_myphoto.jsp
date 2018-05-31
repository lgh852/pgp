<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="myphoto" items="${myphoto}">

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">제목</th>
      <th scope="col">내용</th>
      <th scope="col">사진</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${myphoto.board_title}</td>
      <td>${myphoto.board_contents}</td>
      <td><img src="<%=request.getContextPath()%>/resources/BoardPhoto/${myphoto.photo_name}" width="300px" height="300px"></td>
    </tr>
   </tbody>
</table>


<%-- 제목${myphoto.board_title}
내용${myphoto.board_contents}
번호${myphoto.board_idx}
<img src="<%=request.getContextPath()%>/resources/BoardPhoto/${myphoto.photo_name}" width="300px" height="300px"> --%>

</c:forEach>




