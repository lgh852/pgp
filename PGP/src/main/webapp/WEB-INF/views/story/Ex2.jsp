<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>






<h4 class="featurette-heading">

	<c:if test="${board.memberIdx==user.member_idx}">
		<!-- 신고기능 -->
		<a type="button" style="" class=" btn btn-outline-success"
			href="<%=request.getContextPath()%>/photo/updatePhotodetail?board_idx=${board.boardIdx}"
			role="button">수정 </a>
		<!-- 삭제기능 -->
		<a class="btn btn-danger"
			href="<%=request.getContextPath()%>/photo/photofeedAllDelete?board_idx=${board.boardIdx}"
			role="button">삭제 </a>
	</c:if>


</h4>
<span class="text-muted"> Date: <fmt:formatDate
		pattern="yyyy년 MM월 dd일 HH:mm:ss"
		value="${board.board_regdate}" /></span>

<p class="lead">${listStory.storyboard_contents}</p>

</div>
Board board=photodetailservice.boardSelectView(board_idx);
		model.addAttribute("boardContents",board.getBoard_contents());
		model.addAttribute("boardTitle",board.getBoard_title());
		model.addAttribute("memberIdx",board.getMember_idx());
		model.addAttribute("boardIdx",board.getBoard_idx());

/*	model.addAttribute("boardContents",board.getBoard_contents());
		model.addAttribute("boardTitle",board.getBoard_title());
		model.addAttribute("memberIdx",board.getMember_idx());
		model.addAttribute("boardIdx",board.getBoard_idx());*/







