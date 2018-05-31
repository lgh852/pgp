$(document)
      .ready(

            function() {

               $('.heart1')
                     .click(
                           function() {

                              var likcnts = $('#likecnt').text();
                              var likecnt = parseInt(likcnts);

                              var board_idx = $("#board_idx").val();
                              var member_idx = $("#member_idx").val();

                              alert(board_idx);
                              alert(member_idx);
                              alert(likecnt);

                              $
                                    .ajax({
                                       type : 'GET',
                                       url : '/p/sidebar/like',
                                       dataType : 'text',
                                       data : {
                                          board_idx : board_idx,
                                          member_idx : member_idx,
                                          board_like : likecnt
                                       },

                                       success : function(data) {

                                          alert('되냐?');

                                          if (data == 'y') {
                                             alert('좋아요!');

                                             likecnt = likecnt + 1;
                                             $('#likecnt').text(
                                                   likecnt);

                                             $('.heart1')
                                                   .attr(
                                                         'src',
                                                         '/p/resources/images/heart2.jpg');

                                          } else if (data == 'n') {

                                             alert('좋취');

                                             if (likecnt > 0) {

                                                likecnt = likecnt - 1;

                                                $('#likecnt')
                                                      .text(
                                                            likecnt);

                                                alert('dd');

                                                $('.heart1')
                                                      .attr(
                                                            'src',
                                                            '/p/resources/images/heart1.png');

                                             }

                                          } else {
                                             alert('에러');
                                          }

                                       }

                                    });

                           });

               /* 스크랩기능 */

               $("#scrapPopup").hide();
               /*
                * $("#scrap > a").click(function() {
                * 
                * $("#scrap > a").blur(); $("#scrapPopup").show();
                * $("#scrapPopup a").focus(); return false; });
                */

               $("#add")
                     .click(
                           function() {

                              var scrapFolderName = $(
                                    "#scrapFolderName").val();
                              
                              var c = $("#listnumber").val();
                              
                              var member_idx = $("#member_idx").val();
                              alert(member_idx);

                              $.ajax({

                                       type : 'GET',
                                       url : '/p/sidebar/scrap',
                                       dataType : 'text',
                                       data : {

                                          scrap_name : scrapFolderName,
                                          member_idx : member_idx

                                       },
                                       success : function(data) {

                                          alert('들어오나?');
                                          if (data == 'y') {
                                             member_idx
                                             alert('스브랩북 추가는 성공ㅎㅎㅎㅎ');

                                             c = ++c;

                                             alert(c);

                                             $('.scrapList')
                                                   .append(
                                                         "<li><span><button type='button' class='list-group-item list-group-item-action active' onclick='scrapButton(c)'>"

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

                  alert(board_idx);
                  /* alert(storyboard_idx); */
                  alert(member_idx);
                  alert(report_contents);

                  alert('이얍');

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

                        alert('들어오냐?0?');

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
	alert('dasdasd');
   var board_idx = $("#board_idx").val();

   var member_idx = $("#member_idx").val();

   var scrap_name_choice = $(".scrapSuccess"+s).text();
   alert(scrap_name_choice);
   alert()
   var scrapcnts = $('#scrapCnt').text();
   var scrapcnt = parseInt(scrapcnts);

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

         alert('스크랩 폴더 버튼이 눌림');

         if (data == 'y') {

            alert('스크랩성공!!!');
            scrapcnt = scrapcnt + 1;
            $('.count').text(scrapcnt);
            alert('카운트업');
            $('#scrapid').removeClass('btn btn-outline-info').addClass(
                  'btn btn-info');
            alert('스크랩 버튼 바뀜');
            $("#scrapPopup").hide();

         } else if (data == 'n') {

            alert('스크랩해제한다!');
            scrapcnt = scrapcnt - 1;

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

   alert('스크랩 팝업!!!!!!');

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

         alert('함수 들어오냐');

         if (data == 'y') {

            $("#scrap > a").blur();
            $("#scrapPopup").show();
            $("#scrapPopup a").focus();

         } else if (data == 'n') {

            alert('스크랩해제><');
            scrapcnt = scrapcnt - 1;

            $('.count').text(scrapcnt);
            $('#scrapid').removeClass('btn btn-info').addClass(
                  'btn btn-outline-info');

            alert('스크랩 버튼 바뀜');

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

   alert(board_idx);
   alert(member_idx);
   alert(likecnt);

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

         alert('좋아요 함수 들어오냐?');

         if (data == 'y') {

            alert('좋아요!');

            likecnt = likecnt + 1;

            $('.countcount').text(likecnt);

            alert('좋아요수 카운트 업업!!!');

            $('#likeid').removeClass('btn btn-outline-danger').addClass(
                  'btn btn-danger');

         } else if (data == 'n') {

            alert('좋취');

            if (likecnt > 0) {

               likecnt = likecnt - 1;

               $('.countcount').text(likecnt);

               alert('좋아요수 카운트 다운다운!');

               $('#likeid').removeClass('btn btn-danger').addClass(
                     'btn btn-outline-danger');
            }

         } else {
            alert('에러');
         }

      }

   });

}