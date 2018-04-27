<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



	<img src="<%=request.getContextPath()%>/resources/images/pp.png"
		width="400px" height="300px">

	<form method="post">
		<!--글번호-->
		<input name="board_comment_contents" type="text"> <input
			type="submit" value="send" width="600px"> <br>
		<hr>
		<table>

			<c:forEach var="c1" items="${Commentlist}">
			
				<tr height="60px">
					<td width="80px">${c1.board_comment_idx}번째글</td>
					<td>id:${c1.member_id} >></td>
					<td width="150px">${c1.board_comment_contents}</td>
					<td width="250px"><fmt:formatDate
							pattern="yyyy년 MM월 dd일 HH:mm:ss"
							value="${c1.board_comment_regdate}" /></td>
			<c:if test="${c1.member_id==user.member_id}">
					<td width="50px"><a href="<%=request.getContextPath()%>/photo/photodetail2">삭제</a></td>
					<td width="50px"><a href="#">수정 </a></td>
		</c:if>
				</tr>
			</c:forEach>
		</table>
	