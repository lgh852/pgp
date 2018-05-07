<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
  
    
</script>
<style>
    .taginfo{
        border: 1px solid black;
        width: 100px;
        height:100px;
        position: absolute;
        
    }
    .reinfo{
        position: absolute;
        right: 5px;            
    }
</style>

<style>
.serchbox {
	width: 370px;
	height: 60px;
	border: 2px solid black;
	padding-top: 10px;
	padding-left: 20px;
	border-radius: 10px 10px 10px 10px;
	position: absolute;
}
#viewbox{
	width: 40px;
	height: 40px;
	border: 0px solid black;
	border-radius: 100px 100px 100px 100px;
	position: absolute;
	background-color: gray;
	text-align: center;
}

.imgcenter {
	position: relative;
}
</style>
<c:forEach var="photo" items="${photo}">

	<div class="imgcenter">
		<img
			src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}"
			height="450px" width="450px"
			style="margin: 0 auto; border: 1px solid black;" id="imgtagbox">
		<div id="serchbutton" class="serchbox">
			<button type="button" class="btn btn-primary" id="shopping"
				style="width: 85px; height: 35px;">상품검색</button>
			<input type="text" readonly="readonly" id="link">
			<button type="button" class="btn btn-primary" id="tags"
				style="width: 55px; height: 35px;">등록</button>
				<input type="hidden" id ="hidden_board_idx"value="${board_idx}"  name="board_idx">
		</div>
		 <div class="taginfo"><p class="inner"><a></a></p><button class="reinfo" onclick='reclick()'>취소</button></div>
		<div id="viewbox" class="check1"><a  href="#" onClick='aclick()'>+</a></div>
		<div id="viewbox" class="check2"><a  href='#' onClick='aclick()' >+</a></div>
		<div id="viewbox" class="check3"><a  href='#' onClick='aclick()'>+</a></div>
		<div id="viewbox" class="check4"><a  href='#' onClick='aclick()'>+</a></div>
		<div id="viewbox" class="check5"><a  href='#' onClick='aclick()'>+</a></div>
		<input type="hidden" id="tag1">
		<input type="hidden" id="tag2">
		<input type="hidden" id="tag3">
		<input type="hidden" id="tag4">
		<input type="hidden" id="tag5">
		
	</div>
	

</c:forEach>