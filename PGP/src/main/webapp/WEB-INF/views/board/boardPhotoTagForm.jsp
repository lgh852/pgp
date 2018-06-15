<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function reclick() {

		$('.taginfo').hide('fast');
		$('.t_url').text('');
		$('.t_url').prop('href', '');
		$('.tagno').val('');
	}
</script>
<style>
.taginfo {
	border: 1px solid black;
	width: 250px;
	height: 70px;
	position: absolute;
}

.reinfo {
	position: absolute;
	right: 5px;
}

.inner h4 {
	position: absolute;
	left: 10px;
	top: 10px;
}

.t_url {
	font-size: 3px;
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

#viewbox {
	/* width: 40px;
	height: 40px;
	border: 0px solid black;
	border-radius: 100px 100px 100px 100px;
	position: absolute;
	background-color: gray;
	text-align: center; */
}

.none {
	display: none;
}

.block {
	display: block;
}

.imgcenter {
	position: relative;
}
</style>


	<div style="width: 50%;margin-bottom:10px;margin-left: 74%;">
		<a class="btn btn-primary"
			href="<%=request.getContextPath()%>/photo/photodetail?board_idx=${photo.board_idx}"
			role="button">저장</a>

	</div>
<div class="imgcenter" style="margin: 0 auto">

	<div id="imgbox" class="border"
		style="max-width: 100%; width: 600px; margin: 0 auto;">

		<img width="100%" height="100%" id="imgtagbox"
			src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}"
			style="max-height: 600px;position:relative; min-height: 600px; margin: 0 auto;"
			class="border-0 img-thumbnail">
			
<c:forEach items="${urlList}" var="urlList" end="5"  begin="0" varStatus="status">
		
	<c:if test="${urlList.tag_idx!=null}">
	
	<div id="viewbox" class="check${status.count} block" data-toggle="modal" data-target="#exampleModal" <%-- style="left: ${urlList.tag_position_x}px;    position:absolute; top:${urlList.tag_position_y}px;" --%>>
		<a href="#" class="aclick${status.count} " data-toggle="modal" data-target="#exampleModal">
		
			<img
									src="<%=request.getContextPath()%>/resources/images/plus.png"
									alt="" width="40px" height="40px"style="left: ${urlList.tag_position_x}px; top: ${urlList.tag_position_y}px;position: absolute ">
									
									
		
		
		
		</a>
	</div>
	<input type="hidden" id="tag${status.count}" value="${urlList.tag_idx}">
	</c:if>
	<c:if test="${urlList.tag_idx==null||urlList==null}">
	<div id="viewbox" class="check${status.count} none" data-toggle="modal" data-target="#exampleModal">
		<a href="#" class="aclick${status.count} " data-toggle="modal" data-target="#exampleModal">+</a>
	</div>
	<input type="hidden" id="tag${status.count}">
	</c:if>
</c:forEach>
	<input type="hidden" id="tagIdx" class="tagno">
	</div>





	<div id="serchbutton" class="serchbox none">

		<button type="button" class="btn btn-primary" id="shopping"
			style="width: 85px; height: 35px;">상품검색</button>
		<input type="text" readonly="readonly" id="link"> <input
			type="hidden" id="lpricedata"> <input type="hidden"
			id="imagedata"> <input type="hidden" id="titledata">

		<button type="button" class="btn btn-primary " id="tags"
			style="width: 55px; height: 35px;">등록</button>
		<input type="hidden" id="hidden_board_idx" value="${board_idx}"
			name="board_idx">
	</div>
	
		


<div id="viewbox" class="check1 none" data-toggle="modal" data-target="#exampleModal">

		<a href="#" class="aclick1 " data-toggle="modal" data-target="#exampleModal">+</a>
	</div>
	<div id="viewbox" class="check2 none" data-toggle="modal" data-target="#exampleModal" >
		<a href='#' class='aclick2'>+</a>
	</div>
	
	<div id="viewbox" class="check3 none"data-toggle="modal" data-target="#exampleModal" >
		<a href='#' class='aclick3'>+</a>
	</div>
	<div id="viewbox" class="check4 none" data-toggle="modal" data-target="#exampleModal">
		<a href='#' class='aclick4'>+</a>
	</div>
	<div id="viewbox" class="check5 none" data-toggle="modal" data-target="#exampleModal">
		<a href='#' class='aclick5'>+</a>
	</div>
	<input type="hidden" id="tag1"> 
	<input type="hidden" id="tag2">
	<input type="hidden" id="tag3"> 
	<input type="hidden" id="tag4">
	<input type="hidden" id="tag5"> 
	
	
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
 
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <a class="t_url"></a>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       <button type="button" class="btn btn-secondary tagdelete">삭제</button>
      </div>
    </div>
  </div>
</div>
	
</div>
<%-- 	<c:forEach items="${urlList}" var="urlList" varStatus="status">
		
		<input type="hidden" value="${urlList.tag_idx}" id="tag_idx${status.count}">
	<input type="hidden" value="${urlList.tag_position_x}" id="tag_x${status.count}">
	<input type="hidden" value="${urlList.tag_position_y}" id="tag_y${status.count}">
	</c:forEach> --%>
<script>

$(document).ready(function (){
	var list = $('#urllist').val();
	alert(list);
	
	var url = list.split('Url_Tag [')
	var lists = url[1].split(',')
	var sss = lists[3].split('=');
		
	var date = new Object();


		
	
});

</script>