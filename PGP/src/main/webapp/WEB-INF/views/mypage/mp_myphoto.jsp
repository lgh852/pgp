<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <main role="main" class="container">
 
 
  <!-- user_info -->
        
        <div class="row" style="margin-top: 30px">
        <div class="row container border" style="background-image:url('<%=request.getContextPath()%>/resources/images/newhouse.jpg')">
        <div class="col-4  " style="height: 200px;">
            <div class="row">
    <div class="col">
     
    </div>
    <div class="col">
      
    </div>
    
    <!-- 만약 나의 프로필 사진이 설정되어 있지 않다면! 기본사진이 나온다 -->
    <c:if test="${member.member_photo ==null}">
    <div class="col">
      <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/images/smilephoto.png" 
       width="140" height="140" style="border-top-width: 100px; margin-top: 30px;">
    </div>
    
    </c:if>
    
    
    <c:if test="${member.member_photo !=null}">
    <div class="col">
      <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" 
       width="140" height="140" style="border-top-width: 100px; margin-top: 30px;">
    </div>
    </c:if>
  
  
  
  
  
  </div>
        </div>

<div class="col-8">
      <div class="container">
     <div class="col " style="height: 100px">
          <div class="user_name" style="height: 60px; font-size: 20px; text-align: left; padding-top: 30px;">
          <p class="font-weight-bold" style="font-size: 50px;">${member.member_id}</p></div></div>
    <div class="col " style="height: 100px">
          
        <div class="user-set" style="margin-top: 10px;">
        
        <button type="button" class="btn btn-sm btn-outline-secondary"  data-toggle="button" aria-pressed="false"
				style="width: 100px; font-size: 20px; text-align: right;border-color:none;"
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_update?member_idx=${member.member_idx}'">
				<img src="<%=request.getContextPath()%>/resources/images/setbutton.png"
					width="20px" height="20px">&nbsp 설정</button>
        
	
		</div></div>
      </div>
        </div>

 </div>
	</div>
           <!-- 마이페이지 메뉴 nav-->
    
    <div class="menu_nav">
        <div class="menu" style="margin-top: 20px;">

	<ul class="nav justify-content-center nav-tabs"
		style="text-align: center; padding-top: 30px;">
	<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/mypage/mp_main?member_idx=${member.member_idx}">모음</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<li class="nav-item "><a class="nav-link active"
			href="#">사진</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/mypage/mp_myStory?member_idx=${member.member_idx}">
		스토리</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link" 
		href="<%=request.getContextPath()%>/mypage/mp_myLike?member_idx=${member.member_idx}">
		좋아요</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_scrap?member_idx=${member.member_idx}">스크랩</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myComment?member_idx=${member.member_idx}">댓글</a>
		</li>
	</ul>


</div>
        </div>
        
        
        
        
<div class="row">
<c:forEach var="list" items="${listlist}" varStatus="status">
			<div class="col-md-3 border"
				style="margin-top: 10px; margin-bottom: 10px">
				<a
					href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${list.board_idx}"
					style="text-decoration: none; color: black"><div class="card"
						style="width: 16rem;">
						<img class="card-img-top" height="190px"
							src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}"
							alt="이미지가 없습니다">


						<div class="row">
							<div class="col-8">
								<img
									src="<%=request.getContextPath()%>/resources/images/scrap.png"
									height="20px" alt="..." class="rounded"><span
									id="scrapCnts${status.count}">${list.board_scrap}</span><img
									src="<%=request.getContextPath()%>/resources/images/heart.png"
									height="20px" alt="..." class="rounded"><span
									id="likecnt${status.count}">${list.board_like}</span><img
									src="<%=request.getContextPath()%>/resources/images/mesage.png"
									height="20px" alt="..." class="rounded"><span>
									${list.board_comment} </span>
							</div>
							<div class="col-4">
								<small>조회수</small><span id="f">${list.board_cnt}</span>
							</div>
						</div>
					</div></a>

				<div class="card-body" style="width: 300px; height: 150px;">
					<div class="row no-gutters">

						<div class="col-12 col-sm-6 col-md-8">

							<h5 class="card-title">
								<img
									src="<%=request.getContextPath()%>/resources/memberphoto/${list.member_photo}"
									height="25px" alt="..." class="rounded-circle"><small>
									${list.member_id}</small>
							</h5>
						</div>

						<div class="col-6 col-md-4" style="height: 35px; ">
						
						<div class="container">
  <div class="row">
    
    <div class="col">
     		<c:if test="${list.likeck==null}">

								<a onclick="liclick(${status.count})"> <img
									src="<%=request.getContextPath()%>/resources/images/heart.png"
									height="25px" alt="..." class="rounded heart${status.count}"></a>

							</c:if>

							<c:if test="${list.likeck!=null}">


								<a onclick="liclick(${status.count})"> <img
									src="<%=request.getContextPath()%>/resources/images/heart2.png"
									height="25px" alt="..." class="rounded heart${status.count}"></a>

							</c:if>
    </div>
  </div>
					
</div>

						</div>
					</div>
					<p class="card-text" style="text-overflow: ellipsis;">${list.board_contents}</p>
				</div>
				<input type="hidden" class="likech${status.count}"
					value="${list.like_check}"> <input type="hidden"
					class="bidx${status.count}" value="${list.board_idx}"> <input
					type="hidden" id="board_idx${status.count}"
					value="${list.board_idx}"> <input type="hidden"
					id="member_idx${status.count}" value="${list.member_idx}">

			</div>
		</c:forEach>

</div>






</main>


