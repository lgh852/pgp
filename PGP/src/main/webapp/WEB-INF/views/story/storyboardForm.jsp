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

.margincen {
	margin: 0 auto;
}

.reg {
	margin-left: 270px;
	width: 100px;
	height: 30px;
	position: absolute;
	float: left;
}

.custom-file {
	margin-left: 275px;
	float: left;
	overflow: hidden;
}

.storyTextarea {
	resize: none;
}

.list-group-item-warning {
	color: #f8f9fa;
	background-color: #007bff;
}
</style>
<!-- 글쓰기  -->
<div
	style="border: 3px double #0969bf; height: 320px; width: 100%; padding-top: 3px;">
	<form action="<%=request.getContextPath()%>/story/storyboardForm"
		method="post" enctype="multipart/form-data"
		style="width: 100%; position: relative;" name="form1">

		<div class="input-group mb-3 inputsize margincen" style="width: 50%">
			<textarea rows="6px" cols="100%" name="storyboard_contents"
				class="storyTextarea"
				onclick="if(document.form1.incontent.value != '1'){ this.value=''; document.form1.incontent.value = '1'}">
 		  사진과 글을 공유해보세요.
		</textarea>
			<input type="hidden" name="incontent">
		</div>

		<div class="imgcenterLine">
			<div id="imgboxSave">
				<img id="imgPre" alt="pic" src="" height="100px" width="100px"
					style="margin: 0 auto;">
			</div>
		</div>

		<!--파일등록 -->
		<div style="height: 60px; margin: 4px auto;">
			<div class="custom-file" style="width: 200px; height: 38px;">
				<input type="file" class="custom-file-input fileboxsize"
					id="inputGroupFile02" name="FileName"> <label
					class="custom-file-label" for="inputGroupFile02">찾아보기</label>
			</div>
			<input type="submit" value="등록" class="reg btn btn-primary"
				style="padding: 0px; height: 38px;">
		</div>

	</form>
</div>

<div style="height: 50px"></div>

<!-- 스토리보드  -->
<c:forEach var="listStory" items="${listStory}" varStatus="status">
	<div style="border: 1px solid #434c5475;">
		<form action="storyboardComment" method="post">
			<div style="border-bottom: 3px double #434c5475; width: 100%;">
				<div class="trview">
					<div class="tdview" style="height: 100px">
						<img
							src="<%=request.getContextPath()%>/resources/memberphoto/${listStory.member_photo}"
							width="50px" height="60px" style="border-radius: 50%;padding: 3px;">
						아이디::${listStory.member_id}

						<div style="color: #939393">
							Date:
							<fmt:formatDate pattern="yyyy년 MM월 dd일 HH:mm:ss"
								value="${listStory.storyboard_regdate}" />
							<br>
						</div>


						<div style="text-align: right; padding: 0px 5px 0px;">
							<!-- 신고기능 -->
							<button type="button" style="" class="btn btn-outline-warning"
								data-toggle="modal" data-target="#reportBtn${status.count}"
								onclick="reportClickBtn(${status.count})">신고</button>
							<!-- 삭제기능 -->
							<c:if test="${listStory.member_idx==user.member_idx}">
								<a class="btn btn-outline-danger"
									href="<%=request.getContextPath()%>/story/storyboardDelete?storyboard_idx=${listStory.storyboard_idx}"
									role="button">삭제</a>
							</c:if>
						</div>
						<!-- 신고 눌렀을때  -->
						<div class="modal fade" id="reportBtn${status.count}"
							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
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
										<div id="reportPopupView${status.count}"
											class="reportPopupView">
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
												value="${listStory.storyboard_idx}"> <input
												type="hidden" id="member_idx${status.count}"
												value="${listStory.member_idx}">

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

					</div>
				</div>

				<!-- 글내용 -->
				<div class="trview" style="width: 100%; padding: 20px; ">
					<div class="tdview" style="width: 100%">${listStory.storyboard_contents}</div>
				</div>
				<!--사진  -->
				<div class="trview" style="width: 100%">
					<div class="tdview"
						style="width: 100%; text-align: center; padding: 20px;">
						<img
							src="<%=request.getContextPath()%>/resources/StoryPhoto/${listStory.storyboard_photo}"
							width="400px" height="290px">
					</div>
					<div>

						<input type="hidden" class="storyboard_idx${status.count}"
							value="${listStory.storyboard_idx}"> <input type="hidden"
							class="member_idx${status.count}" value="${user.member_idx}">

						<!-- 좋아요기능 -->
						<c:if test="${listStory.likeck==null}">
							<a onclick="likestoryClick(${status.count})"> <img
								class="storylike_heart${status.count}"
								src="<%=request.getContextPath()%>/resources/images/heart1.png"
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
								src="<%=request.getContextPath()%>/resources/images/heart2.jpg"
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
				</div>
			</div>

			<!-- 댓글 쓰기 기능  -->
			<div class="input-group mb-3">
				<input name="storyboard_comment_contents" type="text"
					class="form-control list-group-item list-group-item-secondary"
					placeholder="${listStory.storyboard_idx} 게시판: 댓글을 입력해보세요."
					aria-label="Recipient's username" aria-describedby="basic-addon2">
				<input type="hidden" value="${listStory.storyboard_idx}"
					name="storyboard_idx">
				<div class="input-group-append">
					<button
						class="btn btn-outline-secondary list-group-item list-group-item-warning"
						type="submit">send</button>
				</div>
			</div>

			<!--댓글 리스트  -->
			<table style="width: 100%">
				<c:forEach var="listStroyComment" items="${listStroyComment}">
					<c:if
						test="${listStroyComment.storyboard_idx==listStory.storyboard_idx}">
						<tr height="60px" class="list-group-item">
							<td width="150px">ID:${listStroyComment.member_id}</td>
							<td width="600px">${listStroyComment.storyboard_comment_contents}</td>
							<td width="250px"><fmt:formatDate
									pattern="yyyy년 MM월 dd일 HH:mm:ss"
									value="${listStroyComment.storyboard_comment_regdate}" /></td>
							<c:if test="${listStroyComment.member_idx==user.member_idx}">
								<td width="50px"><a
									href="<%=request.getContextPath()%>/story/storyboardCommentDelete?storyboard_comment_idx=${listStroyComment.storyboard_comment_idx}">삭제</a>
								</td>
							</c:if>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</form>
	</div>

	<div style="height: 10px"></div>
</c:forEach>








