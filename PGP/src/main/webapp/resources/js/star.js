$(document).ready(function() {
   $("#pop").hide();
   
   $("#scrapNameDetail > a").click(function() {
      
      $("#scrapNameDetail > a").blur();
      $("#pop").show();
      $("#pop a").focus();
      
      
      
   $("#update").click(function(){
         
         
         
         var updateFolderName = $("#name").val();
         var scrapFN_idx = $("#idx").val();
      
         $.ajax({
            

            type : 'GET',
            url : '/p/sidebar/updateScrap',
            dataType : 'text',
            data:{
               
               scrap_name:updateFolderName,
               scrapFN_idx:scrapFN_idx
            },
            success : function(data){
               
               
               
               if(data=="y"){
                  
                  $('.s').text(updateFolderName);
                  
                  $("#fade").hide();
               
               }else{
                
               }
               
            }   
         });
      });
   
      $("#close").click(function(){
         
   
         $("#pop").hide();
         
         
      });
   
   
   });
   
   $("#pop a").keydown(function(e) {
      if (e.shiftKey && e.keyCode == 9) { // Shift + Tab 키를 의미합니다.
         $("#scrapNameDetail > a").focus();
         $("#pop").hide();
         return false;
      }
   });

 
   
});