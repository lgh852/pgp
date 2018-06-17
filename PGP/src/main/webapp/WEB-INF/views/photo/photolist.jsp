<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- r글씨체 -->
<link

	href="https://fonts.googleapis.com/css?family=Cute+Font|Gamja+Flower|Nanum+Gothic|Stylish"

	rel="stylesheet">

<style>

.container {
	/* font-family: 'Sunflower', sans-serif; */
	font-family: 'Nanum Gothic', sans-serif;
	font-weight: bold;
}

</style>

<div class="container">
	<div class="row border-bottom border-top" style="text-align: center;">
		<div class="col-sm">
			<div class="dropdown border-right">
				<button class="btn dropdown-toggle"
					style="background-color: white; width: 150px;" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					<p style="font-size: 20px;">정렬</p>
					<span> <c:choose>
							<c:when test="${Alignment =='board_idx'}">
                    최신순
                </c:when>
							<c:when test="${Alignment =='board_cnt'}">
                   인기순
             </c:when>
							<c:when test="${Alignment =='board_like'}">
                    좋아요
             </c:when>
						</c:choose></span>
				</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item"
						href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=${room}&space=${space}">
						<h6>최신순</h6>
					</a> <a class="dropdown-item"
						href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_cnt&room=${room}&space=${space}">
						<h6>인기순</h6>
					</a> <a class="dropdown-item"
						href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_like&room=${room}&space=${space}">
						<h6>좋아요순</h6>
					</a>

				</div>
			</div>
		</div>
		<div class="col-sm">
			<button class="btn dropdown-toggle"
				style="background-color: white; width: 150px;" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<p style="font-size: 20px;">공간</p>
				<span style="text-align: center; color: black; font-weight: 300px;">
					<c:choose>
						<c:when test="${room=='1'}">
                    원룸
                </c:when>
						<c:when test="${room=='2'}">
                    거실
                </c:when>
						<c:when test="${room=='3'}">
                 침실
                </c:when>
						<c:when test="${room=='4'}">
                    키친
                </c:when>
						<c:when test="${room=='5'}">
                    욕실
                </c:when>
						<c:when test="${room=='6'}">
                 아이방
                </c:when>
						<c:when test="${room=='7'}">
                 드레스룸
                </c:when>
						<c:when test="${room=='8'}">
                    서재&작업실
                </c:when>
						<c:when test="${room=='9'}">
                    침실
                </c:when>
						<c:when test="${room=='10'}">
                    베란다
                </c:when>
						<c:when test="${room=='11'}">
                    사무공간
                </c:when>
						<c:when test="${room=='12'}">
                    상업공간
                </c:when>
						<c:when test="${room=='13'}">
                    가구&소품
                </c:when>
						<c:when test="${room=='14'}">
                    현관
                </c:when>
						<c:when test="${room=='15'}">
                    외관&기타
                </c:when>
						<c:when test="${room=='16'}">
                    복도
                </c:when>
						<c:when test="${room=='17'}">
                    제품후기
                </c:when>
						<c:otherwise>
                   모든공간
                </c:otherwise>
					</c:choose>
				</span>
			</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=&space=${space}">
					<h6>모든 공간</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=1&space=${space}">
					<h6>원룸</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=2&space=${space}">
					<h6>거실</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=3&space=${space}">
					<h6>침실</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=4&space=${space}">
					<h6>키친</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=5&space=${space}">
					<h6>욕실</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=6&space=${space}">
					<h6>아이방</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=7&space=${space}">
					<h6>드레스룸</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=8&space=${space}">
					<h6>서재&작업실</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=9&space=${space}">
					<h6>침실</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=10&space=${space}">
					<h6>베란다</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=11&space=${space}">
					<h6>사무공간</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=12&space=${space}">
					<h6>상업공간</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=13&space=${space}">
					<h6>가구&소품</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=14&space=${space}">
					<h6>현관</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=15&space=${space}">
					<h6>외관&기타</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=16&space=${space}">
					<h6>복도</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=17&space=${space}">
					<h6>제품후기</h6>
				</a>
			</div>
		</div>
		<div class="col-sm border-left">
			<button class="btn dropdown-toggle "
				style="background-color: white; width: 150px;" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<p style="font-size: 20px;">평수</p>
				<span style="text-align: center; color: black;"> <c:choose>

						<c:when test="${space=='1'}">
                    10평 미만
                </c:when>
						<c:when test="${space=='2'}">
                    10평대
                </c:when>
						<c:when test="${space=='3'}">
						
						
						asdasd
						
						
                 20평대  
                 
                 
                 
                 
                </c:when>
						<c:when test="${space=='4'}">
                    30평대
                </c:when>
						<c:when test="${space=='5'}">
                    40평대 
                </c:when>
						<c:otherwise>
                   모든 평수
                </c:otherwise>
					</c:choose></span>
			</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=">
					<h6>모든 평수</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=1">
					<h6>10평 미만</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=2">
					<h6>10평</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=3">
					<h6>20평대</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=4">
					<h6>30평대</h6>
				</a> <a class="dropdown-item"
					href="<%=request.getContextPath()%>/photo/photoList?Alignment=${Alignment}&room=${room}&space=5">
					<h6>40평대 이상</h6>
				</a>
			</div>
		</div>
	</div>
</div>


<!-- /.row -->
<div>
	<div class="row">

		<c:forEach var="list" items="${list}" varStatus="status">

			<div class="col-md-3 listBno" data-bno="${status.count}"
				style="margin-top: 30px; margin-bottom: 10px">
				<a
					href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${list.board_idx}&pagenum=1&contentnum=5"
					style="text-decoration: none; color: black"><div class="card"
						style="width: 98%;">
						<img class="card-img-top" style="height: 270px"
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}"
							alt="이미지가 없습니다">

					</div>

					<div class="countinfo" style="margin-top: 10px; padding-left: 8px;">
						<div class="row ">



							<div class="col-8">
								<img
									src="<%=request.getContextPath()%>/resources/images/scrap.png"
									height="20px" alt="" class="rounded"><span
									id="scrapCnts${status.count}">${list.board_scrap}</span>&nbsp;
								<img
									src="<%=request.getContextPath()%>/resources/images/heart.png"
									height="20px" alt="" class="rounded"><span
									id="likecnt${status.count}">${list.board_like}</span>&nbsp; <img
									src="<%=request.getContextPath()%>/resources/images/mesage.png"
									height="20px" alt="" class="rounded"><span>
									${list.board_comment} </span>
							</div>


							<div class="col-4">
								<small>조회수</small><span id="f">${list.board_cnt}&nbsp;</span>
							</div>

						</div>
					</div></a>

				<div class="card-body"
					style="height: 150px; width: 100%; padding-left: 0px; padding-right: 0px;">

					<div class="row no-gutters">

						<div class="col-12 col-sm-6 col-md-9">

							<h5 class="card-title">
								<c:if test="${list.member_photo==null}">
									<img
										src="<%=request.getContextPath()%>/resources/images/smilephoto.png"
										height="25px" alt="" class="rounded-circle">
									<small> ${list.member_id}</small>
								</c:if>
								<c:if test="${list.member_photo!=null}">
									<img
										src="<%=request.getContextPath()%>/resources/memberphoto/${list.member_photo}"
										height="25px" alt="" class="rounded-circle">
									<small> ${list.member_id}</small>
								</c:if>
							</h5>
						</div>

						<div class="col-6 col-md-3" style="height: 35px;">
							<c:if test="${list.likeck==null}">

								<a onclick="liclick(${status.count})"> <img
									src="<%=request.getContextPath()%>/resources/images/heart.png"
									height="25px" class="rounded heart${status.count}"></a>

							</c:if>

							<c:if test="${list.likeck!=null}">


								<a onclick="liclick(${status.count})"> <img
									src="<%=request.getContextPath()%>/resources/images/heart2.png"
									height="25px" class="rounded heart${status.count}"></a>

							</c:if>




							<a onclick="scrapPopups(${status.count})"> <c:if
									test="${list.scrapck==null}">
									<img class="scrapckss${status.count}"
										src="<%=request.getContextPath()%>/resources/images/scrap.png"
										height="25px" alt="" class="rounded">
								</c:if> <c:if test="${list.scrapck!=nulll}">

									<img class="scrapckss${status.count}"
										src="<%=request.getContextPath()%>/resources/images/scrap2.png"
										height="25px" alt="" class="rounded">

								</c:if>

							</a>
						</div>








					</div>

					<p class="card-text textboard_contents"
						style="text-overflow: ellipsis;">${list.board_title}</p>

				</div>

				<input type="hidden" class="likech${status.count}"
					value="${list.like_check}"> <input type="hidden"
					class="bidx${status.count}" value="${list.board_idx}"> <input
					type="hidden" id="board_idx${status.count}"
					value="${list.board_idx}"> <input type="hidden"
					id="member_idx${status.count}" value="${list.member_idx}">

			</div>
		</c:forEach>
		<input type="hidden" id="logcks" value="${member}">
		<div id="scrap" class="scrapArea" style="display: none;">

			<div id="scrapPopup">

				<c:forEach var="list" items="${list}" varStatus="status">
					<div class="col-md-3 border"
						style="margin-top: 10px; margin-bottom: 10px">
						<a
							href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${list.board_idx}&pagenum=1&contentnum=5"
							style="text-decoration: none; color: black"><div class="card"
								style="width: 16rem;">

								<img class="card-img-top" height="190px"
									src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}"
									alt="이미지가 없습니다">


								<div class="row">
									<div class="col-8">
										<img
											src="<%=request.getContextPath()%>/resources/images/scrap.png"
											height="20px" alt="" class="rounded"
											style="margin-right: 5px; margin-bottom: 3px;"><span
											id="scrapCnts${status.count}">${list.board_scrap}</span><img
											src="<%=request.getContextPath()%>/resources/images/heart.png"
											height="20px" alt="" class="rounded"
											style="margin-right: 10px; margin-bottom: 0px;"><span
											id="likecnt${status.count}">${list.board_like}</span><img
											src="<%=request.getContextPath()%>/resources/images/mesage.png"
											height="20px" alt="" class="rounded"
											style="margin-right: 5px;"><span>
											${list.board_comment} </span>
									</div>
									<div class="col-4">
										<small>조회수</small><span id="f">${list.board_cnt}</span>
									</div>
								</div>
							</div></a>

						<div class="card-body " style="height: 150px;">
							<div class="row no-gutters">

								<div class="col-12 col-sm-6 col-md-8">

									<h5 class="card-title  ">
										<img
											src="<%=request.getContextPath()%>/resources/memberphoto/${list.member_photo}"
											height="25px" class="rounded-circle"><small>
											${list.member_id}</small>
									</h5>
								</div>

								<div class="col-6 col-md-4" style="height: 35px;">
									<c:if test="${list.likeck==null}">

										<a onclick="liclick(${status.count})"> <img
											src="<%=request.getContextPath()%>/resources/images/heart.png"
											height="25px" alt="" class="rounded heart${status.count}"></a>

									</c:if>

									<c:if test="${list.likeck!=null}">


										<a onclick="liclick(${status.count})"> <img
											src="<%=request.getContextPath()%>/resources/images/heart2.png"
											height="25px" alt="" class="rounded heart${status.count}"></a>

									</c:if>



									<a onclick="scrapPopups(${status.count})"><img
										src="<%=request.getContextPath()%>/resources/images/scrap.png"
										height="25px" alt="" class="rounded"></a>
								</div>
							</div>
							<p class="card-text">${list.board_contents}</p>
						</div>
						<input type="hidden" class="likech${status.count}"
							value="${list.like_check}"> <input type="hidden"
							class="bidx${status.count}" value="${list.board_idx}"> <input
							type="hidden" id="board_idx${status.count}"
							value="${list.board_idx}"> <input type="hidden"
							id="member_idx" value="${list.member_idx}">

					</div>
				</c:forEach>
				<input type="text" id="logcks" value="${member}">


			</div>

		</div>
	</div>
</div>



<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Scrap Folder</h5>
			</div>
			<div class="modal-body">
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
			</div>
			<input type="hidden" id="board_idx"> <input type="hidden"
				id="scrapCnt"> <input type="hidden" id="ck">

			<div class="modal-footer">
				<div class="row">
					<div class="col">
						<input type="hidden" class="listnumber"
							value="${fn:length(scrapNameList)}"> <input type="text"
							class="input-group-text scrapFolderName"
							style="width: 400px; margin-left: 30px; margin-bottom: 10px"
							placeholder="Scrap Folder Name를 입력해주세요" />
					</div>

					<div class="w-100"></div>
					<div class="col-4"></div>
					<div class="col-8">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="margin-right: 10px;">Close</button>
						<button type="button" class="btn btn-primary add">추가</button>
					</div>

				</div>



			</div>
		</div>
	</div>
</div>
