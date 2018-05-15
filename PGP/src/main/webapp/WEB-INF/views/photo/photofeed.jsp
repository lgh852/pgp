<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
table{
		width: 100%;
height: 3000px;

}



.trview{
	float: left;
	margin-top: 50px;
	margin-left: 60px;
	list-style-type: none;
}


</style>
<table class="list-group-item list-group-item-info">

	<c:forEach var="p1" items="${photoList}">
		<tr class="trview" width="200px" height="100px">
			<td class="tdview" width="50px">${p1.photo_idx}사진번호</td>
			<td  class="tdview" width="50px">${p1.board_idx}게시글번호</td>
			<td  class="tdview" width="30px" height="30px"><a
				href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${p1.board_idx}">
					<img
					src="<%=request.getContextPath()%>/resources/memberphoto/${p1.photo_name}"
					width="200px" height="200px">
			</a></td>
		</tr>
	</c:forEach>
</table>
