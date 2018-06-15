$(document)
      .ready(

            function() {

              var listnum;

               /*스크랩 폴더 추가*/

               $("#scrapPopup").hide();
               
               $(".add")
                     .click(
                           function() {
                        
                              var scrapFolderName = $(
                                    ".scrapFolderName").val();
                            
                              var c = $(".listnumber").val();
                              
                              var member_idx = $("#member_idx").val();
                           
                              
                              var scrapbookcheck;
                              
                              
                              var scrapbookcheck = $("#scrap_book").text();
                              
                          
                             
                              

                              $.ajax({

                                       type : 'GET',
                                       url : '/p/sidebar/scrap',
                                       dataType : 'text',
                                       data : {

                                          scrap_name : scrapFolderName,
                                          member_idx : member_idx

                                       },
                                       success : function(data) {

                                         
                                          if (data == 'y') {
                               

                                             c = ++c;

                                           

                                             $('.scrapList')
                                             .append(
                                                   '<li><span><button type="button" class="list-group-item list-group-item-action active" onclick="scrapButton("'+c+'")">'

                                                         + scrapFolderName
                                                         + "</button></span></li>");

                                       $(
                                             '.scrapSuccess'
                                                   + c)
                                             .text(
                                                   scrapFolderName);

                                          } else {
                                             alert('실패ㅠㅠㅠㅠㅠㅠㅠ');
                                          }
                                          
                                        
                                        	  
                                        	 
                                        	 $('.scrapemtyimage').append('<img class="card-img-top" alt="스크랩 폴더가 비어있어요!" id="scrapemtyimage("'+c+'")" style="height: 225px; width: 100%; display: block;" src="/p/resources/images/empty-glass.png">' )
                                        	 $('.scarpfoldernameadd').append('<a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name='+scrapFolderName+'">'+'<span class="name" style="color:black">'+scrapFolderName+'</span></a>')
                                        	 
                                        
                                        	
                                        	 
                                        
                                          $("#scrapPopup").hide();
                                       }
                                    });

                           });

               $('#close').on('click', function() {
                  $("#scrapPopup").hide();

               });

               /* 신고기능 */

               $("#reportPopup").hide();

               /*
                * function reportPopup() {
                * 
                * $("#report > a").blur(); $("#reportPopup").show();
                * $("#reportPopup a").focus();
                * 
                * $("#closeeeee").click(function(){
                * 
                * $("#reportPopup").hide();
                * 
                * });
                * 
                * });
                */

               $("#report_submit").click(function() {

                  var board_idx = $("#board_idx").val();
                  /* var storyboard_idx = $("#storyboard_idx").val(); */
                  var member_idx = $("#member_idx").val();
                  var report_contents = $("#report_contents").val();

                
             


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

                           /*
                            * $("#report > a").focus();
                            * $("#reportPopupform").submit();
                            * $("#reportPopup").hide();
                            */

                        } else {
                           alert('실패');
                        }

                     }
                  });
               });

            });

function scrapButton(s) {
	
	
   
	var board_idx = $("#board_idx").val();

   var member_idx = $("#member_idx").val();

   var scrap_name_choice = $(".scrapSuccess"+s).text();
 
   
   var scrapcnts = $('#scrapCnt').text();
   var scrapcnt = parseInt(scrapcnts);
  
  
   if($('#scrapCnts'+listnum).text() !='undefined'){
   
   var scrapcntString = $('#scrapCnts'+listnum).text();

   var scrapcnts = $('#scrapCnt').text();
   
   
   if(scrapcnts==null||scrapcnts==''){

	   	
	   	scrapcnts = $('#scrapCnt').val();
	   }
  
   var scrapcntss = parseInt(scrapcntString);
   var scrapcnt = parseInt(scrapcnts);
   
   
   }
   
  alert('if문 지났냐');
   

   

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
            
            
            if(scrapcntss !=''){
            
            	scrapcntss =scrapcntss +1;
            $('.count').text(scrapcnt);
            
            var ss = $('#ck').val()
            $('#scrapCnts'+listnum).text(scrapcntss);
            $('.scrapckss'+listnum).attr('src','/p/resources/images/scrap2.png')
            
            }
            
       
            $('#scrapid').removeClass('btn btn-outline-info').addClass(
                  'btn btn-info');
            $('#scrapCnts'+s).text(scrapcnt);
            alert('스크랩 버튼 바뀜');
            
            
            $("#scrapPopup").hide();
            

         } else if (data == 'n') {

   
            scrapcnt = scrapcnt - 1;
            $('.count').text(scrapcnt);
            $('.count').text(scrapcnt);

         } else {

            alert('스크랩 그냥 실패 ㅠㅠ');

         }

      }

   });

}

function reportPopup() {

   $("#report > a").blur();
   $("#reportPopup").show();
   $("#reportPopup a").focus();

   $("#closeeeee").click(function() {

      $("#reportPopup").hide();

   });

}

function scrapPopup() {

   var board_idx = $("#board_idx").val();
   var member_idx = $("#member_idx").val();
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
        	
        	 //안했으면 show
        	 
            $("#scrap > a").blur();
            $("#scrapPopup").show();
            $("#scrapPopup a").focus();

         } else if (data == 'n') {

            scrapcnt = scrapcnt - 1;

            $('.count').text(scrapcnt);
            $('#scrapid').removeClass('btn btn-info').addClass(
                  'btn btn-outline-info');
            $('#scrapCnts'+s).text(scrapcnt);
    

         } else {

            alert('스크랩 그냥 실패 ㅠㅠ');

         }

      }
   });
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

	   var board_idx = $("#board_idx"+e).val();
	   var member_idx = $("#member_idx"+e).val();
	   var scrapcnts = $('#scrapCnts'+e).text();

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
	       
	        	 //안했으면 show
	            $("#exampleModal").modal('show')  
	            $('#board_idx').val(board_idx);
	            $('#scrapCnt').val(scrapcnts);
	            listnum = e;
	         } else if (data == 'n') {

	       
	            scrapcnt = scrapcnt - 1;
	            
	         
	            
	            $('#scrapCnt'+e).text(scrapcnt);
	            $('#board_idx').val(board_idx);
	            $('#scrapCnt').val(scrapcnts);
	            $('#ck').val(e);
	            $('#scrapCnts'+e).text(scrapcnt);
	            $('.scrapckss'+e).attr('src','/p/resources/images/scrap.png')
	            
	            
	            //몇번찌인지 저장
	            
	            //처리해야댐
	            $('#scrapid').removeClass('btn btn-info').addClass(
	                  'btn btn-outline-info');


	         } else {

	            alert('로그인후 이용해주세요');

	         }

	      }
	   });
	}
