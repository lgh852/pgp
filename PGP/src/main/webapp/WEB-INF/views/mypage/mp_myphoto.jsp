<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>사진만 보여주면 된다능 </h1>

<h3>

<c:forEach var="myphoto" items="${myphoto}">

제목${myphoto.board_title}
내용${myphoto.board_contents}
번호${myphoto.board_idx}

</c:forEach>


</h3>
