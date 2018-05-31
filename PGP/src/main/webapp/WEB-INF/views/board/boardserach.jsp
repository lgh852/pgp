<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.size {
	border: 1px solid black;
	width: 100%;
	height: 200px;
}

.censize {
	margin-top: 30px;
	border: 1px solid black;
	width: 100%;
	height: 2000px;
}

.viewli {
	float: left;
	margin-top: 50px;
	margin-left: 60px;
	list-style-type: none;
}

.info {
	border: 1px solid black;
	width: 280px;
	height: 70px;
}

.memebrinfo {
	border: 1px solid black;
	width: 30px;
	height: 30px;
	border-radius: 100px 100px 100px 100px;
	padding: 1px;
}

.overfl {
	overflow: hidden;
	position: relative;
}

.memid {
	position: absolute;
	top: 7px;
	margin: 0 3;
	left: 45px;
}

.a1 {
	display: block;
	width: 180;
}

.di2 {
	position: absolute;
	top: 230px;
	left: 10px;
	overflow: hidden;
}

.fontcount {
	font-size: 16px;
	font-weight: 100;
}

.m10right {
	margin-right: 6px
}

.ss {
	display: none;
}
</style>
<style>
.navmain {
	border: 1px solid black;
	float: left;
	width: 24.8%;
	height: 100%;
	text-align: center;
}

.navside {
	border: 1px solid black;
	float: left;
	width: 12.4%;
	height: 100%
}

.navbox {
	margin-top: 7%;
	height: 70px;
}

.navboxhide {
	margin-top: 7%;
	height: 70px;
	display: none;
}

.choicebox {
	border: 1px solid black;
	float: left;
	width: 33.1%;
	height: 100%;
	text-align: center;
}

.choiceboxroom {
	border: 1px solid black;
	float: left;
	width: 70px;
	height: 100%;
	text-align: center;
}

.choiceboxroom a {
	display: block;
	width: 67px;
	height: 40px;
	margin: 0 auto;
	margin-top: 30px;
	text-decoration: none;
	color: black;
}

.choiceboxspace {
	border: 1px solid black;
	float: left;
	width: 16.59%;
	height: 100%;
	text-align: center;
}

.choiceboxspace a {
	display: block;
	width: 60px;
	height: 40px;
	margin: 0 auto;
	margin-top: 30px;
	text-decoration: none;
	color: black;
}

.choicebox a {
	display: block;
	width: 100px;
	height: 40px;
	margin: 0 auto;
	margin-top: 30px;
	text-decoration: none;
	color: black;
}

.navchoice {
	width: 74.8%;
	border: 1px solid black;
	margin: 0 auto;
	top: 30px;
	height: 100px;
	position: absolute;
	top: 100px;
	left: 12.4%;
	display: none
}
</style>
<div class="size" style="position: relative">

	<div class="navside"></div>
	<div class="navmain">
		<div class="navbox" id="shotshow">
			<h2>
				정렬<img src="../../Html,Css/tr.png" width="28px" height="28px">

			</h2>
			<span style="text-align: center; color: blue;"> <c:choose>
					<c:when test="${Alignment =='board_idx'}">
           			최신순
     	  		</c:when>
					<c:when test="${Alignment =='board_cnt'}">
          			인기순
      	 	</c:when>
					<c:when test="${Alignment =='board_like'}">
          			 좋아요
      	 	</c:when>
      	 			<c:otherwise>
     	  			최신순
     	  			</c:otherwise>
				</c:choose></span>

		</div>

	</div>
	<div class="navmain">
		<div class="navbox" id="roomshow">
			<h2>
				공간<img src="../../Html,Css/tr.png" width="28px" height="28px">
			</h2>
				<span style="text-align: center; color: blue;">
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

		</div>



	</div>
	<div class="navmain">
		<div class="navbox " id="spaceshow">
			<h2>
				평수<img src="../../Html,Css/tr.png" width="28px" height="28px">
			</h2>
			<span style="text-align: center; color: blue;"> <c:choose>
					<c:when test="${space=='1'}">
           			10평 미만
     	  		</c:when>
					<c:when test="${space=='2'}">
           			10평대
     	  		</c:when>
					<c:when test="${space=='3'}">
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

		</div>
	</div>
<div class="navside"></div>
	<div class="navchoice" id="choicemenu">
		<div class="choicebox">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=board_idx&room=${room}&space=${space}">
				<h5>최신순</h5>
			</a>
		</div>
		<div class="choicebox">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=board_cnt&room=${room}&space=${space}">
				<h5>인기순</h5>
			</a>
		</div>
		<div class="choicebox">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=board_like&room=${room}&space=${space}">
				<h5>좋아요순</h5>
			</a>
		</div>

	</div>
	<div class="navchoice" id="choicemenuroom">
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=&space=${space}">
				<h5>모든 공간</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=1&space=${space}">
				<h5>원룸</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=2&space=${space}">
				<h5>거실</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=3&space=${space}">
				<h5>침실</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=4&space=${space}">
				<h5>키친</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=5&space=${space}">
				<h5>욕실</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=6&space=${space}">
				<h5>아이방</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=7&space=${space}">
				<h5>드레스룸</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=8&space=${space}">
				<h5>서재&작업실</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=9&space=${space}">
				<h5>침실</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=10&space=${space}">
				<h5>베란다</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=11&space=${space}">
				<h5>사무공간</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=12&space=${space}">
				<h5>상업공간</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=13&space=${space}">
				<h5>가구&소품</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=14&space=${space}">
				<h5>현관</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=15&space=${space}">
				<h5>외관&기타</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=16&space=${space}">
				<h5>복도</h5>
			</a>
		</div>
		<div class="choiceboxroom">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=17&space=${space}">
				<h5>제품후기</h5>
			</a>
		</div>




	</div>
	<div class="navchoice" id="choicemenuspace">
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=">
				<h5>모든 평수</h5>
			</a>
		</div>
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=1">
				<h5>10평 미만</h5>
			</a>
		</div>
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=2">
				<h5>10평 </h5>
			</a>
		</div>
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=3">
				<h5>20평대</h5>
			</a>
		</div>
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=4">
				<h5>30평대</h5>
			</a>
		</div>
		<div class="choiceboxspace">
			<a
				href="<%=request.getContextPath()%>/board/boardserach?search=${search}&choice=${choice}&Alignment=${Alignment}&room=${room}&space=5">
				<h5>40평대 이상</h5>
			</a>
		</div>

	</div>
</div>
	

<div class="censize">

	<c:forEach var="list" items="${list}" varStatus="status">

		<ul>
			<li class="viewli" style="position: relative"><a href="#">
					<div style="height: 280">
						<img
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}"
							width="280" height="280">

						<div class="di2 fontcount">
							<img src="html.css/25.jpg" width="37" height="37"
								class="m10right">${list.board_scrap} <img
								src="html.css/25.jpg" width="37" height="37" class="m10right">${list.board_comment}
							<img src="html.css/25.jpg" width="37" height="37"
								class="m10right"><span id="likecnt${status.count}">${list.board_like}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조회수&nbsp;&nbsp;<span
								id="f">${list.board_cnt}</span>
						</div>
							${list.board_title}
					</div>
			</a>
				<div class="info">


					<div class="overfl">

						<a href="#" class="a1">
							<div class="memebrinfo"
								style="background-image:url('<%=request.getContextPath()%>/resources/memberphoto/${list.member_photo}');">
								<div>
									<p class="memid">${list.member_id}</p>

								</div>
							</div>
						</a> <a style="position: absolute; right: 5px; top: 3px;" href="#"
							class="like"><img src="#" width="30px" height="30px"></a> <a
							style="position: absolute; right: 5px; top: 3px;" href="#"
							class="like"><img src="#" width="30px" height="30px"></a>
						<c:if test="${list.likeck==null}">
							<a style="position: absolute; right: 35px; top: 3px"
								onclick="liclick(${status.count})"> <img
								class="heart${status.count}"
								src="<%=request.getContextPath()%>/resources/images/heart1.png"
								width="30px" height="30px"></a>
						</c:if>
						<c:if test="${list.likeck!=null}">
							<a style="position: absolute; right: 35px; top: 3px"
								onclick="liclick(${status.count})"> <img
								class="heart${status.count}"
								src="<%=request.getContextPath()%>/resources/images/heart2.jpg"
								width="30px" height="30px"></a>
						</c:if>
						<p>${list.board_contents}</p>

					</div>
				</div></li>
		</ul>
		<ul>
			<li class="ss"><input type="hidden"
				class="likech${status.count}" value="${list.like_check}"></li>

			<li class="ss"><input type="hidden" class="bidx${status.count}"
				value="${list.board_idx}"></li>
		</ul>

	</c:forEach>
</div>
