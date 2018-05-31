$(document).ready(function() {


                	
                    $('#shotshow').click(function() {
                        if($("#choicemenu").attr('style') =='display: none;'){
                        $("#choicemenu").attr('style','display:inline;') //region 영역 보이기
                       
                        $("#choicemenuspace").attr('style','display: none;') //region 영역 보이기
                        $("#choicemenuroom").attr('style','display: none;') //region 영역 보이기
                        
                          
                        }else{
                       
                        	   $("#choicemenu").hide(); //more...숨기기    
                               $("#choicemenuspace").hide(); //more...숨기기
                               $("#choicemenuroom").hide(); //more...숨기기 
                        }      
                     
                    });

                    $('#roomshow').click(function() {
                       if($("#choicemenuroom").attr('style') =='display: none;'){
                        $("#choicemenuroom").attr('style','display:inline;') //region 영역 보이기
          
                        $("#choicemenu").attr('style','display: none;') //region 영역 보이기
                        $("#choicemenuspace").attr('style','display: none;') //region 영역 보이기
                 
                        }else{
                       
                        $("#choicemenu").hide(); //more...숨기기    
                        $("#choicemenuspace").hide(); //more...숨기기
                        $("#choicemenuroom").hide(); //more...숨기기 
                        }     
                    });

                   
                    
                    
                    $('#spaceshow').click(function() {
                       if($("#choicemenuspace").attr('style') =='display: none;'){
                        $("#choicemenuspace").attr('style','display:inline;') //region 영역 보이기.
                           
                           $("#choicemenu").attr('style','display: none;') //region 영역 보이기
                        $("#choicemenuroom").attr('style','display: none;') //region 영역 보이기
                  
                        }else{
                       
                        $("#choicemenu").hide(); //more...숨기기    
                        $("#choicemenuspace").hide(); //more...숨기기
                        $("#choicemenuroom").hide(); //more...숨기기 
                        }     
                    });

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
});



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
  
