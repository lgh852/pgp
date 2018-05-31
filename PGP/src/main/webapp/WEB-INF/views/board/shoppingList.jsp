
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
<script>
$(document).ready(function(){
		 $('.close').click(function(){
		 		alert('선택하셧습니다'); 
		 		opener.document.getElementById('link').value = document.getElementById('linkdata').value;
		 		opener.document.getElementById('lpricedata').value = document.getElementById('lpricedata').value;
		 		opener.document.getElementById('imagedata').value = document.getElementById('imagedata').value;
		 		opener.document.getElementById('titledata').value = document.getElementById('titledata').value;
		 		 window.close();
		 		
		 	});
	});
</script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	

	<center>
		<form action="shoppingList.do">
			<input type="text" name="keyword"> <input type="submit"
				value="검색">
		</form>

	</center>

	<c:if test="${shoppingList!=null}">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">사진</th>
				<th scope="col">제목</th>
				<th scope="col">가격</th>
				<th scope="col">판매mall</th>
				<th scope="col">선택</th>
				
			</tr>
		</thead>
		<tbody>

</c:if>

			<c:forEach items="${shoppingList}" var="b">
				<tr>
					<th scope="row"><a href="${b.link}"><img src="${b.image}"
							width="100px" height="100px"></a></th>
					<td><a href="${b.link}">${b.title}</a></td>
					<td>${b.lprice}</td>
					<td>${b.mallName}</td>
					<td><button type="button" class="btn btn-primary close" id="choice">선택</button> 
					<input type="hidden" value="${b.link}" id="linkdata">
					<input type="hidden" value="${b.lprice}" id="lpricedata">
					<input type="hidden" value="${b.image}" id="imagedata">
					<input type="hidden" value="${b.title}" id="titledata">
					

</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
