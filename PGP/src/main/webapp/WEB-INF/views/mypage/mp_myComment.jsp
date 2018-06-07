<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    
    
    <main role="main" class="container">
        
        <div class="row" style="margin-top: 30px">
        <div class="row container border" style="background-image:url('<%=request.getContextPath()%>/resources/images/newhouse.jpg')">
        <div class="col-4  " style="height: 200px;">
            <div class="row">
    <div class="col">
     
    </div>
    <div class="col">
      
    </div>
    <div class="col">
      <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" 
       width="140" height="140" style="border-top-width: 100px; margin-top: 30px;">
    </div>
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
				onclick="location.href='<%=request.getContextPath()%>/mypage/mp_update?member_id=${member.member_id}'">
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
		<li class="nav-item"><a class="nav-link" 
		href="<%=request.getContextPath()%>/mypage/mp_myLike?member_idx=${member.member_idx}">
		좋아요</a></li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_scrap?member_idx=${member.member_idx}">스크랩</a>
		</li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="nav-item "><a class="nav-link active"
			href="#">댓글</a>
		</li>
	</ul>


</div>
        </div>
        
        
        
        
        
        <!--나의 댓글 리스트-->
        
        <div class="mycommentlist" style="margin-top:30px;">
        
        
        
        <!--반복-->
        
          <ul class="list-group mb-3" style="width: 100%">
									
			<c:forEach var="myComment" items="${myComment}">						
              
              <li class="list-group-item d-flex justify-content-between lh-condensed" style="width: 100%">
										
									
 <div class="row container">
    <div class="col">
     	
		<h6 class="my-0">${myComment.board_comment_contents}</h6>
	    
    </div>
    <div class="col-md-auto">
     <fmt:formatDate value="${myComment.board_comment_regdate}" pattern="yyyy-MM-dd hh:mm"/>	
    </div>
    <div class="col col-lg-2">
     					
		<a href="/p/photo/photoCommentDelete?board_comment_idx=${myComment.board_comment_idx}&
			board_idx=${myComment.board_idx}">삭제</a>
											
    </div>
  </div>
							
			</li>
									
				</c:forEach>					
									
          </ul>
        
        
   
        </div>
        
        
         
         
   </main>
    
    
 
    
    
    
    
    
    
    
