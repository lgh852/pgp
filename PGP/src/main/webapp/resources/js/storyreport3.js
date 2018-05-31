
$(document).ready(
		   function() {
				$(".reportPopuppage").hide();
		
	
	 });

	 function reportClick(e) {

			$("#report > a").blur();
			$("#reportPopuppage"+e).show();
			$("#reportPopuppage a").focus();

			$("#closePopuppage"+e).click(function() {

				$("#reportPopuppage"+e).hide();

			});
			
			$("#submitReportpage"+e).click(function() {

				var storyboard_idx = $("#storyboard_idx"+e).val();
				var member_idx = $("#member_idx"+e).val();
				var report_contents = $("#report_contents"+e).val();

				alert(storyboard_idx);
				alert(member_idx);
				alert("ㅎhss!!!saㅎ"+report_contents);


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

						alert('들어오냐?0?');

						if (data == 'y') {
							// 실행

							alert('성공');

						
						} else {
							alert('실패');
						}

					}
				});
			});
			
			
			
			
			
			
			

		}


