$(document).ready(function() {

   // <![CDATA[
   // 사용할 앱의 JavaScript 키를 설정해 주세요.
   Kakao.init('73c2b5a7ff3c7bc9d8bdf295799c3b72');
   // 카카오 로그인 버튼을 생성합니다.
   Kakao.Auth.createLoginButton({
      container : '#kakao-login-btn',
      size : 'large',
      success : function(authObj) {
         // 로그인 성공시, API를 호출합니다.
         Kakao.API.request({
            url : '/v2/user/me',
            success : function(res) {
               var jsonval = JSON.parse(JSON.stringify(res));

          
               var date = new Date();
                var year = date.getFullYear();
                var month = date.getMonth()+1
                var day = date.getDate();
                if(month < 10){
                    month = "0"+month;
                }
                if(day < 10){
                    day = "0"+day;
                }
             
                var todays = year+"-"+month+"-"+day;
                alert(todays);
                var today = String(todays);
               
               $.ajax({
                  type : "POST",
                  data : {
                     member_id : jsonval.kakao_account.email,
                     member_pw : 'kakao',
                     member_name : jsonval.properties.nickname,
                     member_photo : jsonval.properties.thumbnail_image,
                     member_birth : today,
                     member_gender : 'kakao'
                  },
                  url : "kakaologin",
                  success : function(date) {
                 
                     if(date=='y'){
                        window.location = "/p/";
                     }else if(date=='n'){
                  
                        window.location = "/p/";
                     }
                     
                  
                      
                     }
               });
            },
            fail : function(error) {
               alert(JSON.stringify(error));
            }
         });

      },
      fail : function(err) {
         alert(JSON.stringify(err));
      }
      
      
  
      
      

   });
        	
        	
   var naverLogin = new naver.LoginWithNaverId(
           {
              clientId: "4zEiZaP09 VSRXmZR87vq",
            callbackUrl: "http://localhost:8080/p/member/naver",   
            isPopup : true, /* 팝업을 통한 연동처리 여부 */
            loginButton : {color: "green", type: 3, height: 50}
           /* 로그인 버튼의 타입을 지정  */
           }
           
           );
           
     /* 설정정보를 초기화하고 연동을 준비  */
     naverLogin.init(
          
    		 
     );
        	 $('#naverIdLogin_loginButton img').attr('width','300px')     		
        	
        	      
        	      
        	      //fackbook
        	     
	
	
	
	
});