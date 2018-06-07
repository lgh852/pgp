
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
<script src="<%=request.getContextPath()%>/resources/js/star4.js"></script>
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
</style>
</head>
<header class="blog-header py-3">
	<div class="row flex-nowrap justify-content-between align-items-center">
		<div class="col-4 pt-1"></div>
		<div class="col-4 text-center">
			<a class="blog-header-logo text-dark"
				href="<%=request.getContextPath()%>/"
				style="text-decoration: none; font-size: 27px; font-weight: 700; color: black;">
			느그집</a>
		</div>
		<div class="col-4 d-flex justify-content-end align-items-center">

		</div>
	</div>
</header>
<header class="blog-header py-3">
<div class="row">
        <div class="col-md-8"></div>
        <div class="col-md-4">
        	<ul class="nav">
        <a class="text-muted" href="#"> <svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="mx-3" style="color: black;">
					<circle cx="10.5" cy="10.5" r="7.5"></circle>
					<line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>

			</a>

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
					href="<%=request.getContextPath()%>/">로그아웃</a>
				
			
					<li class="nav-item dropdown" style="list-style: none"><a
						class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
						href="<%=request.getContextPath()%>/mypage/mp_main"
						id="navbarDropdownMenuLink" style="color: black;"
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
						</div></li>
				
			</c:if>
        </ul>
        </div>
      </div>

</header>



<div class="nav-scroller py-1 mb-2"
	style="background-color: #000000; border-bottom-color: #EAEAEA">
	<nav class="nav d-flex justify-content-between"
		style="width: 1100px; margin: auto;">
		<!-- style="width: 1100px; margin: auto;" -->
		<a class="p-2 text-muted"
			href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space=">사진</a>
		<a class="p-2 text-muted"
			href="<%=request.getContextPath()%>/furniture/furnitureRank">가구랭킹</a>
		<a class="p-2 text-muted"
			href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a> <a
			class="p-2 text-muted"
			href="<%=request.getContextPath()%>/story/storyboardForm">스토리</a> <a
			class="p-2 text-muted"
			href="<%=request.getContextPath()%>/manager/faqlist">FAQ</a> <a
			class="p-2 text-muted"
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
