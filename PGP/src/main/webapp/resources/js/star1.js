$(document)
		.ready(

				function() {

					var listnum;

					/* 스크랩 폴더 추가 */

					$("#scrapPopup").hide();

					$(".add")
							.click(
									function() {
										var scrapFolderName = $(
												".scrapFolderName").val();

										var c = $(".listnumber").val();

										var member_idx = $("#memb_idx").val();
										
										if (member_idx == null) {
											member_idx = $('#member_idx').val();
										}

										var scrapbookcheck;

										var scrapbookcheck = $("#scrap_book")
												.text();

										$
												.ajax({

													type : 'GET',
													url : '/p/sidebar/scrap',
													dataType : 'text',
													data : {

														scrap_name : scrapFolderName,
														member_idx : member_idx

													},
													success : function(data) {
														alert(data);

														if (data == 'y') {

															c = ++c;

															$('.scrapList')
																	.append(
																			'<li><span><button type="button" class="list-group-item list-group-item-action active" onclick="scrapButton("'
																					+ c
																					+ '")">'

																					+ scrapFolderName
																					+ "</button></span></li>");

															$(
																	'.scrapSuccess'
																			+ c)
																	.text(
																			scrapFolderName);

														} else {

														}

														$('.scrapemtyimage')
																.append(
																		'<img class="card-img-top" alt="스크랩 폴더가 비어있어요!" id="scrapemtyimage("'
																				+ c
																				+ '")" style="height: 225px; width: 100%; display: block;" src="/p/resources/images/empty-glass.png">')
														$('.scarpfoldernameadd')
																.append(
																		'<a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name='
																				+ scrapFolderName
																				+ '">'
																				+ '<span class="name" style="color:black">'
																				+ scrapFolderName
																				+ '</span></a>')

														$("#scrapPopup").hide();
													}
												});

									});

					$('#close').on('click', function() {
						$("#scrapPopup").hide();

					});

				

				});


/////////////////////////////////////////사이드바 스크랩 추가 

function scrapButton(s) {
	var scraplistck = $('#scraplist').val();

	if(scraplistck=='list'){
		alert(s);
		 var member_idx = $("#memb_idx").val();
		if(member_idx!=''){
		
			var board_idx = $(".bidx"+listnum).val();
			var scrap_name_choice = $(".scrapSuccess"+s).text();
			 var scrapcnts = $('#scrapCnts'+listnum).text();
			 alert(member_idx);
			 alert(board_idx);
			 alert(scrap_name_choice);
			 alert(scrapcnts);
			 $.ajax({

					type : 'GET',
					url : '/p/sidebar/scrapInsert',
					dataType : 'text',
					data : {
						board_idx : board_idx,
						member_idx : member_idx,
						board_scrap : scrapcnts,
						scrap_name : scrap_name_choice
					},
					success : function(data) {
						if(data=='y'){
							alert('성공')
							
							$('#scrapCnts'+listnum).text( parseInt(scrapcnts)+1);
								$('.scrapckss'+listnum).attr('src','/p/resources/images/scrap2.png');
							$('.fade').hide();
						}else{
							
						
							
						}
						
						
					
						
					}
					
					

				});
				
		}else{
			alert('로그인후 이용 부탁드립니다')
		}
		
			  
	}else{
		
		var member_idx = $("#member_idx").val();
		if(member_idx!=null){
			
	
		var board_idx = $("#board_idx").val();
		var scrap_name_choice = $(".scrapSuccess" + s).text();
	    var scrapcnts = $('#scrapCnt').text();
		var scrapcnt = parseInt(scrapcnts);



		$.ajax({

			type : 'GET',
			url : '/p/sidebar/scrapInsert',
			dataType : 'text',
			data : {

				board_idx : board_idx,
				member_idx : member_idx,
				board_scrap : scrapcnt,
				scrap_name : scrap_name_choice

			},

			success : function(data) {

				if (data == 'y') {

					scrapcnt = scrapcnt + 1;

					
					$('#scrapid').removeClass('btn btn-outline-info').addClass(
								'btn btn-info');
					$('.count').text(scrapcnt);
						
						$("#scrapPopup").hide();
						
						$(".fade").hide();
					}else if (data == 'n') {
					
						scrapcnt = scrapcnt - 1;

						$('.count').text(scrapcnt);
						$('#scrapid').removeClass('btn btn-info').addClass(
								'btn btn-outline-info');
						
				} else {
					
				}

			}

		});
		}else{
			alert('로그인후 이용 부탁드립니다')
		}
		}
	

}

//////////////////////////////////////////////사이드바 스크랩 해제 

function scrapPopup() {
	var member_idx =$("#member_idx").val();
	
	if(member_idx!=''){
		var board_idx = $("#board_idx").val();
		var scrapcnts = $('#scrapCnt').text();
		var scrapcnt = parseInt(scrapcnts);

		$.ajax({

			type : 'GET',
			url : '/p/sidebar/scrapCheck',
			dataType : 'text',
			data : {
				board_idx : board_idx,
				member_idx : member_idx,
				board_scrap : scrapcnt
			},

			success : function(data) {

				if (data == 'y') {

					// 안했으면 show

					$("#scrap > a").blur();
					$("#scrapPopup").show();
					$("#scrapPopup a").focus();

				} else if (data == 'n') {

					scrapcnt = scrapcnt - 1;

					$('.count').text(scrapcnt);
					$('#scrapid').removeClass('btn btn-info').addClass(
							'btn btn-outline-info');
					$('#scrapCnts' + s).text(scrapcnt);
				} else {

				}

			}
		});
	}else{
		alert('로그인후 이용 부탁드립니다')
	}
	
	
	
}

function likeClick() {

	var likcnts = $('#likecnt').text();
	var likecnt = parseInt(likcnts);
	var board_idx = $("#board_idx").val();
	var member_idx = $("#member_idx").val();

	$.ajax({
		type : 'GET',
		url : '/p/sidebar/like',
		dataType : 'text',
		data : {
			board_idx : board_idx,
			member_idx : member_idx,
			board_like : likecnt
		},

		success : function(data) {

			if (data == 'y') {

				likecnt = likecnt + 1;

				$('.countcount').text(likecnt);
				$('#ck').text(likecnt);

				$('#likeid').removeClass('btn btn-outline-danger').addClass(
						'btn btn-danger');

			} else if (data == 'n') {

				if (likecnt > 0) {

					likecnt = likecnt - 1;

					$('.countcount').text(likecnt);

					$('#likeid').removeClass('btn btn-danger').addClass(
							'btn btn-outline-danger');
				}

			} else {
				alert('에러');
			}

		}

	});

}

function scrapPopups(e) {

	var board_idx = $("#board_idx" + e).val();
	var member_idx = $("#member_idx" + e).val();
	var scrapcnts = $('#scrapCnts' + e).text();
	 listnum = e;///////asdasdasda
	
	var scrapcnt = parseInt(scrapcnts);

	$.ajax({

		type : 'GET',
		url : '/p/sidebar/scrapCheck',
		dataType : 'text',
		data : {
			board_idx : board_idx,
			member_idx : member_idx,
			board_scrap : scrapcnt
		},

		success : function(data) {

			if (data == 'y') {

				// 안했으면 show
				$("#exampleModal").modal('show')
				$('#board_idx').val(board_idx);
				$('#scrapCnt').val(scrapcnts);
				listnum = e;
			} else if (data == 'n') {

				scrapcnt = scrapcnt - 1;

				$('#scrapCnt' + e).text(scrapcnt);
				$('#board_idx').val(board_idx);
				$('#scrapCnt').val(scrapcnts);
				$('#ck').val(e);
				$('#scrapCnts' + e).text(scrapcnt);
				$('.scrapckss' + e)
						.attr('src', '/p/resources/images/scrap.png')

				// 몇번찌인지 저장

				// 처리해야댐
				$('#scrapid').removeClass('btn btn-info').addClass(
						'btn btn-outline-info');

			} else {

				alert('로그인후 이용해주세요');

			}

		}
	});
}
