<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="https://fonts.googleapis.com/css?family=Sunflower:300"
	rel="stylesheet">
<style type="text/css">
.background_picture {
	margin-top: 50px;
	width: 1100px;
	height: 250px;
	background-image: url("../../../resources/images/heart1.png");
	background-color: aqua;
}

p {
	font-family: 'Sunflower', sans-serif;
}

ul.justify-content-center {
	font-size: 30px;
	font-family: 'Sunflower', sans-serif;
}
</style>




<div class="background_picture ">

	<div id="userinfo_picture"
		style="width: 28%; height: 100%; float: left;">
		<img
			src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}"
			class="rounded-circle" width="170px" height="170px"
			style="margin-left: 80px; margin-top: 45px;">
	</div>
	<div id="userinfo_user"
		style="width: 65%; height: 50%; float: left; margin-top: 60px; padding-botton: 30px;">
		<p class="user_name" style="height: 60px; font-size: 45px;">${member.member_id}</p>
		<p class="user-set" style="">
			<button type="button" class="btn btn-outline-secondary"
				data-toggle="button" aria-pressed="false"
				style="width: 100px; font-size: 20px; text-align: right;"
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_update?member_id=${member.member_id}'">
				<img
					src="<%=request.getContextPath()%>/resources/images/setbutton.png"
					width="20px" height="20px">&nbsp 설정
			</button>
		</p>

	</div>
	<div id="userinfo_share" style="width: 7%; height: 100%; float: left;"></div>

</div>

<div class="menu_nav"
	style="width: 1100px; height: 100px; margin-top: 15px;">

	<ul class="nav justify-content-center nav-tabs"
		style="text-align: center; padding-top: 30px;">
		<li class="nav-item"><a class="nav-link active" href="#">모음</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_idx=${member.member_idx}">사진</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link" href="#">
		스토리</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link" 
		href="<%=request.getContextPath()%>/mypage/mp_myLike?member_idx=${member.member_idx}">
		좋아요</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_scrap?member_id=${member.member_id}">스크랩</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myComment?member_id=${member.member_id}">댓글</a>
		</li>
	</ul>


</div>

<div class="container">
	<!-- 사진 체크해서 하나도 없으면 사진 올려달라고 하고 있으면 쭈욱 뽑아주기  -->
	<div class="user_picture"
		style="width: 100px; height: 20px; margin-top: 50px; float: left;">
		사진
		<c:if test="${ck=='n'}">0</c:if>
		<c:if test="${ck=='y'}">${photo_count}
	</div>
	<div class="all_picture"
		style="width: 70px; height: 20px; display: inline-block; margin-left: 500px; margin-top: 50px;">
		<a
			href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_id=${member.member_id}">
			전체보기</a>
	</div>
	</c:if>
</div>

<div class="user_summary"
	style="float: left; border-color: #dcdcdc; border-style: dashed; border-width: 1px; border-radius: 3px; width: 700px; height: 300px; margin-top: 10px; text-align: center;">
	<c:if test="${ck=='n'}">
		<a href="<%=request.getContextPath()%>/board/boardFrom">
			<p class="abc" style="padding-top: 110px; font-size: 20px;">
				<img src="<%=request.getContextPath()%>/resources/images/add.png"
					width="20px" height="20px"> 첫 사진을 올려보세요!
			</p>
		</a>
	</c:if>
	<c:if test="${ck=='y'}">
	
	<c:forEach var="photo" items="${boardLatestPhoto}" >
	<img src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}" width="200px" height="200px">
	</c:forEach>
		
		<%-- <a href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${board_idx}">
	</a> --%>
	</c:if>
</div>

<div class="section"
	style="width: 80px; height: 300px; background-color: orange; float: left; margin-top:10px;">
	여기 섹션 나눌거야</div>
<div class="user_side"
	style="width: 300px; height: 300px; background-color: yellow; float: left; margin-top:10px;">

	<div class="scrap"
		style="width: 250px; height: 90px; background-color: red; margin-top: 40px; margin-left: 20px;"></div>
	<div class="like"
		style="width: 250px; height: 90px; background-color: blue; margin-top: 30px; margin-left: 20px; float: inherit;"></div>

</div>
</div>









