<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
#imgboxSave {
	width: 100px;
	height: 100px;
	margin: 0 auto;
	border: 2px dotted #0552ce54;
}

.imgcenterLine {
	margin-left: 275px;
	width: 100px;
	height: 100px;
	overflow: hidden;
}

.storyTextarea {
	resize: none;
}
</style>
<script>
$(document).ready(function () {
var seck = $('#seck').val();
  

  
	   $('#storyreg').submit(function(){
		  
		   if(seck==''){
			   alert('로그인후 이용부탁드립니다');
				window.location = "/p/member/loginform";
			   return false;		
			} 
       });
	   $('#cmments').submit(function() {
		
		   if(seck==''){
			   alert('로그인후 이용부탁드립니다');
				window.location = "/p/member/loginform";
			   return false;		
			} 
		   
	});
	   $('#inputGroupFile02').click(function(){
		   if(seck==''){
			   alert('로그인후 이용부탁드립니다');
			   event.preventDefault();
				window.location = "/p/member/loginform";
			 		
			} 
	   });
	  
	   
		   
	   
})
</script>
<!--로그인 여부 체크를 위한 -->


<input type="hidden" id="seck" value="${seck.member_idx}">
<input type="hidden" id="member_id" value="${seck.member_id}">

<div class="py-5 text-center" style="width: 100%;    background-image: url(/p/resources/images/roompic6.jpg);color:white;">
	
	<h2>
		느그집
		<code style="font-weight: bolder;color:#b36d13a8;">STORY</code>
	</h2>
	<p class="lead" style="TEXT-ALIGN: CENTER;font-weight: bolder;">함께 소통해보세요</p>
</div>
<div  style="height:100px"></div>



<div class="card" style="margin-top:  20px;width: 100%;background-color: #e9ecef;">
	<form action="<%=request.getContextPath()%>/story/storyboardForm"
		method="post" enctype="multipart/form-data"
		style="width: 100%; position: relative;" id="storyreg" name="form1">

		<div class="card-body">
			<h5 class="card-title">느그집 Story</h5>
			<div>
				<textarea rows="8"
					style="resize: none; width: 100%; border: 1px solid #0000002e;"
					name="storyboard_contents" class="storyTextarea"
					placeholder="사진과 글을 공유해보세요(200자까지)	" maxlength="200"></textarea>
			</div>
		</div>


		<img style="margin-left: 20px; background-color: #e9ecef;" src=""
			alt="" width="20%" height="200px" class="img-thumbnail rounded "
			id="imgPre">

		<div class="card-body">
			<div class="custom-file" style="width: 200px; height: 38px;">
				<input type="file" class="custom-file-input fileboxsize"
					id="inputGroupFile02" name="FileName"> <label
					class="custom-file-label" for="inputGroupFile02">찾아보기</label>
			</div>


			<input type="submit" value="등록"
				class="btn btn-lg btn-success float-right" role="button">
		</div>

	</form>
</div>




<c:forEach var="listStory" items="${listStory}" varStatus="status">
<hr class="featurette-divider" style="width: 100%">
	<div class="row featurette" style="width: 100%;">

		<div class="col-md-7" style="width: 100%">



			<h4 class="featurette-heading">
				<img
					src="<%=request.getContextPath()%>/resources/memberphoto/${listStory.member_photo}"
					width="50px" height="60px"
					style="border-radius: 50%; padding: 3px;">ID[${listStory.member_id}]

				<!-- 신고기능 -->
				<button type="button" style="" class="btn btn-outline-warning"
					data-toggle="modal" data-target="#reportBtn${status.count}"
					onclick="reportClickBtn(${status.count})">신고</button>
				<!-- 삭제기능 -->
				<c:if test="${listStory.member_idx==user.member_idx}">
					<a class="btn btn-outline-danger"
						href="<%=request.getContextPath()%>/story/storyboardDelete?storyboard_idx=${listStory.storyboard_idx}"
						
						role="button" >삭제</a>
				</c:if>


			</h4>
			<span class="text-muted"> Date: <fmt:formatDate
					pattern="yyyy년 MM월 dd일 HH:mm:ss"
					value="${listStory.storyboard_regdate}" /></span>

			<p class="lead">${listStory.storyboard_contents}</p>

		</div>



		<div class="col-md-5">
			<img class="featurette-image img-fluid mx-auto"
				data-src="<%=request.getContextPath()%>/resources/StoryPhoto/${listStory.storyboard_photo}"
				alt="" style="width: 100%;height: 240px;margin-top: 75px;"
				src="<%=request.getContextPath()%>/resources/StoryPhoto/${listStory.storyboard_photo}"
				data-holder-rendered="true">
		</div>


	</div>

	<!-- 좋ㅇ아요 -->
	<div style="width: 100%">
		<input type="hidden" class="storyboard_idx${status.count}"
			value="${listStory.storyboard_idx}"> <input type="hidden"
			class="member_idx${status.count}" value="${user.member_idx}">

		<!-- 좋아요기능 -->
		<c:if test="${listStory.likeck==null}">
			<a onclick="likestoryClick(${status.count})"> <img
				class="storylike_heart${status.count}"
				src="<%=request.getContextPath()%>/resources/images/heart.png"
				width="24px" height="24px"> <c:if
					test="${listStory.storyboard_like==0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count} ">
					<span class="cntss${status.count}"></span>
					<span class="likeTEXT${status.count}">제일 먼저 좋아요를 눌러보세요~</span>
				</c:if> <c:if test="${listStory.storyboard_like!=0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count}">
					<span class="cntss${status.count}">${listStory.storyboard_like}</span>
					<span class="likeTEXT${status.count}"> 명이좋아합니다♥</span>
				</c:if>
			</a>
		</c:if>

		<c:if test="${listStory.likeck!=null}">
			<a onclick="likestoryClick(${status.count})"> <img
				class="storylike_heart${status.count}"
				src="<%=request.getContextPath()%>/resources/images/heart2.png"
				width="24px" height="24px"> <c:if
					test="${listStory.storyboard_like!=0}">
					<input type="hidden" value="${listStory.storyboard_like}"
						class="likecnt${status.count} ">
					<span class="cntss${status.count}">${listStory.storyboard_like}</span>
					<span class="likeTEXT${status.count}"> 명이 좋아합니다♥</span>
				</c:if>
			</a>
		</c:if>
	</div>
	<hr class="featurette-divider" style="width: 100%">
	<!-- 댓글 쓰기 기능  -->
	<div style="width: 100%">
			<div class="input-group">
				<input name="storyboard_comment_contents" type="text"
					class="form-control"
					placeholder="${listStory.storyboard_idx} 게시판: 댓글을 입력해보세요." id="commenttext${listStory.storyboard_idx}">
				<input type="hidden" value="${listStory.storyboard_idx}"
					name="storyboard_idx" >
				<div class="input-group-append">
					<button  class="btn btn-secondary" onclick='storycomment(${listStory.storyboard_idx})'>send</button>
				</div>
			</div>




			<!--댓글 리스트  -->


			<ul class="list-group mb-3" style="width: 100%" id="comlists" >
				<c:forEach var="listStroyComment" items="${listStroyComment}">
					<c:if
						test="${listStroyComment.storyboard_idx==listStory.storyboard_idx}">

						<li id="storycomments${listStroyComment.storyboard_comment_idx}"
							class="list-group-item d-flex justify-content-between lh-condensed"
							style="width: 100%">
							<div>
								<h6 class="my-0">${listStroyComment.storyboard_comment_contents}</h6>
								<small class="text" style="color:black">ID:${listStroyComment.member_id}
									&nbsp &nbsp <fmt:formatDate pattern="yyyy년 MM월 dd일 HH:mm:ss"
										value="${listStroyComment.storyboard_comment_regdate}" />

								</small>
							</div> <span class="text" > <c:if
									test="${listStroyComment.member_idx==user.member_idx}">
									<a href="#"onclick="deletestrorycomment(${listStroyComment.storyboard_comment_idx})">삭제</a>

								</c:if></span>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		
	</div>



	

	<!-- 신고 눌렀을때  -->
	<div class="modal fade" id="reportBtn${status.count}" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">신고</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!--신고내용  -->
					<div id="reportPopupView${status.count}" class="reportPopupView">
						<div class="report_reason">
							<select class="reason" id="report_contents${status.count}"
								name="report_contents" style="width: 100%;">
								<option selected value="0">주제와 맞지 않음</option>
								<option selected value="1">정보가 부정확함</option>
								<option selected value="2">지나친 광고성 게시물</option>
								<option selected value="3">도배 및 중복 게시물</option>
								<option selected value="4">저작권 침해가 우려됨</option>
								<option selected value="5">욕설/비방이 심함</option>
								<option selected value="6">외설적인 게시물</option>
							</select>
						</div>

						<input type="hidden" id="storyboard_idx${status.count}"
							value="${listStory.storyboard_idx}"> <input type="hidden"
							id="member_idx${status.count}" value="${listStory.member_idx}">

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" id="closePopuppage${status.count}">취소</button>
					<button type="button" class="btn btn-warning"
						id="submitReportpage${status.count}">신고하기</button>
				</div>
			</div>
		</div>
	</div>


</c:forEach>


<script>
	$(document).ready(function() {
		/* $('#storycomment').click(){
			alert('asd');
		} */
		
	
	})
	function storycomment(e){
			
		var storyboard_idx = e;
		var storyboard_comment_contents = $('#commenttext'+e).val();
		var member_idx = $('#seck').val();
		
		alert(storyboard_idx);
		alert(storyboard_comment_contents);
		alert(member_idx);
		if(storyboard_comment_contents!=''){
			alert('값있음')
			if(member_idx!=''){
				$.ajax({
					type : 'GET',
					url : '/p/story/storyboardComment',
					dataType : 'text',
					data : {

						storyboard_idx:storyboard_idx,
						storyboard_comment_contents:storyboard_comment_contents,
						member_idx:member_idx
						
					},success : function(data) {
						var Now = new Date();
						alert(data)
						var NowTime = Now.getFullYear();

						NowTime += '년 ' + Now.getMonth();

						NowTime += '월 ' + Now.getDate();

						NowTime += '일 ' + Now.getHours();

						NowTime += ':' + Now.getMinutes();

						NowTime += ':' + Now.getSeconds();
	
						var member_id = $('#member_id').val();
						
						var html = '<li class="list-group-item d-flex justify-content-between lh-condensed"';
							html +='style="width: 100%">';
							html +='<div><h6 class="my-0">'+storyboard_comment_contents+'</h6>';
							html +='<small class="text-muted">ID:';
							html +=member_id+'&nbsp &nbsp'+NowTime+'</small></div>';
							html +='<span class="text-muted">';
							html +='<a href="#" onclick="deletestrorycomment('+data+')">삭제</a>';
							html +='</span></li>';
							$('#comlists').append(html);
				
							alert(html);
					}
					});
				
			}else{
				//로그인후
				alert('로그인후 이용해주세요');
			}
		}else{
			alert('값을 입력해주세요')
		}
	};
		
	function deletestrorycomment(e) {
		
		var storyboard_comment_idx = e;
			
		alert(storyboard_comment_idx);
		if(storyboard_comment_idx!=null){
			//있으면
		$.ajax({
				type : 'GET',
				url : '/p/story/storyboardCommentDelete',
				dataType : 'text',
				data : {
					storyboard_comment_idx:storyboard_comment_idx
				},success : function(data) {
					$('#storycomments'+e).remove();
					
				}
	
		})
		
				
		}else{
			alert('확인해주세요')
		}
	}

	
	
</script>
