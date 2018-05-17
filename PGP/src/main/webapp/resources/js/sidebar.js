$(document).ready(

		
function likeclick(s) {

	var likcnts = $('#likecnt'+s).text();
	var likecnt =parseInt(likcnts);
	   
	
	   var board_idx = $("#board_idx").val();
	   var member_id = $("#member_id").val();

		$ajax({
			type : 'GET',
			url : '/p/sidebar/like',
			dataType : 'text',
			data : {
				board_idx : board_idx,
				member_id : member_id
			},

			success : function(data) {
				
				if (data =='y') {
					alert('좋아요!');
					likecnt=likecnt+1;
					$('#likecnt'+s).text(likecnt);
				
					$('.heart'+s).attr('src','/p/resources/images/heart2.jpg');
				
				} else if(data =='n') {
					alert('좋취')
					if(likecnt>0){
						likecnt=likecnt-1;
						$('#likecnt'+s).text(likecnt);	
			
						$('.heart'+s).attr('src','/p/resources/images/heart1.png');
						
					}
					
				}else{
					alert('에러');
				}
				
			}

		});
		
});
	

	$("#layerPopup").hide();

	$("#scrap > a").click(function() {

		$("#scrap > a").blur();
		$("#layerPopup").show();
		$("#layerPopup a").focus();
		/*return false;*/
	});
	
	$("#layerPopup a").keydown(function(e) {
		if (e.shiftKey && e.keyCode == 9) { // Shift + Tab 키를 의미합니다.
			$("#scrap > a").focus();
			$("#layerPopup").hide();
			return false;
		}
	});

	$(function() {
		
		var $newScrapButton = $('#newScrapButton');
		var $newScrapForm = $('#newScrapForm');
		
		var $member_idx = $('#member_idx').val();
 		var $board_idx = $('#board_idx').val();
		var $scrap_name = $('#newText').val();
		
		var $textInput = $('#newScrapForm input:text').val();
		
		alert($textInput);
		
		$newScrapButton.show();
		$newScrapForm.hide();

		$('#showForm').on('click', function() {

			$newScrapButton.hide();
			$newScrapForm.show();

		});

		$('#close').on('click', function() {

			$("#layerPopup").hide();

		});

		$newScrapForm.on('submit', function(e) {
			e.preventDefault();
			var newText = $('input:text').val();
			alert($newText);
			
			$('li:last').after('<li>' + '<a href ="#">' + newText + '</li>');

			$newScrapForm.hide();
			$newScrapButton.show();
			var $textInput = $('input:text').val();
		});
	});
	
	
	 $("#reportPopup").hide();
	 $("#report > a").click(function(){
		  
		    $("#report > a").blur();
		    $("#reportPopup").show();
		    $("#reportPopup a").focus();
	 });
	 
	 $("#report_submit").click(function(){
		 
		 var board_idx = $("#board_idx").val();
		 var storyboard_idx = $("#storyboard_idx").val();
		 var member_idx = $("#member_idx").val();
		 var report_contents = $("#report_contents").val();
		 
		 alert(board_idx);
		 alert(storyboard_idx);
		 alert(member_idx);
		 alert(report_contents);

			 
			 alert('이얍');
	    
			$.ajax({
				type : 'POST',
				url : '/p/sidebar/sb_report',
				dataType : 'text',
				data : {
					
					board_idx : board_idx,
					storyboard_idx : storyboard_idx,
					member_idx : member_idx,
					report_contents : report_contents

				},
			
				success : function(data) {
				
			
				
				if(data=='y'){
					//실행
					
					alert('성공');
					
					 /* $("#report > a").focus();
				      $("#reportPopupform").submit();
				      $("#reportPopup").hide();*/
					
				}else{alert('실패');}
				} 
	  });
	  
	  });
	
	 
		
	  
	 



