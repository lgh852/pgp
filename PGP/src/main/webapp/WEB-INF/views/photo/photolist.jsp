<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	.size{
		border: 1px solid black;
		width: 100%;
		height: 200px;
	}
	.censize{
		margin-top:30px;
		border: 1px solid black;
		width: 100%;
		height: 2000px;
	}
	

	.viewli{
	float: left;
	margin-top:50px;
	margin-left: 60px;
	 list-style-type: none;
}
.info{
	border: 1px solid black;
	width: 280px;
	height: 70px;
}
	
</style>

<div class="size"> </div>
<div class="censize"> 
	
		<c:forEach var="list" items="${list}">
		 <ul >
           <li class="viewli"><img src="<%=request.getContextPath()%>/resources/BoardPhoto/${list.photo_name}" width="280" height="280"><div class="info"></div></li>
     		
     </ul>
         </c:forEach>
 </div>
