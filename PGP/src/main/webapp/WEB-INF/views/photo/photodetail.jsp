<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta http-equiv="X-UA-Compatible" content=&qquot;IE=edge />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<script type='text/javascript'>
 
    Kakao.init('63e0d0643d065b515683b9455c2f97b9');
    
    Kakao.Story.createShareButton({
      container: '#kakaostory-share-button',
      url: '<%=request.getContextPath()%>/mypage/mp_main',
      text: '카카오 개발자 사이트로 놀러오세요! #개발자 #카카오 :)'
    });
  
</script>


<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<!doctype html>
<script>
function tagsclick(e) {
      
   //클릭이 되면 나는 조회수를 증가 시키겠다 
   //어떤 tag번호 값을 가지고 증가시키냐 
      /* var tagIdx = $('#tagIdx').val(); */
      var tagIdx=e;
      $.ajax({
           type : 'GET',
           url :'/p/photo/photodetailtagcnt',
           dataType : 'text',
             data:{
             tag_idx : tagIdx
             },
             success : function(data) {
                if(data>0){
                   alert('성공'+data);
                   }
                else{
                   alert('실패'+data);
                }
                
             }    
      });
   
}



</script>
<style>
.taginfo {
	border: 1px solid black;
	width: 250px;
	height: 70px;
	position: absolute;
}

.reinfo {
	position: absolute;
	right: 5px;
}

.inner h4 {
	position: absolute;
	left: 10px;
	top: 10px;
}

.t_url {
	font-size: 3px;
}
</style>

<style>
#reportPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	right: 250px;
	top: 200px;
	background: #fff;
}

#reportPopup button {
	cursor: pointer;
}

#scrapPopup {
	padding: 20px;
	border: 4px solid #ddd;
	position: absolute;
	left: 250px;
	top: 200px;
	background: #fff;
}

#scrapPopup button {
	cursor: pointer;
}

#inputScrapFolder {
	position: absolute;
	left: 200px;
	top: 300px;
}
/* 
ul.list-group {
	list-style: none;
	margin: 10px;
	padding: 0px;
	max-width: 250px;
	max-height: 50px;
	width: 100%;
	text-align: center;
} */
</style>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Checkout example for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="../../../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>

<body class="bg-light">
   <a class="btn btn-primary" href="<%=request.getContextPath()%>/board/boardPhtoTagForm?board_idx=${board.board_idx}" role="button">페이지</a>
                  
	<div class="container">
		<div class="py-5 text-center"></div>

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4"
				style="border: 1px solid; border-radius: 4px; border-color: slategray; height: 400px;">
				<div class="contents">
					<h4 class="d-flex justify-content-between align-items-center mb-3"
						style="padding-top: 15px;">
						<span class="text-muted">카테고리</span>

						<div id="report" style="z-index: 30">

							<a onclick="reportPopup();"><span
								class="badge badge-secondary badge-pill">신고</span></a>
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


								<input type="hidden" id="storyboard_idx"
									value="${storyboard_idx}"> <input type="hidden"
									id="board_idx" value="${board.board_idx}"> <input
									type="hidden" id="member_idx" value="${member.member_idx}">


							</div>
						</div>
					</h4>



					<div class="buttons" style="z-index: 30">
						<div
							style="height: 60px; width: 100%; text-align: center; margin-top: 20px;">

							<div id="like" class="likeArea">
								<a onclick="likeClick();"> <c:if test="${likecheck==null}">

										<div id="likeid" class="btn btn-outline-danger "
											style="float: left; width: 46%; height: 45px; padding-top: 10px;">
											좋아요 <span class="countcount" id=likecnt
												style="padding-left: 20px;">${boardInfo.board_like}</span>
										</div>

									</c:if> <c:if test="${likecheck!=null}">

										<div id="likeid" class="btn btn-danger "
											style="float: left; width: 46%; height: 45px; padding-top: 10px;">
											좋아요 <span class="countcount" id=likecnt
												style="padding-left: 20px;">${boardInfo.board_like}</span>
										</div>

									</c:if>
								</a> <input type="hidden" id="board_idx" value="${board_idx}">
								<input type="hidden" id="member_idx" value="${member_idx}">

							</div>

							<div id="scrap" class="scrapArea">
								<a onclick="scrapPopup();"> <c:if test="${scrapck==null}">
										<div id="scrapid" class="btn btn-outline-info"
											style="display: inline-block; margin-left: 20px; width: 46%; height: 45px; padding-top: 10px">
											스크랩 <span class="count" id="scrapCnt"
												style="padding-left: 20px;">${boardInfo.board_scrap}</span>
										</div>
									</c:if> <c:if test="${scrapck!=null}">
										<div id="scrapid" class="btn btn-info"
											style="display: inline-block; margin-left: 20px; width: 46%; height: 45px; padding-top: 10px">
											스크랩 <span class="count" id="scrapCnt"
												style="padding-left: 20px;">${boardInfo.board_scrap}</span>
										</div>
									</c:if>

								</a>
								<div id="scrapPopup">
									<ul class="list-group scrapList" id="scrapli">

										<c:forEach var="scrapNameList" items="${scrapNameList}"
											varStatus="status">
											<li>
												<button type="button"
													class="scrapSuccess${status.count} list-group-item list-group-item-action active"
													onclick="scrapButton(${status.count})">${scrapNameList.scrap_name}</button>
											</li>

										</c:forEach>
									</ul>

									<div id="inputScrapFolder">

										<input type="text" id="scrapFolderName"
											placeholder="스크랩북 이름을 입력해줘잉" />
										<button type="button" class="add">추가</button>
										<input type="hidden" id="member_idx"
											value="${board.member_idx}">

										<button type="button" id="close">닫기</button>

									</div>



									<input type="hidden" class="listnumber"
										value="${fn:length(scrapNameList)}"> <input
										type="hidden" id="board_idx" value="${board.board_idx}">
									<input type="hidden" id="member_idx"
										value="${board.member_idx}"> <input type="hidden"
										id="scrap_idx" value="${scrapInfo.scrap_idx}">
								</div>
							</div>
						</div>
					</div>

					<div class="sharing_info">
						<div class="label" style="padding-top: 10px;">공유하기</div>


						<div id="share_method" class="ui-content-share"
							style="margin-top: 15px;">
							<script src="/js/kakaolink.js"></script>
							<div id="kakaostory-share-button"></div>

							<!--여기에 공유버튼들 추가하면 된다-->

						</div>
					</div>
				</div>
				<!--공유하기 까지 div-->


				<div class="wrap"
					style="margin-top: 40px; border-top: 1px solid; border-top-color: slategray;">

					<a href="<%=request.getContextPath()%>/mypage/mp_main">

						<div class="profile_image" style="float: left; padding-top: 20px;">

							<img
								src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}"
								class="rounded-circle" width="50px" height="60px"
								style="margin-left: 20px; margin-top: 10px;">
						</div>

						<div class="id"
							style="display: inline-block; padding-left: 70px; text-align: center; height: 60px; margin-top: 20px;">
							<h4 class="display-4">${member.member_id}</h4>
						</div>


					</a>


				</div>



			</div>
			<!-- 여기가 사이드 바 닫히는 div-->



			<script>
function tagsclick(e) {
      
   //클릭이 되면 나는 조회수를 증가 시키겠다 
   //어떤 tag번호 값을 가지고 증가시키냐 
      /* var tagIdx = $('#tagIdx').val(); */
      var tagIdx=e;
       alert("호잇"+tagIdx);
      $.ajax({
           type : 'GET',
           url :'/p/photo/photodetailtagcnt',
           dataType : 'text',
             data:{
             tag_idx : tagIdx
             },
             success : function(data) {
                if(data>0){
                   alert('성공이요!'+data);
                   }
                else{
                   alert('실패당'+data);
                }
                
             }    
      });
   
}

</script>

			<style>
.taginfo {
	border: 1px solid black;
	width: 250px;
	height: 70px;
	position: absolute;
}

.reinfo {
	position: absolute;
	right: 5px;
}

.inner h4 {
	position: absolute;
	left: 10px;
	top: 10px;
}

.t_url {
	font-size: 3px;
}
</style>

			<style>
.serchbox {
	width: 370px;
	height: 60px;
	border: 2px solid black;
	padding-top: 10px;
	padding-left: 20px;
	border-radius: 10px 10px 10px 10px;
	position: absolute;
}

.none {
	display: none;
}

.block {
	display: block;
}

.imgcenter {
	position: relative;
}

.viewbox {
	width: 40px;
	height: 40px;
	border: 0px solid black;
	border-radius: 100px 100px 100px 100px;
	position: relative;
	background-color: green;
	text-align: center;
}

.list-group-item-warning {
	color: #f8f9fa;
	background-color: #007bff;
}
</style>
			<div class="row featurette" style="width: 100%; margin: auto;">
				<div class="col-md-7">
					<h2 class="featurette-heading" style="text-align: center">[
						${board.board_title} ]</h2>
					<div style="text-align: right">ID:</div>
					&nbsp &nbsp &nbsp
					<div style="text-align: right">
						<span class="text-muted"> Date: <fmt:formatDate
								pattern="yyyy년 MM월 dd일 HH:mm:ss" value="${board.board_regdate}" /></span>
					</div>


					<p class="lead">${board.board_contents}</p>
					<div style="font-weight: bold; text-align: right;">
						조회수 : ${board_cnt_view} &nbsp &nbsp 댓글 수 : ${commentCnt} <span
							class="text-muted"> <c:if
								test="${board.member_idx==user.member_idx}">
								<!-- 수정기능 -->
								<a role="button" style="" class="btn btn-success"
									href="<%=request.getContextPath()%>/photo/updatePhotodetail?board_idx=${board.board_idx}">수정
								</a>
								<!-- 삭제기능 -->
								<a class="btn btn-danger"
									href="<%=request.getContextPath()%>/photo/photofeedAllDelete?board_idx=${board.board_idx}"
									role="button">삭제 </a>
							</c:if></span>
					</div>



					<div class="imgcenter">
						<div id="imgbox" class="border"
							style="max-width: 100%; width: 700px; margin: 0 auto;">
							<img width="100%" height="100%" id="imgtagbox"
								src="<%=request.getContextPath()%>/resources/BoardPhoto/${photoName}"
								alt=""
								style="max-height: 600px; min-height: 600px; margin: 0 auto;"
								class="border-0 img-thumbnail">
						</div>

						<c:forEach items="${urlList}" var="urlList" varStatus="status">
							<div id="viewbox${status.count}" class="check viewbox"
								style="left: ${urlList.tag_position_x}px; top: ${urlList.tag_position_y}px;position: absolute ">
								<a href="#" data-toggle="modal"
									data-target=#tagurlbox${status.count}>x</a> <input
									type="hidden" id="url${status.count}"
									value="${urlList.tag_url}">
							</div>
						</c:forEach>

						<c:forEach items="${urlList}" var="urlList" varStatus="status">
							<div class="modal fade" id="tagurlbox${status.count}"
								tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">태그</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<a id="t_url${status.count}" class="t_url"
												href="${urlList.tag_url}"
												onclick="tagsclick(${urlList.tag_idx})" target="_blank">${urlList.tag_url}
												: ${urlList.tag_idx }</a> <input type="hidden" id="tagIdx"
												class="tagno" value="${urlList.tag_idx }">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">확인!</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!--사진까지 ^^^^ -->

					<div>
						<!--  댓글 쓰기 기능 -->
						<div style="width: 100%">
							<form method="post" class="card p-2">
								<div class="input-group">
									<input name="board_comment_contents" type="text"
										class="form-control" placeholder="댓글을 입력해보세요.">

									<div class="input-group-append">
										<button type="submit" class="btn btn-secondary">send</button>
									</div>
								</div>

								<!--댓글 리스트  -->
								<ul class="list-group mb-3" style="width: 100%">
									<c:forEach var="c1" items="${Commentlist}">
										<li
											class="list-group-item d-flex justify-content-between lh-condensed"
											style="width: 100%">
											<div>
												<h6 class="my-0">${c1.board_comment_contents}</h6>
												<small class="text-muted">ID:${c1.member_id} &nbsp
													&nbsp<fmt:formatDate pattern="yyyy년 MM월 dd일 HH:mm:ss"
														value="${c1.board_comment_regdate}" />
												</small>
											</div> <span class="text-muted"><c:if
													test="${c1.member_id==user.member_id}">
													<td width="50px"><a
														href="<%=request.getContextPath()%>/photo/photoCommentDelete?board_comment_idx=${c1.board_comment_idx}&board_idx=${c1.board_idx}">삭제</a></td>
												</c:if></span>
										</li>
									</c:forEach>
								</ul>
							</form>
						</div>
						<!--  카테고리 추천사진 -->
						<p style="font-weight: bold">카테고리 추천 사진</p>
						<div class="list-group-item list-group-item-secondary"
							style="height: 250px;">
							<table>
								<c:forEach var="popular" items="${popularPhotoList}">
									<div style="padding: 20px 25px 20px; float: left;">
										<img
											src="<%=request.getContextPath()%>/resources/BoardPhoto/${popular.photo_name}"
											width="160px" height="160px"> <br>
									</div>
								</c:forEach>
							</table>
						</div>
						<div style="height: 50px"></div>
					</div>





				</div>
				<div class="col-md-5">
					<div class="col-lg-4" style="position: fixed;border: solid #00000024;border-radius: 20px;margin-top: 120px;padding-top: 20px;">
						<a href="<%=request.getContextPath()%>/mypage/mp_main"> <img
							class="rounded-circle"
							src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}"
							alt="<%=request.getContextPath()%>/resources/images/user.png"
							width="140" height="140">
							<h2 style="color: #00000066;">ID: ${member.member_id}</h2></a> <a
							onclick="reportPopup();" class="btn btn-warning" role="button"
							style="border-radius: 40px; padding: auto;">신고</a>

						<p>
						<div class="buttons" style="z-index: 30">
							<div
								style="height: 60px; width: 100%; text-align: center; margin-top: 20px;">

								<div id="like" class="likeArea">
									<a onclick="likeClick();"> <c:if test="${likecheck==null}">

											<div id="likeid" class="btn btn-outline-danger "
												style="float: left; width: 46%; height: 45px; padding-top: 10px;">
												좋아요 <span class="countcount" id=likecnt
													style="padding-left: 20px;">${boardInfo.board_like}</span>
											</div>

										</c:if> <c:if test="${likecheck!=null}">

											<div id="likeid" class="btn btn-danger "
												style="float: left; width: 46%; height: 45px; padding-top: 10px;">
												좋아요 <span class="countcount" id=likecnt
													style="padding-left: 20px;">${boardInfo.board_like}</span>
											</div>

										</c:if>
									</a> <input type="hidden" id="board_idx" value="${board_idx}">
									<input type="hidden" id="member_idx" value="${member_idx}">

								</div>

								<div id="scrap" class="scrapArea">
									<a onclick="scrapPopup();"> <c:if test="${scrapck==null}">
											<div id="scrapid" class="btn btn-outline-info"
												style="display: inline-block; margin-left: 20px; width: 46%; height: 45px; padding-top: 10px">
												스크랩 <span class="count" id="scrapCnt"
													style="padding-left: 20px;">${boardInfo.board_scrap}</span>
											</div>
										</c:if> <c:if test="${scrapck!=null}">
											<div id="scrapid" class="btn btn-info"
												style="display: inline-block; margin-left: 20px; width: 46%; height: 45px; padding-top: 10px">
												스크랩 <span class="count" id="scrapCnt"
													style="padding-left: 20px;">${boardInfo.board_scrap}</span>
											</div>
										</c:if>

									</a>
									<div id="scrapPopup">
										<ul class="list-group scrapList" id="scrapli">

											<c:forEach var="scrapNameList" items="${scrapNameList}"
												varStatus="status">
												<li>
													<button type="button"
														class="scrapSuccess${status.count} list-group-item list-group-item-action active"
														onclick="scrapButton(${status.count})">${scrapNameList.scrap_name}</button>
												</li>

											</c:forEach>
										</ul>

										<div id="inputScrapFolder">

											<input type="text" id="scrapFolderName"
												placeholder="스크랩북 이름을 입력해줘잉" />
											<button type="button" class="add">추가</button>
											<input type="hidden" id="member_idx"
												value="${board.member_idx}">

											<button type="button" id="close">닫기</button>

										</div>



										<input type="hidden" class="listnumber"
											value="${fn:length(scrapNameList)}"> <input
											type="hidden" id="board_idx" value="${board.board_idx}">
										<input type="hidden" id="member_idx"
											value="${board.member_idx}"> <input type="hidden"
											id="scrap_idx" value="${scrapInfo.scrap_idx}">
									</div>
								</div>
							</div>
						</div>

						<div class="sharing_info">
							<div class="label" style="padding-top: 10px;">
								공유하기 <img
									alt="<%=request.getContextPath()%>/resources/images/share2.png"
									src="<%=request.getContextPath()%>/resources/images/share2.png"
									height="32px" width="32px">



							</div>


							<div id="share_method" class="ui-content-share"
								style="margin-top: 15px;">
								<script src="/js/kakaolink.js"></script>
								<div id="kakaostory-share-button"></div>

								<!--여기에 공유버튼들 추가하면 된다-->

							</div>
						</div>


						<p>
							<a class="btn btn-secondary" href="#" role="button">View
								details »</a>
						</p>



					</div>
					<!--공유하기 까지 div-->


				</div>
			</div>



			<hr class="featurette-divider" style="width: 100%">













		</div>
	</div>

	<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">&copy; 2017-2018 Company Name</p>
		<ul class="list-inline">
			<li class="list-inline-item"><a href="#">Privacy</a></li>
			<li class="list-inline-item"><a href="#">Terms</a></li>
			<li class="list-inline-item"><a href="#">Support</a></li>
		</ul>
	</footer>


	</div>



	<script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
</body>
</html>
