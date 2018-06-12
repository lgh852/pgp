<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
</style>
<script type="text/javascript">
	$(function () {
		
		$(window).scroll(function () {
			var scrollHeight = $(window).scrollTop() + $(window).height();
			var documentHeight = $(document).height();
			
			if( scrollHeight + 200 >= documentHeight ){
				for(i=0 ; i<10 ; i++){
					$("body").append("<h1>jquery 무한 스크롤</h1>");
				}
			}
		});
		
		for(i=0 ; i<20 ; i++){
			$("body").append("<h1>jquery 무한 스크롤</h1>");
		}
	});
</script>


<ul class="nav nav-pills float-right">
   <li class="nav-item dropdown  btn-lg "><a
      class="nav-link dropdown-toggle  " data-toggle="dropdown" href="#"
      role="button" aria-haspopup="true" aria-expanded="false">정렬순</a>
      <div class="dropdown-menu">
         <a class="dropdown-item"
            href="<%=request.getContextPath()%>/furniture/furnitureRank?valueCnt=boardOrder">조회수
            순</a>
         <div class="dropdown-divider"></div>
         <a class="dropdown-item"
            href="<%=request.getContextPath()%>/furniture/furnitureRank?valueCnt=priceDesc">높은
            가격 순</a> <a class="dropdown-item"
            href="<%=request.getContextPath()%>/furniture/furnitureRank?valueCnt=priceAsc">낮은
            가격 순</a> <a class="dropdown-item"
            href="<%=request.getContextPath()%>/furniture/furnitureRank?valueCnt=regdateOrder">등록일
            순</a>
      </div></li>
</ul>


<div class="row" style="width: 100%"></div>

<div class="row mb-2">
   <c:forEach var="order" items="${orderList}" varStatus="status">

      <div class="col-md-6">
         <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
               <strong class="d-inline-block mb-2 text-primary"class="scrolling" data-bno="${status.count}">${status.count}위</strong>
               <h5 class="mb-0">
                  <a class="text-dark" href="${order.tag_url}">${order.tag_url_title}</a>
               </h5>
               <br>
               <div class="mb-1 text-muted">${order.tag_url_cnt}회</div>

               <p class="card-text mb-auto">
                  <fmt:formatNumber value="${order.tag_url_price}" />
                  원
               </p>
               <a href="${order.tag_url}">상품 페이지로 이동</a>
            </div>
            <a href="${order.tag_url}"> <img
               class="card-img-right flex-auto d-none d-md-block"
               data-src="${order.tag_url_img}" alt="${order.tag_url_img}"
               style="width: 200px; height: 250px;" src="${order.tag_url_img}"
               data-holder-rendered="true"></a>
         </div>
      </div>
   </c:forEach>
</div>

<nav class="blog-pagination float-right">
   <a class="btn btn-outline-primary" href="#">위로▲</a>
</nav>
