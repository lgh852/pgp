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
	<li class="nav-item"><a class="nav-link active" href="#">모음</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_idx=${member.member_idx}">사진</a>
		</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/mypage/mp_myStory?member_idx=${member.member_idx}">
		스토리</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li class="nav-item"><a class="nav-link" 
		href="<%=request.getContextPath()%>/mypage/mp_myLike?member_idx=${member.member_idx}">
		좋아요</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_scrap?member_idx=${member.member_idx}">스크랩</a>
		</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/mypage/mp_myComment?member_idx=${member.member_idx}">댓글</a>
		</li>
	</ul>


</div>
        </div>
        
        
        
        <!--사진 과 사이드(스크랩,좋아요) 섹션-->
        <div class="blog_contents" style="margin-top:10px;">
        <div class="row">
               
           <div class="col-md-8 blog-main">
               
        <div class="blog-post">
                
                   <div class="my_picture_list" >
            
            <div class="album py-5 bg-light">
                
                <!-- 사진 나오기 전에 사진 갯수와 전체보기 섹션 -->
                
        <div class="row justify-content-between">
             <div class="col-4">
        <div class="picture" style="padding-left: 15px;">사진 
          <c:if test="${ck=='n'}">0</c:if>
          <c:if test="${ck=='y'}">${photo_count}
            </c:if></div>
    </div>
    <div class="col-4">
        <a
           href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_idx=${member.member_idx}">
           <p class="view_all" style="text-align: right;margin-right: 18px; "> 전체보기</p></a>
     </div>
  </div>
                
                
                	<c:if test="${ck=='y'}"> <!--만약 사진이 올라와져 있다면!-->
               
                <div class="container">
                
                <div class="row">
                    
                    <c:forEach var="photo" items="${boardLatestPhoto}" >
                    
               
                        <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                         <a href="<%=request.getContextPath() %>/photo/photodetail?board_idx=${photo.board_idx}">
                        <img class="card-img-top"  style="height: 225px; width: 100%; display: block;" 
                        src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}" data-holder-rendered="true"></a>
                        </div>
                    </div>
                    
                    </c:forEach>
                        
                      
                    </div>
                </div>
                </c:if>
                
                
                 <!-- 만약 업로드한 사진이 하나도 없다면!  -->
                <c:if test="${ck=='n'}"> 
                
                <div class="scrap_book_add" style="border-style:dashed; border-color:gray; height: 226px; border-width: 1px;">
          
                     <a href="<%=request.getContextPath()%>/board/boardFrom">
                     
                     <div class="addphoto">
                     
                     
                    <h3 style="margin-top:80px; padding-left:190px;">첫 번째 사진을 올려보세요!</h3>  
                     </div>
                     
                      </a>
                      
                          </div>
                
                
                
                </c:if>
                
                       
                       </div>
                 
                   </div>
               </div>
               </div> <!--블로그 메인 닫기-->
        
            
             
             <!-- 사이드바 스크랩북,좋아요 -->
            
            <aside class="col-md-4 blog-sidebar">
                 <div class="sidebar_topmargin" style="margin-top: 33px;">
          
          <c:if test="${scrapLatestPhoto !=null}">
          <div class="p-3 mb-3 bg-light rounded" style="height:100px;">
              
              <div class="scrapPhoto" >
              <a href="<%=request.getContextPath() %>/mypage/mp_scrap?member_id=${member.member_id}">
              <img src="<%=request.getContextPath()%>/resources/BoardPhoto/${scrapLatestPhoto}" class="img-fluid" alt="Responsive image" 
              style="width:100%; height:100px; border-radius: 5px;">
            <div class="scrapbook" style="position: absolute; top:18%; margin-left: 65px; text-aligh:center; font-size:45px;  "> 
                <span style="color:white;">스크랩북</span></div>
                </a>
              </div>
              
         </div>
         </c:if>
         
       <!--   스크랩한 사진이 하나도 없다면 -->
         <c:if test="${scrapLatestPhoto ==null}">
         <div class="p-3 mb-3 bg-light rounded" style="height:100px;">
              
               <div class="scrapPhoto" >
                <a href="<%=request.getContextPath() %>/mypage/mp_scrap?member_id=${member.member_id}" style="text-decoration: none;">
              
            <div class="scrapbook" style="font-size:20px; border-style: dashed; border-color:gray; heigth:80px; border-width: 1px;"> 
                <div style="color: cornflowerblue; padding-top: 20px; padding-left:110px; padding-bottom: 20px;">스&nbsp;크&nbsp;랩&nbsp;북
                </div></div> 
                </a>
             
              </div>
           
              
         </div>
         
         </c:if>
         
         
         
            <c:if  test="${likeLatestPhoto !=null}">
            
            <div class="p-3 mb-3 bg-light rounded" style="height:100px;">
            
            <div class="likePhoto">
           <a href="<%=request.getContextPath() %>/mypage/mp_myLike">
           <img src="<%=request.getContextPath()%>/resources/BoardPhoto/${likeLatestPhoto}" class="img-fluid" alt="Responsive image" 
           style="width:100%; height:100px; border-radius: 5px;">
            <div class="scrapbook" style="position: absolute; top:47%; margin-left: 100px; text-aligh:center; font-size:45px;  "> 
                <span style="color: white">좋아요</span></div>
                </a>
                     </div>
               
          </div>
                
                </c:if>
                
                <!-- 좋아요 누른 사진이 하나도 없다면 !  -->
                <c:if test="${likeLatestPhoto ==null}">
                
                      <div class="p-3 mb-3 bg-light rounded" style="height:100px;">
            
            <div class="likePhoto">
           
           <a href="<%=request.getContextPath() %>/mypage/mp_myLike" style="text-decoration: none;">
           <div class="scrapbook" style="font-size:20px; border-style: dashed; border-color:gray; heigth:80px; border-width: 1px;"> 
                <div style="color: cornflowerblue; padding-top: 20px; padding-left:120px; padding-bottom: 20px;">좋&nbsp;아&nbsp;요
                </div></div> 
                
                
                </a>
               
                     </div>
               
          </div>
          </c:if>
                
                
                
                
                
                </div>
            </aside>
            </div>
            
            
            
            
            
        </div>
        
	</main>
    
    
 
    
    
    
    
    
    
    
    







