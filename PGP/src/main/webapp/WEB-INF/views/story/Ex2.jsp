<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body style="padding-top: 0px">
	<nav class="site-header sticky-top py-1 ">
		<div class="border-bottom"
			style="background-color: white; border-bottom-color: #EAEAEA">
			<div
				class="container d-flex flex-column flex-md-row justify-content-between "
				style="">
				<div class="nav">
					<input type=hidden id="logck" value="${member_member_id}">
					<a class="nav-link disabled" href="<%=request.getContextPath()%>/"
						style="font-size: 27px; font-weight: 700; color: black;">느그집</a>
				</div>
				<div style="margin-left: 70%; position: fixed; width: 700px">
					<form method="post"
						action="<%=request.getContextPath()%>/board/boardserach"
						id="serachform" class="form-inline my-2 my-lg-0">
						<div
							style="margin: 0 auto; right: 1250px; top: 10px; position: absolute;">


							<div id="mainsearchmenu" class="form-control mr-sm-2"
								style="width: 200px; height: 36px; margin: 0 auto; position: relative"
								onclick="searchmenu()">
								<img
									src="<%=request.getContextPath()%>/resources/images/search.png"
									width="33px;" height="25px"> <span class="searchtiele">검색</span>
							</div>
							<ul id="searchlist" class="list-group "
								style="width: 200px; height: 50; display: none; right: 0px; top: 10px; position: absolute;">
								<li class="list-group-item listli" style="position: relative">
									<div style="position: absolute; bottom: 3px;"
										onclick="choicesearch(1)">
										<img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span
											id="srtitle1">사진 검색</span>
									</div>
								</li>
								<li class="list-group-item listli" style="position: relative">
									<div style="position: absolute; bottom: 3px;"
										onclick="choicesearch(2)">
										<img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span
											id="srtitle2">작성자 검색</span>
									</div>
								</li>
								<li class="list-group-item listli" style="position: relative">
									<div style="position: absolute; bottom: 3px;"
										onclick="choicesearch(3)">
										<img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span
											id="srtitle3">제목 검색</span>
									</div>
								</li>
								<li class="list-group-item listli" style="position: relative">
									<div style="position: absolute; bottom: 3px;"
										onclick="choicesearch(4)">
										<img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span
											id="srtitle4">내용 검색</span>
									</div>
								</li>
								<li class="list-group-item listli" style="position: relative">
									<div style="position: absolute; bottom: 3px;"
										onclick="choicesearch(5)">
										<img src="html.css/%EA%B3%B0.png" width="33px;" height="25px"><span
											id="srtitle5"> 전체 검색</span>
									</div>
								</li>

							</ul>
							<div id="serachs"
								style="display: none; width: 400px; right: 0px; top: 0px; position: absolute;">
								<img src="html.css/%EA%B3%B0.png" width="38px;" height="32px"
									onclick="searchmenu()"><input id="inputserach"
									class="form-control mr-sm-2" type="text" name="search"
									placeholder="" aria-label="Search">
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit" style="width: 60px">Search</button>
								<input type="hidden" name="choice" id="sear"
									style="width: 200px; height: 50;"> <input type="hidden"
									name="Alignment" value="board_idx"> <input
									type="hidden" name="room"> <input type="hidden"
									name="space">

							</div>

						</div>
					</form>
				</div>

				<ul class="nav justify-content-end">

					<c:if test="${user==null}">
						<li class="nav-item"><a class="nav-link active"
							href="<%=request.getContextPath()%>/member/loginform"
							style="color: black;">로그인</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/member/memberform"
							style="color: black;">회원가입</a></li>
					</c:if>

					<c:if test="${manager==null&&user==null}">
						<li class="nav-item"><a class="nav-link disabled"
							href="<%=request.getContextPath()%>/manager/managerloginform"
							style="color: black;">관리자</a></li>
					</c:if>

					<c:if test="${manager!=null}">
						<li class="nav-item"><a class="nav-link disabled"
							href="<%=request.getContextPath()%>/manager/main"
							style="color: black;">관리자</a></li>

					</c:if>
					<c:if test="${user!=null}">
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/" 
							style="color: black;">로그아웃</a></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle"
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
		<div class="border-bottom"
			style="background-color: #000000; border-bottom-color: #EAEAEA">

			<div
				class="container d-flex flex-column flex-md-row justify-content-between"
				style="font-size: 16px">

				<a class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space=">사진</a>
				<a class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/furniture/furnitureRank">가구랭킹</a>

				<a class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a> <a
					class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/story/storyboardForm">스토리</a> <a
					class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/manager/faqlist">FAQ</a> <a
					class="py-2 d-none d-md-inline-block fontcolor"
					href="<%=request.getContextPath()%>/manager/noticelist">공지사항</a>

				<c:if test="${manager!=null}">

					<a class="py-2 d-none d-md-inline-block fontcolor"
						href="<%=request.getContextPath()%>/manager/noticeinsert">공지사항
						입력하기</a>
					<a class="py-2 d-none d-md-inline-block fontcolor"
						href="<%=request.getContextPath()%>/manager/faqinsert">FAQ
						입력하기</a>
				</c:if>

			</div>

		</div>
	</nav>
	<main role="main" class="container">
	<div class="row" style="margin-top: 30px">

		<jsp:include page="${page}" />

	</div>
	</main>
</body>
</html>


<body style="padding-top: 0px">
   <nav class="site-header sticky-top py-1 ">
      <div class="border-bottom"
         style="background-color: white; border-bottom-color: #EAEAEA">
         <div
            class="container d-flex flex-column flex-md-row justify-content-between "
            style="">
            <div class="nav">
               <input type=hidden id="logck"value="${member_member_id}"> <a
                  class="nav-link disabled" href="<%=request.getContextPath()%>/"
                  style="font-size: 27px; font-weight: 700; color: black;">느그집</a>
            </div>
             <div style="margin-left: 70%;position: fixed; width: 700px"  >
               <form method="post" action="<%=request.getContextPath()%>/board/boardserach" id="serachform" class="form-inline my-2 my-lg-0">
    <div style="margin: 0 auto; right: 1250px; top: 10px; position: absolute;">


        <div id="mainsearchmenu" class="form-control mr-sm-2" style="width: 200px; height: 36px; margin: 0 auto; position: relative" onclick="searchmenu()">
            <img src="<%=request.getContextPath()%>/resources/images/search.png" width="33px;" height="25px">
            <span class="searchtiele">검색</span></div>
        <ul id="searchlist" class="list-group " style="width: 200px; height:50;display:none; right: 0px; top: 10px; position: absolute;">
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
        <div id= "serachs"style="display: none;  width:400px;right:0px; top: 0px; position: absolute;">
            <img src="html.css/%EA%B3%B0.png" width="38px;" height="32px" onclick="searchmenu()"><input id="inputserach"class="form-control mr-sm-2" type="text" name="search" placeholder="" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="width: 60px">Search</button>
        <input type="hidden" name="choice" id="sear" style="width:200px;height: 50;">
        <input type="hidden" name="Alignment" value="board_idx">
        <input type="hidden" name="room">
        <input type="hidden" name="space">
  
        </div>

    </div>
</form>
</div>
            
            <ul class="nav justify-content-end">
            
               <c:if test="${user==null}">
                  <li class="nav-item"><a class="nav-link active"
                     href="<%=request.getContextPath()%>/member/loginform"
                     style="color: black;">로그인</a></li>
                  <li class="nav-item"><a class="nav-link"
                     href="<%=request.getContextPath()%>/member/memberform"
                     style="color: black;">회원가입</a></li>
               </c:if>
               
                            <c:if test="${manager==null&&user==null}">
            <li class="nav-item"><a class="nav-link disabled"
                  href="<%=request.getContextPath()%>/manager/managerloginform"
                  style="color: black;">관리자</a></li>
            </c:if>
            
             <c:if test="${manager!=null}">
            <li class="nav-item"><a class="nav-link disabled"
                  href="<%=request.getContextPath()%>/manager/main"
                  style="color: black;">관리자</a></li>
            
            </c:if>
            

            
                  

               <c:if test="${user!=null}">
                  <li class="nav-item"><a class="nav-link"
                     href="<%=request.getContextPath()%>/" id="logout"
                     
                     style="color: black;">로그아웃</a></li>

                  <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle"
                     href="<%=request.getContextPath()%>/mypage/mp_main"
                     id="navbarDropdownMenuLink" style="color: black;"
                     data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        마이페이지 </a>
                     <div class="dropdown-menu"
                        aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/mp_main">모음</a> <a
                           class="dropdown-item" href="#">사진</a> <a class="dropdown-item"
                           href="#">스토리</a> <a class="dropdown-item" href="#">좋아요</a> <a
                           class="dropdown-item" href="#">스크랩</a> <a class="dropdown-item"
                           href="#">댓글</a>
                     </div></li>
               </c:if>
            </ul>


         </div>
      </div>
      <div class="border-bottom"
         style="background-color: #000000; border-bottom-color: #EAEAEA">

         <div
            class="container d-flex flex-column flex-md-row justify-content-between"
            style="font-size: 16px">

            <a class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space=">사진</a>
            <a class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/furniture/furnitureRank">가구랭킹</a>
           
               <a class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a> <a
               class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/story/storyboardForm">스토리</a> <a
               class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/manager/faqlist">FAQ</a> <a
               class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/manager/noticelist">공지사항</a>
               
               <c:if test="${manager!=null}">
               
               <a
               class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/manager/noticeinsert">공지사항 입력하기</a> 
               <a
               class="py-2 d-none d-md-inline-block fontcolor"
               href="<%=request.getContextPath()%>/manager/faqinsert">FAQ 입력하기</a>
            </c:if>
         
         </div>
            
      </div>
   </nav>
   <main role="main" class="container">
   <div class="row" style="margin-top: 30px">
   
   <jsp:include page="${page}" />
   
   </div>
   </main>
</body>
</html>




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







