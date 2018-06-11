<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    
    
    
    
    
    
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
	<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/mypage/mp_main?member_idx=${member.member_idx}">모음</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_idx=${member.member_idx}">사진</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item "><a class="nav-link active" href="#">
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
        
  
    
<div class="mystorylist" style="margin-top:30px;">


<c:forEach var="listStory" items="${listStory}" varStatus="status">
<hr class="featurette-divider" style="width: 100%">
	<div class="row featurette" style="width: 100%;">

		<div class="col-md-7" style="width: 100%">



			<h4 class="featurette-heading">
				<img
					src="<%=request.getContextPath()%>/resources/memberphoto/${listStory.member_photo}"
					width="50px" height="60px"
					style="border-radius: 50%; padding: 3px;">ID[${listStory.member_id}]

				
				<!-- 삭제기능 -->
				<c:if test="${listStory.member_idx==user.member_idx}">
					<a class="btn btn-outline-danger"
						href="<%=request.getContextPath()%>/story/storyboardDelete?storyboard_idx=${listStory.storyboard_idx}"
						role="button">삭제</a>
				</c:if>


			</h4>
			<span class="text-muted"> Date: <fmt:formatDate
					pattern="yyyy년 MM월 dd일 HH:mm:ss"
					value="${listStory.storyboard_regdate}" /></span>

			<p class="lead">${listStory.storyboard_contents}</p>

		</div>



		<div class="col-md-5">
			<img class="featurette-image img-fluid mx-auto"
				data-src="<%=request.getContextPath()%>/resources/StoryPhoto/${listStory.storyboard_photo}"
				alt="" style="width: 100%;height: 240px;margin-top: 75px;"
				src="<%=request.getContextPath()%>/resources/StoryPhoto/${listStory.storyboard_photo}"
				data-holder-rendered="true">
		</div>


	</div>

	<!-- 좋아요 -->
	<div style="width: 100%">
		<input type="hidden" class="storyboard_idx${status.count}"
			value="${listStory.storyboard_idx}"> <input type="hidden"
			class="member_idx${status.count}" value="${user.member_idx}">

		<!-- 좋아요기능 -->
		<c:if test="${listStory.likeck==null}">
			<a onclick="likestoryClick(${status.count})"> <img
				class="storylike_heart${status.count}"
				src="<%=request.getContextPath()%>/resources/images/heart.png"
				width="24px" height="24px"> <c:if
					test="${listStory.storyboard_like==0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count} ">
					<span class="cntss${status.count}"></span>
					<span class="likeTEXT${status.count}">제일 먼저 좋아요를 눌러보세요~</span>
				</c:if> <c:if test="${listStory.storyboard_like!=0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count}">
					<span class="cntss${status.count}">${listStory.storyboard_like}</span>
					<span class="likeTEXT${status.count}"> 명이좋아합니다♥</span>
				</c:if>
			</a>
		</c:if>

		<c:if test="${listStory.likeck!=null}">
			<a onclick="likestoryClick(${status.count})"> <img
				class="storylike_heart${status.count}"
				src="<%=request.getContextPath()%>/resources/images/heart2.png"
				width="24px" height="24px"> <c:if
					test="${listStory.storyboard_like!=0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count} ">
					<span class="cntss${status.count}">${listStory.storyboard_like}</span>
					<span class="likeTEXT${status.count}"> 명이 좋아합니다♥</span>
				</c:if>
			</a>
		</c:if>
	</div>
	<hr class="featurette-divider" style="width: 100%">

</c:forEach>

</div>

</main>