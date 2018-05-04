<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
table {
	overflow: hidden;
}

table>tr>td {
	list-style: none;
	position: absolute;
	float: left;
}
</style>
<table class="list-group-item list-group-item-info">

	<c:forEach var="p1" items="${photoList}">
		<tr height="60px">
			<td width="100px">${p1.photo_idx}사진번호</td>

			<td width="100px"><a
				href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${p1.board_idx}">
					<img
					src="<%=request.getContextPath()%>/resources/BoardPhoto/${p1.photo_name}"
					width="200px" height="200px">
			</a></td>
		</tr>
	</c:forEach>
</table>
