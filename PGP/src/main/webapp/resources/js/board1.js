$(document).ready(

		function() {
			var cnt=0;
			var tag_position__x;
			var tag_position__y;
			var board_idxs;
			var ch1;
			var ch2;
			var ch3;
			var ch4;
			var ch5;
			
			$("#shopping").click(
					function() {
						window.name = "boardform";
						window.open('/p/board/shoppingList', 'shopping',
								'width=800px , height=800', '_blank',
								left = '500', top = '500');

					});
			var imgtagbox = $('#imgtagbox');
			imgtagbox.click(function(event) {
				tag_position__x = event.offsetX;
				tag_position__y = event.offsetY;
				// alert('x'+x+'y'+y)
				$('.serchbox').css({
					"top" : tag_position__y,
					"left" : tag_position__x
				}).show()

			});

			// 버튼 클릭시 아작스 처리 tag 저장
			$('#tags').click(function() {
				var links = $("#link").val();
				board_idxs = $("#hidden_board_idx").val();
				
				$.ajax({
					type : 'GET',
					url : '/p/board/boardAjaxTag',
					dataType : 'text',
					data : {
						tag_url : links,
						board_idx : board_idxs,
						tag_position_y : tag_position__y,
						tag_position_x : tag_position__x

					},

					success : function(data) {
						
						var tag1 = $('#tag1').val();
						var tag2 = $('#tag2').val();
						var tag3 = $('#tag3').val();
						var tag4 = $('#tag4').val();
						var tag5 = $('#tag5').val();
						if (cnt <6) {
							alert('확인');
							if (tag1=='') {
								alert('성공1');
								$('.serchbox').css({
									"display" : 'none'
								})
								$('.check1').css({
									"top" : tag_position__y,
									"left" : tag_position__x
								}).show()
								$("#link").val('');
								$('#tag1').val(data);	
								ch1 =$('#tag1').val();	
								 
								cnt= cnt+1;
							} else if (tag2=='') {
								alert('성공2');
								$('.serchbox').css({
									"display" : 'none'
								})
								$('.check2').css({
									"top" : tag_position__y,
									"left" : tag_position__x
								}).show()
								$("#link").val('');
								$('#tag2').val(data);
								
								ch2 =$('#tag2').val();	
								cnt= cnt+1;
							} else if (tag3=='') {
								alert('성공3');
								$('.serchbox').css({
									"display" : 'none'
								})
								$('.check3').css({
									"top" : tag_position__y,
									"left" : tag_position__x
								}).show()
								$("#link").val('');
								$('#tag3').val(data);	
								ch3 =$('#tag3').val();	
								cnt= cnt+1;
							} else if (tag4=='') {
								alert('성공4');
								$('.serchbox').css({
									"display" : 'none'
								})
								$('.check4').css({
									"top" : tag_position__y,
									"left" : tag_position__x
								}).show()
								$("#link").val('');
								$('#tag4').val(data);	
								ch4 =$('#tag4').val();	
								cnt= cnt+1;
							} else if (tag5=='') {
								alert('성공5');
								$('.serchbox').css({
									"display" : 'none'
								})
								$('.check5').css({
									"top" : tag_position__y,
									"left" : tag_position__x
								}).show()
								$("#link").val('');
								$('#tag5').val(data);	
								ch5 =$('#tag5').val();	
								cnt= cnt+1;
							} if (data == '55') {
								alert('태그를 더이상 생성할수 없습니다 ')
								$('.serchbox').css({
									"display" : 'none'
								})
							} 
						} else {
							alert('태그를 더이상 생성할수 없습니다.')
							$('.serchbox').css({
								"display" : 'none'
							})
						}
					}
				});

			});
			// 삭제 버튼 클릭시
			$('.tagdelete').click(function() {
				alert('ddd');
				var tag_nos = $('.tagno').val();
				board_idxs = $("#hidden_board_idx").val()
				alert(tag_nos);
				alert(board_idxs);
				$.ajax({
					type : 'GET',
					url : '/p/board/tagdelete',
					dataType : 'text',
					data : {
						tag_idx : tag_nos,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'y') {
							// 성공
							$('.taginfo').hide('fast');
							$('.t_url').prop('href', '');
							$('.t_url').text('');
							$('.tagno').val('');
							$("#link").val('');
							
							if(ch1==tag_nos){
								alert('ss');
								$('.check1').css({
									"display" : 'none'
								})
								$('#tag1').val('');
							}if(ch2==tag_nos){
								alert('ss');
								$('.check2').css({
									"display" : 'none'
								})
								$('#tag2').val('');
							}if(ch3==tag_nos){
								alert('ss');
								$('.check3').css({
									"display" : 'none'
								})
								$('#tag3').val('');
							}if(ch4==tag_nos){
								alert('ss');
								$('.check4').css({
									"display" : 'none'
								})
								$('#tag4').val('');
							}if(ch5==tag_nos){
								alert('ss');
								$('.check5').css({
									"display" : 'none'
								})
								$('#tag5').val('');
							}

						} else if (data == 'n') {
							// 실패
							alert('다시 시도해주세요');

						} else {
							alert('에러');
						}

					}
				});
			});
			// 태그 클릭시
			// $('.inner').text('sdasd')
			$('.aclick1').click(function() {

				var tag1 = $('#tag1').val();
				board_idxs = $("#hidden_board_idx").val();
				alert('tag1' + tag1);
				alert('board_idxs' + board_idxs);
				$('.taginfo').css({
					"top" : '200px',
					"left" : '200px'
				}).show()
				$.ajax({
					type : 'GET',
					url : '/p/board/taginfo',
					dataType : 'text',
					data : {
						tag_idx : tag1,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'null') {
							alert('에러');

						} else {
							// 값이 있으면
							$('.t_url').text(data);
							$('.t_url').prop('href', data);
							$('.tagno').val(tag1);

						}

					}
				});
			});
			$('.aclick2').click(function() {

				var tag2 = $('#tag2').val();
				board_idxs = $("#hidden_board_idx").val();
				alert('tag2' + tag2);
				alert('board_idxs' + board_idxs);
				$('.taginfo').css({
					"top" : '200px',
					"left" : '200px'
				}).show()
				$.ajax({
					type : 'GET',
					url : '/p/board/taginfo',
					dataType : 'text',
					data : {
						tag_idx : tag2,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'null') {
							alert('에러');

						} else {
							// 값이 있으면
							$('.t_url').text(data);
							$('.t_url').prop('href', data);
							$('.tagno').val(tag2);

						}

					}
				});
			});
			$('.aclick3').click(function() {

				var tag3 = $('#tag3').val();
				board_idxs = $("#hidden_board_idx").val();
				alert('tag3' + tag3);
				alert('board_idxs' + board_idxs);
				$('.taginfo').css({
					"top" : '200px',
					"left" : '200px'
				}).show()
				$.ajax({
					type : 'GET',
					url : '/p/board/taginfo',
					dataType : 'text',
					data : {
						tag_idx : tag3,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'null') {
							alert('에러');

						} else {
							// 값이 있으면
							$('.t_url').text(data);
							$('.t_url').prop('href', data);
							$('.tagno').val(tag3);

						}

					}
				});
			});
			$('.aclick4').click(function() {

				var tag4 = $('#tag4').val();
				board_idxs = $("#hidden_board_idx").val();
				alert('tag4' + tag4);
				alert('board_idxs' + board_idxs);
				$('.taginfo').css({
					"top" : '200px',
					"left" : '200px'
				}).show()
				$.ajax({
					type : 'GET',
					url : '/p/board/taginfo',
					dataType : 'text',
					data : {
						tag_idx : tag4,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'null') {
							alert('에러');

						} else {
							// 값이 있으면
							$('.t_url').text(data);
							$('.t_url').prop('href', data);
							$('.tagno').val(tag4);

						}

					}
				});
			});
			$('.aclick5').click(function() {

				var tag5 = $('#tag5').val();
				board_idxs = $("#hidden_board_idx").val();
				alert('tag5' + tag5);
				alert('board_idxs' + board_idxs);
				$('.taginfo').css({
					"top" : '200px',
					"left" : '200px'
				}).show()
				$.ajax({
					type : 'GET',
					url : '/p/board/taginfo',
					dataType : 'text',
					data : {
						tag_idx : tag5,
						board_idx : board_idxs
					},
					success : function(data) {
						alert(data);
						if (data == 'null') {
							alert('에러');

						} else {
							// 값이 있으면
							$('.t_url').text(data);
							$('.t_url').prop('href', data);
							$('.tagno').val(tag5);

						}

					}
				});
			});

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
					$('#imgPre').attr("src", event.target.result);

					if (img.width > 450 || img.height > 450) {
						img.width = 430;

						if (img.height > 450) {
							img.height = 430;
						}

					}
					// imgbox.appendChild(img);
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
			// 정보 표시

		});
