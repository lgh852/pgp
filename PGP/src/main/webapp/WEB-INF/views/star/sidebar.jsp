<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<style>
#layerPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	left: 500px;
	top: 500px;
	background: #fff;
}

#layerPopup button {
	cursor: pointer;
}

#reportPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	left: 1000 px;
	top: 750px;
	background: #fff;
}

#reportPopup button {
	cursor: pointer;
}

ul.list-group{

    list-style : none;
    margin: 10px;
    padding: 0px;
    
    max-width: 250px;
    max-height: 50px;
    width: 100%;
    text-align: center;
    
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

<div id="likeArea" class="likeArea">

	<c:if test="${likeck==null}">
		<a style="position: absolute; right: 600px; top: 800px"> <img
			class="heart1"
			src="<%=request.getContextPath()%>/resources/images/heart1.png"
			width="50px" height="50px"></a>
	</c:if>

	<c:if test="${likeck!=null}">
		<a style="position: absolute; right: 600px; top: 800px"> <img
			class="heart1"
			src="<%=request.getContextPath()%>/resources/images/heart2.jpg"
			width="50px" height="50px"></a>
	</c:if>



	<input type="hidden" id="board_idx" value="${board_idx}"> 
	<input type="hidden" id="member_idx" value="${member_idx}">



</div>


<a href="<%=request.getContextPath()%>/mypage/mp_main">${member.member_id}</a>

<div id="scrap" class="scrapArea">

	<a href="#scrapPopup">스크랩</a>

	<div id="scrapPopup" >

		<c:forEach var="scrapNameList" items="${scrapNameList}" varStatus="status">
			<ul class="list-group">
				<li>
				<button type="button" class="scrapSuccess${status.count} list-group-item list-group-item-action active"
				onclick="scrapButton(${status.count})">${scrapNameList.scrap_name}</button>
				 </li>
			</ul>
			

		</c:forEach>


		
			<input type="text" id="scrapFolderName" placeholder="스크랩북 이름을 입력해줘잉" />
			<button type="button" id="add">추가</button>
		

		<button type="button" id="close">닫기</button>
		
		<%-- <c:set var="listc" value="${fn:length(scrapNameList)}"></c:set>
		
		${listc} --%>
		
		<input type="hidden" id="listnumber" value="${fn:length(scrapNameList)}">
		<input type="hidden" id="board_idx" value="${board_idx}"> 
		<input type="hidden" id="member_idx" value="${member_idx}">
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
		<button type="button" id="closeeeee">닫기</button>


		<input type="hidden" id="storyboard_idx" value="${storyboard_idx}">
		<input type="hidden" id="board_idx" value="${board_idx}"> 
		<input type="hidden" id="member_idx" value="${member_idx}">


	</div>
</div>
