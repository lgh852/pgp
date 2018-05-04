<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document)
			.ready(
					function() {
						var upload = $('#inputGroupFile02')[0], imgbox = document
								.getElementById('imgbox'), state = $('#inputGroupFile02');

						if (typeof window.FileReader === 'undefined') {
							state.className = 'fail';
						} else {
							state.className = 'success';

						}

						upload.onchange = function(e) {
							e.preventDefault();

							var file = upload.files[0], reader = new FileReader();
							reader.onload = function(event) {
								var img = new Image();
								img.src = event.target.result;
								$('#imgPre').attr("src",event.target.result);
								// note: no onload required since we've got the dataurl...I think! :)
								if (img.width > 450 || img.height > 450) {
									img.width = 430;

									if (img.height > 450) {
										img.height = 430;
									}

								}
								//imgbox.appendChild(img);
							};
							reader.readAsDataURL(file);

							return false;
						};
						$('#summernote').summernote({
							height : 300,
							width : 800,
							MinHeight : null,
							maxHeight : null,
							focus : true

						});

					});
</script>
<style>
#imgbox {
	width: 450px;
	height: 450px;
	margin: 0 auto;
	border: 1px solid black;
}

.inputsize {
	width: 250px;
}
    
    .imgcenter{
    	padding-top:50px;
   
        width:100%;
        height:550px;
        border: 1px solid black;
        overflow: hidden;

    }
    .margincen{
    	margin: 0 auto;
    	border: 1px solid black;
    }
</style>


<div class="imgcenter">
	<div id="imgbox">
	<img id="imgPre" alt="aa" src="" height="450px" width="450px" style="margin: 0 auto;">
	</div>
</div>

<form action="<%=request.getContextPath()%>/board/boardFrom"
	method="post" enctype="multipart/form-data">
	
	
	<input type="text" name="board_title">
	<div class="input-group mb-3 inputsize margincen">
	
		<div class="custom-file">
			<input type="file" class="custom-file-input fileboxsize"
				id="inputGroupFile02" name="FileName"> <label
				class="custom-file-label" for="inputGroupFile02">photo</label>
		</div>
		<div class="input-group-append">
			<span class="input-group-text">사진등록</span>
		</div>
		<div class="input-group mb-3 inputsize">
			<select class="custom-select" id="inputGroupSelect02"
				name="category_room">
				<option selected value="0">모든 공간</option>
				<option value="1">원룸</option>
				<option value="2">거실</option>
				<option value="3">침실</option>
				<option value="4">키친</option>
				<option value="5">욕실</option>
				<option value="6">아이방</option>
				<option value="7">드레스룸</option>
				<option value="8">서재&작업실</option>
				<option value="9">침실</option>
				<option value="4">베란다</option>
				<option value="5">사무공간</option>
				<option value="6">상업공간</option>
				<option value="7">가구&소품</option>
				<option value="8">현관</option>
				<option value="9">외관&기타</option>
				<option value="10">복도</option>
				<option value="11">제품후기</option>
			</select>
			<div class="input-group-append">
				<label class="input-group-text" for="inputGroupSelect02">공간</label>
			</div>
		</div>
		<div class="input-group mb-3 inputsize">
			<select class="custom-select" id="inputGroupSelect02"
				name="category_space">
				<option selected value="0">모든 평수</option>
				<option value="1">10평 미만</option>
				<option value="2">10평대</option>
				<option value="3">20평대</option>
				<option value="1">30평대</option>
				<option value="2">40평대 이상</option>
			</select>
			<div class="input-group-append">
				<label class="input-group-text" for="inputGroupSelect02">평수</label>
			</div>
		</div>
        
	<textarea rows="30" cols="30" id="summernote" name="board_contents"></textarea>
	<input type="submit" value="입력" /> <input type="reset" value="취소" />
	</div>


</form>
    
    

</html>
