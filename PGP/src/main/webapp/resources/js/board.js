$(document).ready(
		
		function() {
			var tag_position__x;
			var tag_position__y;
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
			
			
			//버튼 클릭시 아작스 처리 tag 저장 
			$('#tags').click(function() {
				alert('클릭');
				var links = $("#link").val();
				var board_idxs = $("#hidden_board_idx").val();
				
		
				$.ajax({
					type : 'GET',
					url : '/p/board/boardAjaxTag',
					dataType : 'text',
					data : {
						tag_url : links,
						board_idx :board_idxs,
						tag_position_y:tag_position__y,
						tag_position_x:tag_position__x
				
					},

					success : function(data) {
						alert(data);
						if(data=='1'){
							alert('성공1');
							$('.serchbox').css({
								"display" : 'none'
							})
							$('.check1').css({
								"top" : tag_position__y,
								"left" : tag_position__x
							}).show()
							$("#link").val('');
							
						}else if(data=='2'){
							alert('성공2');
							$('.serchbox').css({
								"display" : 'none'
							})
							$('.check2').css({
								"top" : tag_position__y,
								"left" : tag_position__x
							}).show()
							$("#link").val('');
						}else if(data=='3'){
							alert('성공3');
							$('.serchbox').css({
								"display" : 'none'
							})
							$('.check3').css({
								"top" : tag_position__y,
								"left" : tag_position__x
							}).show()
							$("#link").val('');
						}else if(data=='4'){
							alert('성공4');
							$('.serchbox').css({
								"display" : 'none'
							})
							$('.check4').css({
								"top" : tag_position__y,
								"left" : tag_position__x
							}).show()
							$("#link").val('');
						}else if(data=='5'){
							alert('성공5');
							$('.serchbox').css({
								"display" : 'none'
							})
							$('.check5').css({
								"top" : tag_position__y,
								"left" : tag_position__x
							}).show()
							$("#link").val('');
						}else if(data=='15'){
							alert('저장실패');
						}else if(data=='55'){
							alert('태그를 더이상 생성할수 없습니다 ')
							$('.serchbox').css({
								"display" : 'none'
							})
						}else{
							alert('치명적 오류 발생 광진이에게')
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
				//정보 표시 
			
			
		});
