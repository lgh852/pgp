
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>home</title>
<!-- r글씨체 -->
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower|Stylish" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/holder.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/offcanvas.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/dist/summernote.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/board2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/member.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/photolist2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/list5.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/star2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/star3.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/members23.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/kakao3.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/storyboard.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/storylike55.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/storyreport3.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/storyreport5.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>


<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resources/css/offcanvas.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/dist/summernote.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300"
	rel="stylesheet">
<style>
.fontcolor {
	color: /* #878787 */ #f8f9fa;
}
</style>
<style>
.botton_common {
	display: inline-block;
	width: 24%;
	height: 100%;
	margin-left: 3px;
	margin-top: 3px;
}

.botton_center {
	text-align: center;
}

.botton_center p {
	font-size: 18;
	font-weight: 600;
	margin-top: 6px;
	margin-bottom: 3px;
	color: black;
}

.botton_center span {
	font-size: 14;
	font-weight: 200;
	color: gray;
}

.botton_center a {
	text-decoration: none
}

#latelybox {
	display: none;
}

.text-muted {
	color: white !important;
}

#homeName{
font-family: 'Gamja Flower', cursive;
text-decoration: none;
}
div>nav>a{
/* font-size: 25px; */

}


</style>
</head>
<header class="blog-header py-3">
	<div class="row flex-nowrap justify-content-between align-items-center">
		<div class="col-4 pt-1"></div>
		<div class="col-4 text-center">
			<a class="blog-header-logo text-dark" id="homeName"
				href="<%=request.getContextPath()%>/"
				style="text-decoration: none; font-size: 50px; font-weight: 700; color: black;font-family: 'Gamja Flower', cursive;">
				느그집</a>
		</div>
		<div class="col-4 d-flex justify-content-end align-items-center">

		</div>
	</div>
</header>
<header class="blog-header py-3">
	<div class="row" style="margin: auto; width: 1400px;">
		<div class="col-md-8"></div>
		<div class="col-md-4">
			<!--form 지워야함   -->
			<form method="post"
				action="<%=request.getContextPath()%>/board/boardserach"
				id="serachform" class="form-inline mt-2 mt-md-0">

				<div style="margin-left: 40px;">

					<ul id="searchlist" class="list-group "
						style="width: 120px; display: none;">
						<li class="list-group-item listli" style="position: relative">
							<div style="position: absolute; bottom: 3px;"
								onclick="choicesearch(1)"id="srtitle1">사진 검색</div>
						</li>
						<li class="list-group-item listli" style="position: relative">
							<div style="position: absolute; bottom: 3px;"
								onclick="choicesearch(2)"id="srtitle2">작성자 검색</div>
						</li>
						<li class="list-group-item listli" style="position: relative">
							<div style="position: absolute; bottom: 3px;"
								onclick="choicesearch(3)"id="srtitle3">제목 검색</div>
						</li>
						<li class="list-group-item listli" style="position: relative">
							<div style="position: absolute; bottom: 3px;"
								onclick="choicesearch(4)"id="srtitle4">내용 검색</div>
						</li>
						<li class="list-group-item listli" style="position: relative">
							<div style="position: absolute; bottom: 3px;"
								onclick="choicesearch(5)"id="srtitle5">전체 검색</div>
						</li>

					</ul>



					<div id="serachs" style="display: none;">

						<input id="inputserach" class="form-control mr-sm-2" type="text"
							name="search" placeholder="" aria-label="Search"
							style="height: 31px; width: 170px;">
						<button class="btn btn-outline-secondary my-2 my-sm-0"
							type="submit"
							style="margin: auto; height: 31px; padding-bottom: 0px; padding-top: 0px;">Search</button>
						<input type="hidden" name="choice" id="sear"> <input
							type="hidden" name="Alignment" value="board_idx"> <input
							type="hidden" name="room"> <input type="hidden"
							name="space">

					</div>

				</div>
			</form>
		</div>
		<!--d여기까지  -->
	</div>
	</div>
</header>

<header class="blog-header py-3">
	<div class="row" style="margin: auto; width: 1400px;">
		<div class="col-md-8"></div>
		<div class="col-md-4">
			<ul class="nav">
				<ul style="list-style: none;">
					<li class="nav-item dropdown" style="text-decoration: none;">
						<a class="dropdown-toggle btn btn-sm btn-outline-secondary"
						href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 검색 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#" onclick="choicesearch(1)">사진
								검색</a> <a class="dropdown-item" href="#" onclick="choicesearch(2)">작성자
								검색</a> <a class="dropdown-item" href="#" onclick="choicesearch(3)">제목
								검색</a> <a class="dropdown-item" href="#" onclick="choicesearch(4)">내용
								검색</a> <a class="dropdown-item" href="#" onclick="choicesearch(5)">전체
								검색</a>
							
						</div>
					</li>
				</ul>

				<c:if test="${user==null}">
					<a class="btn btn-sm btn-outline-secondary"
						href="<%=request.getContextPath()%>/member/loginform">로그인 </a>
					<a class="btn btn-sm btn-outline-secondary"
						href="<%=request.getContextPath()%>/member/memberform">회원가입</a>
				</c:if>
				<c:if test="${manager==null&&user==null}">
					<a class="btn btn-sm btn-outline-secondary"
						href="<%=request.getContextPath()%>/manager/managerloginform">관리자</a>
				</c:if>
				<c:if test="${manager!=null}">
					<a class="btn btn-sm btn-outline-secondary"
						href="<%=request.getContextPath()%>/manager/main">관리자</a>
				</c:if>
				<c:if test="${user!=null}">
					<a class="btn btn-sm btn-outline-secondary" id="logout"
						style="height: 31px;" href="<%=request.getContextPath()%>/">로그아웃</a>


					<li class="nav-item dropdown"
						style="height: 31px; list-style: none;">
						<!--<a class="nav-link">  --> <a
						class="dropdown-toggle btn btn-sm btn-outline-secondary"
						id="navbarDropdownMenuLink"
						href="<%=request.getContextPath()%>/mypage/mp_main"
						id="navbarDropdownMenuLink" style="text-decoration: none;"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							마이페이지 </a>

						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/mypage/mp_main">모음</a> <a
								class="dropdown-item" href="#">사진</a> <a class="dropdown-item"
								href="#">스토리</a> <a class="dropdown-item" href="#">좋아요</a> <a
								class="dropdown-item" href="#">스크랩</a> <a class="dropdown-item"
								href="#">댓글</a>
						</div>
					</li>

				</c:if>
			</ul>
		</div>
	</div>

</header>


<!-- <div class="nav-scroller py-1 mb-2" -->
<div class="nav-scroller  "
	style="background-color: #000000; border-bottom-color: #EAEAEA">
	<nav class="nav d-flex justify-content-between"
		style="width: 1100px; margin: auto;">
		<!-- style="width: 1100px; margin: auto;" -->
		<a class="p-2 text-muted" style="text-decoration: none;"
			href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space=">사진</a>
		<a class="p-2 text-muted"style="text-decoration: none;"
			href="<%=request.getContextPath()%>/furniture/furnitureRank">가구랭킹</a>
		<a class="p-2 text-muted"style="text-decoration: none;"
			href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a> <a
			class="p-2 text-muted"style="text-decoration: none;"
			href="<%=request.getContextPath()%>/story/storyboardForm">스토리</a> <a
			class="p-2 text-muted"style="text-decoration: none;"
			href="<%=request.getContextPath()%>/manager/faqlist">FAQ</a> <a
			class="p-2 text-muted"style="text-decoration: none;"
			href="<%=request.getContextPath()%>/manager/noticelist">공지사항</a>

	</nav>

</div>
<div class="mb-3"></div>
<div class="mb-3"></div>


<main role="main" class="container">
<div class="row" style="margin-top: 30px">

	<jsp:include page="${page}" />

</div>
</main>

</body>
</html>
