function likestoryClick(e) {

	
	var seck = $('#seck').val();

	if(seck !=''){
	
	var likecnts = $('.likecnt' + e).val();
	var likecnt = parseInt(likecnts);

	var likeTEXT = $('.likeTEXT' + e).text();
	var storyboard_idx = $(".storyboard_idx" + e).val();
	var member_idx = $(".member_idx" + e).val();

	$.ajax({
		type : 'GET',
		url : '/p/story/storyboardLike',
		dataType : 'text',
		data : {
			storyboard_idx : storyboard_idx,
			member_idx : member_idx
		},

		success : function(data) {

			if (data == 'y') {

				likecnt = likecnt + 1;
				$('.cntss' + e).text(likecnt);
				$('.likecnt' + e).val(likecnt);
				$('.likeTEXT' + e).text("명이 좋아합니다♥");
				$('.storylike_heart' + e).attr('src',
						'/p/resources/images/heart2.png');
			} else if (data == 'n') {

				if (likecnt >= 0) {
					likecnt = likecnt - 1;
					if (likecnt == 0) {
						$('.cntss' + e).text('');
					}
					$('.likecnt' + e).val(likecnt);

				}
				if (likecnt == 0) {
					$('.likeTEXT' + e).text("제일 먼저 좋아요를 눌러보세요~");

				} else {
					$('.cntss' + e).text(likecnt);
					$('.likeTEXT' + e).text("명이 좋아합니다♥");

				}

				$('.storylike_heart' + e).attr('src',
						'/p/resources/images/heart.png');
			} else {
				alert('에러');
			}

		}

	});
	}else{
		alert('로그인후 이용해주세요')
	}
}