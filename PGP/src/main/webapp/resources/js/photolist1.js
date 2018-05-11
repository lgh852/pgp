/*$(document).ready(function() {

	$('.like').click(function() {
		alert('클릭')
		var likeck = '';
		likeck = $('.likeck').val();
		 var ss = $(".a").eq(2).val();
         alert('value='+ss)
		if (likeck == '') {
			// 증가 문
			alert('if')
			
		} else {
			// 감소
		}

	});
});dsadasdasd
    */



//wddasdasdasds
	function liclick(s) {
		
		var likcnts = $('#likecnt'+s).text();
		var likecnt =parseInt(likcnts);
	
		 var bidx = $('.bidx'+s).val();
		
			 //값이 있으면 실행 안함 
			 //실행
		 $.ajax({
				type : 'GET',
				url : '/p/board/photolistlike',
				dataType : 'text',
				data:{
					board_idx:bidx,
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
		 
		 
		 
		 
	}       
  
