<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:if test="${user!=null}">
	<div class="col-xs-12 col-md-7 ">
	<div>
		<img src="<%=request.getContextPath()%>/resources/images/main.png"
			width="800px">
	</div>
</div>
<div class="hidden-xs hidden-sm col-md-5 text-right">
	<div class="screen-box screen-slider">
		<div class="item">
			<img src="<%=request.getContextPath()%>/resources/images/event.png"
				alt="">
		</div>
		<div class="item">
			<img src="<%=request.getContextPath()%>/resources/images/event.png"
				alt="">
		</div>
		<div class="item">
			<img src="<%=request.getContextPath()%>/resources/images/event.png"
				alt="">
		</div>
		<div class="item">
			<img src="<%=request.getContextPath()%>/resources/images/event.png"
				alt="">
		</div>
		<div class="item">
			<img src="<%=request.getContextPath()%>/resources/images/event.png"
				alt="">
		</div>
	</div>
</div>
	
	</c:if>
	<c:if test="${user==null}">
		${msg}
	</c:if>
