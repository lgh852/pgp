<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

    .imgcenter{
    	padding-top:50px;
        width:100%;
        height:550px;
        border: 1px solid black;
        overflow: hidden;

    }
   	

</style>

 <c:forEach var="listPhoto" items="${listPhoto}">
 
	<a class="btn btn-primary" href="<%=request.getContextPath()%>/board/boardPhtoTagForm?board_idx=${listPhoto.board_idx}" role="button">페이지</a>

	<div class= "imgcenter" style="width: 450px,;height: 450px">
	
	<img src="<%=request.getContextPath()%>/resources/BoardPhoto/${listPhoto.photo_name}" height="450px" width="450px" style="margin: 0 auto;">
	</div>
	
</c:forEach>