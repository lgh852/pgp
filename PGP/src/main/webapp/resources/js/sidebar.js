$(document).ready(

function() {

	$('#btnLike').click(

	function() {

		var board_idx = $("#board_idx").val();
		var member_id = $("#member_id").val();

		$ajax({
			type : 'GET',
			url : '/like',
			dataType : 'text',
			data : {
				board_idx : board_idx,
				member_id : member_id
			},

			success : function(data) {

				var like_img = '';

				if (result.status == 404) {
					like_img = "./resources/images/like.png";
				} else {
					like_img = "./resources/images/dislike.png";
				}

				/*
				 * if(result.status == 404){
				 * $('img#like_iimg').attr('src','./img/empty_heart.png');
				 * }else{ $('img#like_img').attr(;)
				 */
			}

		});
	});

	$("#layerPopup").hide();

	$("#scrap > a").click(function() {

		$("#scrap > a").blur();
		$("#layerPopup").show();
		$("#layerPopup a").focus();
		return false;
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
		var $textInput = $('input:text');

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
			$('li:last').after('<li>' + '<a href ="#">' + newText + '</li>');

			$newScrapForm.hide();
			$newScrapButton.show();
			$textInput.val('');
		});
	});

});
