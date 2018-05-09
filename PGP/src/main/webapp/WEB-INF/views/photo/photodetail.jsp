<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div align="center">
	<img
		src="<%=request.getContextPath()%>/resources/BoardPhoto/${photoName}"
		width="400px" height="200px">
</div>
<br>
<br>
<div>



		<c:if test="${memberIdx==user.member_idx}">
			<div align="right">

				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/photo/"
					role="button">요게수정 </a> 
					<a class="btn btn-danger"
					href="<%=request.getContextPath()%>/photo/photofeedAllDelete?board_idx=${boardIdx}"
					role="button">요게사아악제 </a>
			</div>
			<br>
		</c:if>
	<form method="post">
		<div>
			사진 글 번호 : ${boardIdx} 
			<hr>
			제목 / ${boardTitle} /
			<hr>
			내용 <br> ${boardContents}

		</div>
		<!--글번호-->
		<div class="input-group mb-3">
			<input name="board_comment_contents" type="text"
				class="form-control list-group-item list-group-item-secondary"
				placeholder="댓글을 입력하세욥!!!!!111" aria-label="Recipient's username"
				aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button
					class="btn btn-outline-secondary list-group-item list-group-item-warning"
					type="submit">send@↖⊙_⊙↗@</button>
			</div>
		</div>


		<div class="p-3 mb-2 bg-primary text-white" align="left">
			<br> 조회수 : ${board_cnt_view} &nbsp &nbsp 댓글 수 : ${commentCnt}
		</div>
		<br>
		<table>
			<c:forEach var="c1" items="${Commentlist}">

				<tr height="60px" class="list-group-item list-group-item-info">
					<td width="100px">${c1.board_comment_idx}번째글</td>
					<td width="150px">id:${c1.member_id} >></td>
					<td width="200px">${c1.board_comment_contents}</td>
					<td width="250px"><fmt:formatDate
							pattern="yyyy년 MM월 dd일 HH:mm:ss"
							value="${c1.board_comment_regdate}" /></td>
					<c:if test="${c1.member_id==user.member_id}">
						<td width="50px"><a
							href="<%=request.getContextPath()%>/photo/photoCommentDelete?board_comment_idx=${c1.board_comment_idx}&board_idx=${c1.board_idx}">삭제</a></td>

					</c:if>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<div class="list-group-item list-group-item-secondary">
	<table>
		카테고리 추천 사진
		<c:forEach var="popular" items="${popularPhotoList}">

			<img
				src="<%=request.getContextPath()%>/resources/BoardPhoto/${popular.photo_name}"
				width="400px" height="200px">
			<br>

		</c:forEach>
	</table>

</div>


