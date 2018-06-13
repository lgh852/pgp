<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main role="main" class="container">
        
        
        <!-- 스크랩 디테일 상위 섹션 정보 -->
        
        <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center"
        style="border:solid 1px; border-color:#dcdcdc;">
        
        <div class="scrapsetbutton">
        <div class="scrapSet" style="width:60px; position:absolute; left:75;" 
        data-toggle="modal" data-target="#setScrapFolder">
        <img src="<%=request.getContextPath() %>/resources/images/setbutton.png" width="50px" height="50px">
        </div></div>
            
            <div class="scrap_book" style=" height: 60px;">
                <h1 class="jumbotron-heading">${scrap.scrap_name}</h1>
            </div>
          
            <div class="my_info" style=" height:100px; ">
                
               <div class="row justify-content-md-center">
               
    <div class="col col-lg-2">
     
    </div>
    <div class="col-md-auto">
     
              <div class="image" style="float:left;">         
              <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" 
              width="100px" height="100px" >
              </div>
                
                 
          <div class="user_name" style="float:left; margin-left:60px;">
          <p class="font-weight-bold" style="font-size: 50px;">${member.member_id}</p>
                </div>
                
    </div>
    <div class="col col-lg-2">

    </div>
  </div>
                
            </div><!--아이디랑 사진정보-->
     </div>
     
     
     <!-- 스크랩북 설정 모달 -->
     
    <div class="modal fade" id="setScrapFolder" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">스크랩 폴더 수정</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="input" style="float:left;">
         <input type="text" id="name" placeholder=${scrap.scrap_name}>
         </div>
         <div class="deleteScrapFolder" style="margin-left:420px;">
        <a href="<%=request.getContextPath()%>/sidebar/scrapdelete?scrap_name=${scrap.scrap_name}&member_idx=${user.member_idx}">삭제</a><br> 
        </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary update">수정</button>
      </div>
    </div>
  </div>
</div>

     <!-- 사진 출력해주기 -->
     
     <div class="myfolderphotolist" style="margin-top:30px;">
     
     <div class="album py-5 bg-light">
     
       <div class="container">
                
                <div class="row">
                    
                    <c:forEach var="scrapPhotoList" items="${scrapPhotoList}" >
                    
                        <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        
                        <a href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${scrapPhotoList.board_idx}">
                        <img class="card-img-top" style="height: 225px; width: 100%; display: block;" 
                        src="<%=request.getContextPath()%>/resources/BoardPhoto/${scrapPhotoList.photo_name}" ></a>
                        
                        </div>
                    </div>
                    
                    </c:forEach>
                        
                      
                    </div>
                </div>
             </div>
     </div>

</main>
