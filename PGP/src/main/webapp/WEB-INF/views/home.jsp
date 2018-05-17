<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>home</title>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<!-- Custom styles for this template -->
	<link href="<%=request.getContextPath()%>/resources/css/offcanvas.css"
		rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/dist/summernote.css"
		rel="stylesheet">
	<style>
	.margin {
		margin: 0 auto;
	}
	</style>
	<style>
    .ds {
        display: none;
    }

    .listli {
        position: relative;
        height: 36px;
    }

    .searchtiele {
        position: absolute;
        left: 60px;
    }

    .imgmenu {
        position: absolute;
        left: 7px;

    }

</style>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<a class="navbar-brand mr-auto mr-lg-0" href="#">오늘의집</a>
		<button class="navbar-toggler p-0 border-0" type="button"
			data-toggle="offcanvas">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input type=hidden value="${member_member_id}">
		<div class="navbar-collapse offcanvas-collapse"
			id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/">홈 <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/photo/photofeed">사진</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space=">앙~~~기모띄</a></li>
				<li class="nav-item"><a class="nav-link" href="#">가구랭킹</a></li>
					<a href="<%=request.getContextPath()%>/photo/photoList">앙~~~기모띄</a></li>
				<li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/furniture/furnitureRank">가구랭킹</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/manager/noticelist">공지사항</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/manager/faqlist">질문과답변</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a></li>

				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/manager/managerloginform">관리자.</a>
				</li>
				<c:if test="${user!=null}">

					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/" id ="logout">로그아웃</a></li>

				</c:if>
				<c:if test="${user==null}">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/member/loginform">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/member/memberform">회원가입</a></li>
				</c:if>


				<c:if test="${manager!=null}">


					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/manager/noticeinsert">
							공지사항 입력하기</a></li>
				</c:if>

				<c:if test="${user!=null}">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="http://example.com"
						id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"></a>
						<div class="dropdown-menu" aria-labelledby="dropdown01">



							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/mypage/mp_main">마이페이지</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>

						</div></li>
				</c:if>


			</ul>
			<form method="post" action="<%=request.getContextPath()%>/board/boardserach" id="serachform" class="form-inline my-2 my-lg-0">
    <div>


        <div id="mainsearchmenu" class="form-control mr-sm-2" style="width: 200px; height: 36px; margin: 0 auto; position: relative" onclick="searchmenu()">
            <img src="html.css/%EA%B3%B0.png" width="33px;" height="25px">
            <span class="searchtiele">검색</span></div>
        <ul id="searchlist" class="list-group " style="width: 200px; display: none;">
            <li class="list-group-item listli" style="position: relative">
                <div style="position: absolute;bottom: 3px;" onclick="choicesearch(1)"><img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span id="srtitle1">사진 검색</span></div>
            </li>
            <li class="list-group-item listli" style="position: relative">
                <div style="position: absolute;bottom: 3px;" onclick="choicesearch(2)"><img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span id="srtitle2">작성자 검색</span></div>
            </li>
            <li class="list-group-item listli" style="position: relative">
                <div style="position: absolute;bottom: 3px;" onclick="choicesearch(3)"><img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span id="srtitle3">제목 검색</span></div>
            </li>
            <li class="list-group-item listli" style="position: relative">
                <div style="position: absolute;bottom: 3px;" onclick="choicesearch(4)"><img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span id="srtitle4">내용 검색</span></div>
            </li>
            <li class="list-group-item listli" style="position: relative">
                <div style="position: absolute;bottom: 3px;" onclick="choicesearch(5)"><img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span id="srtitle5"> 전체 검색</span></div>
            </li>
            
        </ul>
        <div id= "serachs"style="display: none">
            <img src="html.css/%EA%B3%B0.png" width="38px;" height="32px" onclick="searchmenu()"><input id="inputserach"class="form-control mr-sm-2" type="text" name="search" placeholder="" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        <input type="hidden" name="choice" id="sear">;
        <input type="hidden" name="Alignment" value="board_idx">
        <input type="hidden" name="room">
        <input type="hidden" name="space">
  
        </div>

    </div>
</form>

		</div>
	</nav>

	<div class="nav-scroller bg-white box-shadow">
		<nav class="nav nav-underline">
			<a class="nav-link active" href="#">Dashboard</a> <a class="nav-link"
				href="#"> Friends <span
				class="badge badge-pill bg-light align-text-bottom">27</span>
			</a> <a class="nav-link" href="#">Explore</a> <a class="nav-link"
				href="#">Suggestions</a> <a class="nav-link" href="#">Link</a> <a
				class="nav-link" href="#">Link</a> <a class="nav-link" href="#">Link</a>
			<a class="nav-link" href="#">Link</a> <a class="nav-link" href="#">Link</a>
		</nav>
	</div>

	<main role="main" class="container">
		
	<jsp:include page="${page}" />
	
	 </main>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/holder.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/offcanvas.js"></script>
	<script src="<%=request.getContextPath()%>/resources/dist/summernote.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/board1.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/member.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/photolist1.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/sidebar.js"></script>
	


</body>
</html>
