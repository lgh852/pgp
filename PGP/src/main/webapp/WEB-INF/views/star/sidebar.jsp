<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
#layerPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	left: 500px;
	top: 1000px;
	background: #fff;
}

#layerPopup button {
	cursor: pointer;
}

.scrapp {
	overflow: hidden;
}

#reportPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	left: 500 px;
	top: 1200px;
	background: #fff;
}

#reportPopup button {
	cursor: pointer;
}
</style>



<div align="center">
	<img
		src="<%=request.getContextPath()%>/resources/BoardPhoto/${photoName}"
		width="400px" height="200px">
</div>
<br>
<br>
<div>
	<form method="post">

		<!-- <script>
$(document).ready(function(){
	
	$('#like').click(function(){
>>>>>>> branch 'master' of https://github.com/lgh852/pgp.git

<<<<<<< HEAD
<c:if test="${memberIdx==user.member_idx}">
<div align="right">
		<input name="photoDeteailUpdate" type="button" value="수정"
			class="btn btn-primary" width="200px"> <input
			name="photoDetailDelete" type="button" value="삭제"
			class="btn btn-danger" width="200px">
	</div>
	<br>
</c:if>

<div>
제목 / ${boardTitle} /<hr>
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

<div class="list-group-item list-group-item-secondary">카테고리 추천 사진

</div>




<div class="a" id="likeArea">

	<button type="button" id="btnLike">
		<img
			src="${ isLiked == true? './img/heart.jpg' : './img/empty_heart.png' }"
			id="like_img" height="50px" width="50px">
	</button>

	<span id="like_count">${like_count}</span>


</div>



<img src="<%=request.getContextPath()%>/resources/images/pp.png"
	width="400px" height="300px">


<%-- 	<c:if test="${isExistsLikeData}">
		<span id="like" style="color:red;">o</span>
		</c:if>
		<c:if test="${!isExistsLikeData}">
		<span id="like" style="color:red;">x</span>
		</c:if>  --%>




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
					<td width="50px"><a
						href="<%=request.getContextPath()%>/photo/photodetail2">삭제</a></td>
					<td width="50px"><a href="#">수정 </a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</form>


<!-- 사이드바  -->

<div id="like">














</div>








<div id="scrap" class="scrapp">

	<a href="#layerPopup">스크랩</a>
	<div id="layerPopup">
		<ul>
			<li id="one" class="hot"><a href="#">스크랩북</a></li>
		</ul>
		<div id="newScrapButton">
			<button href="#" id="showForm">폴더명 추가하기</button>
		</div>
		<form id="newScrapForm">
			<input type="text" id="scrapFolderName" placeholder="스크랩북 이름을 입력해줘잉" />
			<input type="submit" id="addButton" value="추가" />
		</form>
		<button type="button" id="close">닫기</button>
	</div>
</div>


<div id="report">
	<a href="#reportPopup">신고</a>
	<div id="reportPopup">



		<div class="report_reason">
			<select class="reason" id="report_contents">
				<option selected value="0">주제와 맞지 않음</option>
				<option selected value="1">정보가 부정확함</option>
				<option selected value="2">지나친 광고성 게시물</option>
				<option selected value="3">도배 및 중복 게시물</option>
				<option selected value="4">저작권 침해가 우려됨</option>
				<option selected value="5">욕설/비방이 심함</option>
				<option selected value="6">외설적인 게시물</option>
			</select>
		</div>

		<button type="button" id="report_submit">신고당해랏</button>


		<input type="hidden" id="storyboard_idx" value="${storyboard_idx}">
		<input type="hidden" id="board_idx" value="${board_idx}">
		<input type="hidden" id="member_idx" value="${member_idx}"> 


	</div>
</div>
