<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!--FAQ 상위 섹션-->
        
     <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center" style="border:solid 1px; border-color:#dcdcdc;
     margin-top:30px;">
      
    
            <div class="faq_head" style=" height: 80px; margin-top:30px;">
                <h1 class="jumbotron-heading">질문과 답변</h1>
            </div>
         
         <div class="faq_contents" style="font-size:20px;">
                ★자주 문의하는 질문에 대한 답변을 확인해보세요★
         </div>
          
   
      </div>
        
        
<!--FAQ 리스트-->
        
     <div class="faq_list" style="margin-top:30px;">
        
        <c:forEach var="faq" items="${faq}">
        
        <article class="questions-item" style="border-top: 1px solid; border-bottom: 1px solid; border-color:#dcdcdc;">
          
            <a href="<%=request.getContextPath()%>/manager/faqview?faq_idx=${faq.faq_idx}">
            <div class="title" style="margin-top:10px;">
            <h1 class="questions-item__title text-heading-5 bold text-black">${faq.faq_title}</h1>
            </div>
            
            <div class="contents" style="margin-top:10px">
            <p class="questions-item__content text-caption-1">
            ${faq.faq_contents}
            </div></a>
          
            <div class="regdate">
            <fmt:formatDate value="${faq.faq_regdate}" pattern="yyyy-MM-dd hh:mm"/>
            </div>
            
            <c:if test="${manager != null}">
            
                <div class="button_set" style="margin-top:10px; margin-bottom:10px; padding-left:1000px;">
                 <a href="<%=request.getContextPath()%>/manager/faqupdate?faq_idx=${faq.faq_idx}">
                <button type="button" class="btn btn-warning">수정</button></a>
                <a href="<%=request.getContextPath()%>/manager/faqdelete?faq_idx=${faq.faq_idx}">
                <button type="button" class="btn btn-success">삭제</button></a>
            
                </div>
            
            
            </c:if>
           
            
        </article>
        
        </c:forEach>
        
        
        
        
         
         
         
         
         
         
         
        
        </div>
       
        
        
        
	</main>
    
