<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main role="main" class="container">
	
<!--마이페이지 스크랩북 상위 섹션-->
        
        <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
      
    
            <div class="scrap_book" style=" height: 80px;">
                <h1 class="jumbotron-heading">스크랩북</h1>
            </div>
          
            <div class="my_info" style=" height:40px; margin-top: 20px;">
                
                
                
                <div class="row justify-content-md-center">
    <div class="col col-lg-2">
     
    </div>
    <div class="col-md-auto">
     
              <div class="image" style="float:left;">         
              <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" 
              width="50px" height="50px" >
              </div>
                
                 
          <div class="user_name" style="float:left; margin-left:20px;">
          <p class="font-weight-bold" style="font-size: 20px;">${member.member_id}</p>
                </div>
                
    </div>
    <div class="col col-lg-2">

    </div>
  </div>
                
            
            </div><!--아이디랑 사진정보-->
            
            <div class="folder_nav" style="height: 60px; margin-top: 30px;">
            
          
                <ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="#">폴더</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">모두</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">사진</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">스토리</a>
  </li>
</ul>
            
            </div>
            
            
            
       
      
      </div>
        
        
        
        <!--각각 스크랩북들-->
        <div class="album py-5 bg-light">
        <div class="container">

          <div class="row container">
              
              <!--스크랩 북 추가하기-->
              <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                  
                  <div class="scrap_book_add" style="border-style:dashed border-color:gray; height: 226px; ">
          
                      <div class="scrap_book_name" style="height:30px; margin-top:90px; padding-left: 100px;">
                      +폴더 추가
                      </div>
              </div>
            </div>
              </div>
              
              
             <c:forEach var="scrapNameList" items="${scrapNameList}" varStatus="status">
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                src="#" >
             
             
             <div class="scarpfoldername">
             
            <a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name=${scrapNameList.scrap_name}">${scrapNameList.scrap_name}</a>
              
              </div>
            
            </div>
            </div>
            
            </c:forEach>
          
          </div>
        </div>
      </div>
        
        
</main>
    
    
		
