<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 40px;
	height: 40px;
	border: 0px solid black;
	border-radius: 100px 100px 100px 100px;
	position: absolute;
	background-color: gray;
	text-align: center;
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
		style="max-width: 100%; width: 700px; margin: 0 auto;">

		<img width="100%" height="100%" id="imgtagbox"
			src="<%=request.getContextPath()%>/resources/BoardPhoto/${photo.photo_name}"
			style="max-height: 600px; min-height: 600px; margin: 0 auto;"
			class="border-0 img-thumbnail">

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
	<div class="taginfo none">
		<p class="inner">
			<a class="t_url"></a>
		</p>
		<button class="reinfo" onclick='reclick()'>취소</button>
		<button class="tagdelete">삭제</button>
		<input type="hidden" class="tagno">
	</div>

	<div id="viewbox" class="check1 none">

		<a href="#" class="aclick1 ">+</a>
	</div>
	<div id="viewbox" class="check2 none">
		<a href='#' class='aclick2'>+</a>
	</div>
	<div id="viewbox" class="check3 none">
		<a href='#' class='aclick3'>+</a>
	</div>
	<div id="viewbox" class="check4 none">
		<a href='#' class='aclick4'>+</a>
	</div>
	<div id="viewbox" class="check5 none">
		<a href='#' class='aclick5'>+</a>
	</div>
	<input type="hidden" id="tag1"> <input type="hidden" id="tag2">
	<input type="hidden" id="tag3"> <input type="hidden" id="tag4">
	<input type="hidden" id="tag5">

	
</div>

