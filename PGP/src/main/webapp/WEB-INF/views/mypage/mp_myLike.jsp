<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/mypage/mp_myStory?member_idx=${member.member_idx}">
		스토리</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item "><a class="nav-link active" 
		href="#">
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
        












<c:if test="${likeList != null}">


<div class="album py-5 bg-light" style="margin-top:30px;">
        
   <div class="container">

        <div class="row container">


<c:forEach var="likephoto" items="${likeList}">

    <div class="col-md-4">
              <div class="card mb-4 box-shadow">

<a href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${likephoto.board_idx}">
<img src="<%=request.getContextPath()%>/resources/BoardPhoto/
${likephoto.photo_name}" width="100%" height="200px">
</a>

</div></div>

</c:forEach>


</div></div></div>
</c:if>


<!-- 좋아요 한적 없을 때 --> 


<c:if test="${likeList == null}">


<h1>아직 좋아한 콘텐츠가 없습니다.
마음에 드는 콘텐츠를 발견하면 좋아요를 눌러보세요!</h1>


</c:if>


 
 </main>
 
 

