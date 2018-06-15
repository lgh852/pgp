<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script>
	
</script>

<style>
.pagination2 {
	display: flex;
	/* padding-left: 0; */
	list-style: none;
	border-radius: .25rem;
	margin-bottom: 0px;
}
</style>







<div class="col-md-8 blog-main">


	<div class="blog-post">
		<div class="carousel-item active" style="margin-top: 15px">
			<div id="carouselExampleSlidesOnly" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<a
							href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${maxcntimg.get(0).board_idx}"
							style="color: white"> <img class="d-block w-100"
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${maxcntimg.get(0).photo_name}"
							id="imgtagbox" height="450px" alt="First slide">
							<div style="position: absolute; left: 20px; bottom: 30px;">
								<h4>${board.get(0).board_title}</h4>
								<h1></h1>

								<span> <img src="%EC%9E%A0%EB%93%AC.png" width="25px"
									height="25px" class="rounded-circle">${memberlist.get(0).member_id}</span>
							</div>
						</a>
					</div>
					<div class="carousel-item">
						<a
							href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${maxcntimg.get(1).board_idx}"
							style="color: white"><img class="d-block w-100"
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${maxcntimg.get(1).photo_name}"
							id="imgtagbox" height="450px" alt="Second slide">
							<div style="position: absolute; left: 20px; bottom: 30px;">
								<h4>${board.get(1).board_title}</h4>
								<h1></h1>

								<span> <img src="%EC%9E%A0%EB%93%AC.png" width="25px"
									height="25px" class="rounded-circle">${memberlist.get(1).member_id}</span>
							</div></a>
					</div>
					<div class="carousel-item">
						<a
							href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${maxcntimg.get(2).board_idx}"
							style="color: white"> <img class="d-block w-100"
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${maxcntimg.get(2).photo_name}"
							id="imgtagbox" height="450px" alt="Third slide">
							<div style="position: absolute; left: 20px; bottom: 30px;">
								<h4>${board.get(2).board_title}</h4>
								<h1></h1>

								<span> <img src="%EC%9E%A0%EB%93%AC.png" width="25px"
									height="25px" class="rounded-circle">${memberlist.get(2).member_id}</span>
							</div></a>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /.blog-post -->



</div>
<!-- /.blog-main -->




<aside class="col-md-4 blog-sidebar">
	<div class="p-3 mb-3 bg-light rounded">

		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100"
						src="<%=request.getContextPath()%>/resources/images/Ad1.PNG"
						alt="First slide" height="450px">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100"
						src="<%=request.getContextPath()%>/resources/images/Ad2.PNG"
						alt="Second slide" height="450px">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100"
						src="<%=request.getContextPath()%>/resources/images/Ad3.PNG"
						alt="Third slide" height="450px">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>

	</div>
</aside>
<!-- /.blog-sidebar -->
<div class="card-group ">

	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a
			href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space="><img
			class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/hos.PNG"
			alt="Card image cap"></a>
		<div class="card-body">
			<h5 class="card-title">평수필터</h5>
			<p class="card-text">
				<small class="text-muted">평수별로 집 구경</small>
			</p>
		</div>
	</div>

	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a
			href="<%=request.getContextPath()%>/photo/photoList?Alignment=board_idx&room=&space="><img
			class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/ar.PNG"
			alt="Card image cap"></a>
		<div class="card-body">
			<h5 class="card-title">공간필터</h5>
			<p class="card-text">
				<small class="text-muted">공간별로 사진보기</small>
			</p>
		</div>
	</div>
	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a href="<%=request.getContextPath()%>/furniture/furnitureRank"><img
			class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/furniture.PNG"
			alt="Card image cap"></a>
		<div class="card-body">
			<h5 class="card-title">가구랭킹</h5>
			<p class="card-text">
				<small class="text-muted">가구 정보</small>
			</p>
		</div>
	</div>

	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a href="<%=request.getContextPath()%>/story/storyboardForm"> <img
			class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/storyboard.png"
			alt="Card image cap"></a>
		<div class="card-body">
			<h5 class="card-title">스토리</h5>
			<p class="card-text">
				<small class="text-muted">Last updated 3 mins ago</small>
			</p>
		</div>
	</div>
	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a
			href="<%=request.getContextPath()%>/manager/noticelist?pagenum=1&contentnum=5">
			<img class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/notice.png"
			alt="Card image cap">
		</a>
		<div class="card-body">
			<h5 class="card-title">공지사항</h5>
			<p class="card-text">
				<small class="text-muted">Last updated 3 mins ago</small>
			</p>
		</div>
	</div>
	<div class="card rounded border-0 "
		style="margin-left: 50px; margin-right: 50px; margin-top: 50px">
		<a href="<%=request.getContextPath()%>/manager/faqlist"> <img
			class="card-img-top"
			src="<%=request.getContextPath()%>/resources/images/FAQ.PNG"
			alt="Card image cap"></a>
		<div class="card-body">
			<h5 class="card-title">FAQ</h5>
			<p class="card-text">
				<small class="text-muted">질문과답변</small>
			</p>
		</div>
	</div>


</div>

<!-- 최근 본 게시물  -->
<div class="card mb-4 box-shadow" style="width: 180px;" id="latelybox">
	<div class="card-header">
		<h5 class="my-0 font-weight-normal">최근 본 게시물</h5>
	</div>
	<div class="card-body"
		style="margin: auto; padding-top: 0px; padding-bottom: 8px;">

		<ul class="list-unstyled mt-3 mb-4">

			<li id="oneimg"><img id="imgone" width="128" height="128"></li>
		</ul>
		<nav aria-label="Page navigation example">
			<ul class="pagination2">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true"
						style="color: #000000ad;"> <!-- &laquo; -->◀
					</span> <span class="sr-only">Previous</span>
				</a></li>

				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true"
						style="color: #000000ad;"> <!-- &raquo; -->▶
					</span> <span class="sr-only">Next</span>
				</a></li>
			</ul>
		</nav>

	</div>
</div>


<!-- <div
	style="height: 230px; width: 150px; border: 1px solid black; border-radius: 15px 15px 15px 15px"
	id="latelybox">

	<div
		style="width: 130px; height: 30px; margin: 0 auto; text-align: center">
		<span>최근 본 게시물</span>
	</div>
	<div id="oneimg"
		style="width: 130px; height: 130px; border: 1px solid black; margin: 0 auto; margin-top: 10px">
		<img id="imgone" width="128" height="128">
	</div>

</div> -->
<input type="hidden" id="photoname1">
<input type="hidden" id="photoname2">
<input type="hidden" id="photoname3">
<input type="hidden" id="latelyck">
<input type="hidden" value="${fn:length(latelylist)}" id="rowmin">
<input type="hidden" value="${fn:length(latelylist)}" id="listsize">


<c:forEach var="latelylist" items="${latelylist}" varStatus="status">

	<input type="hidden" id="latelyck${status.count}"
		value="${latelylist.photo_name}">

</c:forEach>








<%-- <div
	style="height: 230px; width: 150px; border: 1px solid black; border-radius: 15px 15px 15px 15px"
	id="latelybox">

	<div
		style="width: 130px; height: 30px; margin: 0 auto; text-align: center">
		<span>최근 본 게시물</span>
	</div>
	<div id="oneimg"
		style="width: 130px; height: 130px; border: 1px solid black; margin: 0 auto; margin-top: 10px">
		<img id="imgone" width="128" height="128">
	</div>
	-
</div>
<input type="hidden" id="photoname1">
<input type="hidden" id="photoname2">
<input type="hidden" id="photoname3">
<input type="hidden" id="latelyck">
<input type="hidden" value="${fn:length(latelylist)}" id="rowmin">
<input type="hidden" value="${fn:length(latelylist)}" id="listsize">


${latelylist}
<c:forEach var="latelylist" items="${latelylist}" varStatus="status">

	<input type="hidden" id="latelyck${status.count}"
		value="${latelylist.photo_name}">

</c:forEach> --%>

