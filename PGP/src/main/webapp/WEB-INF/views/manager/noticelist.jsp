<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">

function page(idx){
	
	var pagenum = idx;
	location.href="/p/manager/noticelist?pagenum="+pagenum+"&contentnum=5";
	
}

</script>

<!-- 공지사항 헤더 -->

  <div class="row" style="margin-top: 30px;width: 100%">
     <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center" style="border:solid 1px; border-color:white;width: 100%;
     background-image:url('<%=request.getContextPath()%>/resources/images/backgroundnotice.jpg');background-size:100%100%">
            <div class="faq_head " style=" height:120px;margin: 10px">
                  <p  style="font-weight:bold;font-size: 50px; color: white">느그집 관련 공지사항 </p>
             </div>
        
        </div>
      </div>
        
<!--공지사항 리스트-->
        
     
<c:forEach var="notice" items="${notices}">

<div class="notice_list" style="margin-top:30px; width:100%;height: 100%">
        
        <article class="questions-item border-top border-bottom">
          
            
            <div class="title" style="text-align: center;margin: 10" >
                   <p class=".text-dark" style="font-weight:bold;font-size: 30px">${notice.notice_title}</p>
            </div>
            
            <div class="contents" style="margin-top:10px;margin-left: 40px; margin-right: 40px; text-align: center;">
           <p class="questions-item__content text-caption-1" style="font-weight: 500">${notice.notice_contents}</p>

            </div>
         
          
            
            
            
                <div class="row" style="margin-bottom: 30px;">
                   
                 
  <div class="col-12 col-md-8"></div>
  <div class="col-6 col-md-4" style="text-align: right;font-weight: 600">작성일&emsp;<span style="margin: 0 10">
  <fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd"/></span></div>

            </div>
      
        </article>  

        </div>
        
        
        
        <c:if test="${manager != null}">

				<div class="button_set"
					style="margin-top: 10px; margin-bottom: 10px; padding-left: 1000px;">
					<a
						href="<%=request.getContextPath()%>/manager/noticeupdate?notice_idx=${notice.notice_idx}">
						<button type="button" class="btn btn-warning">수정</button>
					</a> <a
						href="<%=request.getContextPath()%>/manager/noticedelete?notice_idx=${notice.notice_idx}">
						<button type="button" class="btn btn-success">삭제</button>
					</a>

				</div>


			</c:if>
        
        
</c:forEach>


<!-- 공지사항 페이지 처리 -->

<div class="notice_footer" style="margin-top:30px; margin-left:470px;">

<nav aria-label="Page navigation example">
  <ul class="pagination">
  
    <c:if test="${pagenum.prev}">
    <li class="page-item"><a class="page-link" href="javascript:page(${pagenum.getStartPage()-1});">Previous</a></li>
    </c:if>
    
    
    <c:forEach begin="${pagenum.getStartPage()}" end="${pagenum.getEndPage()}" var="idx">
    
    <li class="page-item"><a class="page-link" href="javascript:page(${idx});">${idx}</a></li>
   
    </c:forEach> 
    
    
    <c:if test="${pagenum.next}">
    <li class="page-item"><a class="page-link" href="javascript:page(${pagenum.getEndPage()+1});">Next</a></li>
    </c:if>
    
  </ul>
</nav>



</div>

