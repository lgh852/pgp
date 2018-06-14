<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   
    <main role="main" class="container">
	
<!--마이페이지 스크랩북 상위 섹션-->
        
        <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center"
        style="border:solid 1px; border-color:#dcdcdc;">
      
    
            <div class="scrap_book" style=" height: 80px;">
                <h1 class="jumbotron-heading" id="scrap_book">스크랩북</h1>
            </div>
          
            <div class="my_info" style=" height:100px; ">
                
                
                
                <div class="row justify-content-md-center">
    <div class="col col-lg-2">
     
    </div>
    
    <c:if test="${member.member_photo !=null}">
    <div class="col-md-auto">
     
              <div class="image" style="float:left;">         
              <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/memberphoto/${member.member_photo}" 
              width="100px" height="100px" >
              </div>
                
                 
          <div class="user_name" style="float:left; margin-left:60px;">
          <p class="font-weight-bold" style="font-size: 50px;">${member.member_id}</p>
                </div>
                
    </div>
    </c:if>
    
    
    <c:if test="${member.member_photo ==null}">
     <div class="col-md-auto">
     
              <div class="image" style="float:left;">         
              <img class="rounded-circle" src="<%=request.getContextPath()%>/resources/images/smilephoto.png" 
              width="100px" height="100px" >
              </div>
                
                 
          <div class="user_name" style="float:left; margin-left:60px;">
          <p class="font-weight-bold" style="font-size: 50px;">${member.member_id}</p>
                </div>
                
    </div>
     </c:if>
    
    
    <div class="col col-lg-2">

    </div>
  </div>
                
            
            </div><!--아이디랑 사진정보-->
            

      
      </div>
        
        
        
        <!--각각 스크랩북들-->
        <div class="album py-5 bg-light" style="margin-top:30px;">
        <div class="container">

          <div class="row container">
              
              <!--스크랩 북 추가하기-->
              <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                  
                  <div class="scrap_book_add" style="border-style:dashed; border-color:gray; height: 226px; ">
          
                     <a href="#">
                     <div id="scrapaddimage" style="position:absolute; top:42%; left:10%;">
                     <img src="<%=request.getContextPath() %>/resources/images/addbutton.png"></div>
                     
                      <div class="scrap_book_name" data-toggle="modal" data-target="#addScrapFolder"
                      style="position:absolute; top:35%;; left:26%; font-size:40px; color:#01A9DB;  ">
                      
                                                폴더추가
                     
                      </div>
                      </a>
                      
                          </div>
                        </div>
                           </div> 
               

              <!-- 스크랩북 리스트 -->
             
             
             
             
             
              <c:forEach varStatus="status" items="${photonameList}">
              
             
              
             <div class="col-md-4">
              <div class="card mb-4 box-shadow ">
              
             
          
               
              
              <c:if test="${photonameList[status.index] == 'nothing'}">
              
               <img class="card-img-top" alt="스크랩 폴더가 비어있어요!" id="scrapemtyimage${status.count}" style="height: 225px; width: 100%; display: block;" 
                src="<%=request.getContextPath()%>/resources/images/empty-glass.png" >
          
          
           <div class="scarpfoldername" style="font-size:60px; position: absolute; top: 60px; left:100px; font-color:white;">
             
            <a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name=${scrapNameList[status.index].scrap_name}">
            
                <span class="name" style="color:black;">${scrapNameList[status.index].scrap_name}</span></a>
               
              
              </div>
              
              
              </c:if> 
                 
              
              
              <c:if test="${photonameList[status.index] != 'nothing'}">
              
                <img class="card-img-top" alt="스크랩 폴더가 비어있어요!" style="height: 225px; width: 100%; display: block;" 
                src="<%=request.getContextPath()%>/resources/BoardPhoto/${photonameList[status.index]}" >
              
           <div class="scarpfoldername" style="font-size:60px; position: absolute; top: 60px; left:100px; font-color:white;">
             
            <a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name=${scrapNameList[status.index].scrap_name}" 
            style="text-decoration: none;">
            
                <span class="name" style="color:white">${scrapNameList[status.index].scrap_name}</span></a>
              
              </div>
           
            </c:if>
              
              
                
                </div>
              </div>
            
              
              </c:forEach>
          
          
          
          <div class="col-md-4">
              <div class="card mb-4 box-shadow ">
              <div class="scrapemtyimage"></div>
              
              <div class="scarpfoldernameadd" style="font-size:60px; position: absolute; top: 60px; left:100px; font-color:black;">
              
              
              
              </div>
              
              
              </div>
              </div>
          
          </div>
        </div>
      </div>
      
      
      
       <!-- 스크랩북 폴더 추가 모달 -->
                     <div class="modal fade" id="addScrapFolder" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">스크랩북을 선택하세요</h5>
					</div>
					<div class="modal-body">
						<ul class="list-group scrapList" id="scrapli" style="list-style:none;'">

							<c:forEach var="scrapNameList" items="${scrapNameList}"
								varStatus="status">
								<li>
									<button type="button"
										class="scrapSuccess${status.count} list-group-item list-group-item-action active btn-xs"
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
									placeholder="추가할 스크랩 폴더명을 입력해주세요 " />
									<input type="hidden" id="member_idx" value="${member.member_idx}"/>
							</div>

							<div class="w-100"></div>
							<div class="col-4"></div>
							<div class="col-8">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" style="margin-right: 10px;">닫기</button>
								<button type="button" class="btn btn-primary add">추가</button>
							</div>

						</div>



					</div>
				</div>
			</div>
		</div>
                            
        
        
</main>
    
    
		
