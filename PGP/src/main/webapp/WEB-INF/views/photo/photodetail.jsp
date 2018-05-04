<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- <script>
$(document).ready(function(){
	
	$('#like').click(function(){

		$.post(
				"/like",
				{"member_id" : "${member_info.member_id}"},
				function(data){
					
					var text = $("#like").text();
					if(text == "x"){
						$("#like").text("o");
					}
					else if (text == "o"){
						$("#like").text("x");
					}
					
				}
		);
			
		
	}
}

</script>
      -->




<div class="a" id="likeArea">

	<button type="button" id="btnLike">
		<img
			src="${ isLiked == true? './img/heart.jpg' : './img/empty_heart.png' }"
			id="like_img" height="50px" width="50px">
	</button>

	<span id="like_count">${like_count}</span>


</div>

$(document).ready(function(){ 
$('btnLike').click(function(){

$ajax({
url:"/like",
data: { command: 'like', 





)



 } 
 }



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



	<!-- 사이드바  -->
	<div>
		<p class="text-left">
			<button type="button" id="like"
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_myComment?member_id=${member.member_id}'"
				class="btn btn-primary" data-toggle="button" aria-pressed="false">
				좋아요</button>
		</p>

		<p class="text-left">
			<button type="button"
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_myComment?member_id=${member.member_id}'"
				class="btn btn-primary" data-toggle="button" aria-pressed="false">
				스크랩</button>
		</p>

		<p class="text-left">
			<button type="button"
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_myComment?member_id=${member.member_id}'"
				class="btn btn-primary" data-toggle="button" aria-pressed="false">
				신고</button>
		</p>

		<!-- 아이디 불러올 자리  -->




	</div>