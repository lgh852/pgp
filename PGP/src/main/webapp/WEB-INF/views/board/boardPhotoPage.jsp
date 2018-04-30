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
<script>
	

</script>

<form action="<%=request.getContextPath()%>/board/boardPhtoTagForm" method="post">
<button type="submit" class="btn btn-primary" >태그 페이지 </button>
</form>

 <c:forEach var="listPhoto" items="${listPhoto}">
	
	<div class= "imgcenter"><img src="<%=request.getContextPath()%>/resources/BoardPhoto/${listPhoto.photo_name}" height="430px" width="430px" style="margin: 0 auto;">
	</div>
	
	${listPhoto}
</c:forEach>