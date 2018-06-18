
$(document).ready(
		   function() {
				$(".reportPopupView").hide();
						
	 });

	 function reportClickBtn(e) {

			
			 if(typeof $('#seck').val()==""){
				 alert('로그인후 이용해주세요');
				 
				 window.location = "/p/member/loginform";
			
			}else{
				 
			$("#report > a").blur();
			
			$("#reportPopupView"+e).show();
			
			$("#reportPopupView a").focus();

			$("#closePopuppage"+e).click(function() {
				$("#reportPopupView"+e).hide();
			});
			
			$("#submitReportpage"+e).click(function() {
				var storyboard_idx = $("#storyboard_idx"+e).val();
				var member_idx = $("#member_idx"+e).val();
				var report_contents = $("#report_contents"+e).val();
				$.ajax({
					type : 'GET',
					url : '/p/story/storyboardReport',
					dataType : 'text',
					data : {

						storyboard_idx : storyboard_idx,
						member_idx : member_idx,
						report_contents : report_contents
					},

					success : function(data) {
						if (data == 'y') {
							// 실행
						
							$("#reportBtn"+e).hide();
							$('.fade').hide();
						} else {
							alert('실패');
						}

					}
				});
			});
			 }
		}

	 ///////////////////////////////////////////////////사이드바에서 신고
	 
	 function reportClickBtn() {

					
		 if(typeof $('#seck').val()==""){
			 alert('로그인후 이용해주세요');
			 
			 window.location = "/p/member/loginform";
		
		}else{
			 
		$("#report > a").blur();
		
		$("#reportPopupView").show();
		
		$("#reportPopupView a").focus();

		$("#closePopuppage").click(function() {
			$("#reportPopupView").hide();
		});
		
		$("#submitReportpage").click(function() {

			var member_idx = $("#member_idx").val();
			var report_contents = $("#report_contents").val();
            var board_idx = $("#board_idx").val();
            
            
			$.ajax({
				type : 'GET',
				url : '/p/sidebar/sb_report',
				dataType : 'text',
				data : {

					board_idx : board_idx,
					member_idx : member_idx,
					report_contents : report_contents
				},

				success : function(data) {
					
					
					
					if (data == 'y') {
						// 실행
						alert('성공');
						
						$("#reportBtn").hide();
						$('.fade').hide();
					} else {
						alert('실패');
					}

				}
			});
		});
		 }
	}


