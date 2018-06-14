<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content>
    <meta name="author" content>
    
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>아이디 찾기</title>
 <style>
        .fontcolor {
            color: /*#878787 */ #f8f9fa;
        }
    
    </style>
    
    <style>
    .botton_common{
        display: inline-block;
        width: 24%;
        height: 100%;
        margin-left: 3px;
        margin-top: 3px;
    }
    
        .botton_center{
            text-align: center;
        }
        
        .botton_center p {
            font-size: 18;
            font-weight: 600;
            margin-top: 6px;
            margin-bottom: 3px;
            color: black;
        }
        
        .botton_center span{
            font-size: 14;
            font-weight: 200;
            color: gray;
        }
        
        .botton_center a {
            text-decoration: none;
            
        }
        
        .#latelybox{
            display: none;
        }
        
        .text-muted {
            color : white !important;
        }
        
        #homeName{
            font-family: 'Gamja flower', cursive;
            text-decoration: none;
        }
        div>nav>a{
            /*font-size: 25px;*/
        }
        
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

<script>

$(document).ready(function(){

   
   $('#userName').focusout(function() {
      var name = $('#userName').val();

      if (name.trim().length < 2) {
         $('#userNameck').text('필수정보입니다');
         $('#userNameck').css('color', 'red');
      } else {
         $('#userNameck').text('이름');
      }

   });
   
   $('#userBirth').focusout(function() {
      var birth = $('#userBirth').val();

      if (birth.trim().length < 8) {
         $('#birthck').text('필수정보입니다');
         $('#birthck').css('color', 'red');
      } else {
         $('#birthck').text('생년월일');
      }

   });
   
   $('#phone2').focusout(function() {
      var phone2 = $('#phone2').val();
      if (phone2.trim().length <= 3) {
         $('#phoneck').text('핸드폰 번호를 확인해주세요');
         $('#phoneck').css('color', 'red');
      } else {
         var phone2 = $('#phone2').val();
         var phone3 = $('#phone3').val();
         if(phone2.trim().length<3&&phone3.trim().length<3){
            $('#phoneck').text('핸드폰 번호룰 확인해주세요');      
         }else{
      
                  
         }
      }
   });
   $('#phone3').focusout(function() {
      var phone3 = $('#phone3').val();
      if (phone3.trim().length <= 3) {
         $('#phoneck').text('핸드폰 번호를 확인해주세요');
         $('#phoneck').css('color', 'red');
      } else {
         $('#phoneck').text('');
      }
   });
   
   var date = new Date();

   var year = date.getFullYear();

   for (var i = year - 100; i <= year; i++) {

      $('#year').append('<option value='+i+'>' + i + '년' + '</option>');
   }
   ;

   for (var i = 1; i <= 12; i++) {

      $('#month').append('<option value='+i+'>' + i + '월' + '</option>');
   }
   ;

   for (var i = 1; i <= 31; i++) {

      $('#day').append('<option value='+i+'>' + i + '일' + '</option>');
   }
   ;
   
});

</script>

</head>
<body style="padding-top: 0px">

  <main role="main" class="container">
    <div class="row" style="margin-top: 30px">
        <div class="py-5 textcenter" style="margin: auto">
        
        </div>
        <div class="featurette-divider" style="width: 100%">
        <div class="col-md-8 order-md-1" style="margin: auto"></div>
        </div>
        
        </div>
    
<div class="py-5 text-center" style="margin: auto">
   <img class="d-block mx-auto mb-4"
      src="<%=request.getContextPath()%>/resources/images/home.png" alt=""
      width="72" height="72">
   <h2>Find Id</h2>
   <p class="lead">고객님의 아이디를 찾기 위한 정보를 입력해주시기 바랍니다.</p>
</div>
<hr class="featurette-divider" style="width: 100%">
<div class="col-md-8 order-md-1" style="margin: auto;">
   <h4 class="mb-3">아이디 찾기</h4>
   <hr class="featurette-divider" style="width: 100%">
   <form class="needs-validation" novalidate=""
      action="<%=request.getContextPath()%>/member/memberform" method="post"
      id="userId"></form>
</div>

<div class="text-center">
<div class="mb-3">
      <label for="userName">이름 <span id="userNameck"></span></label> <span
         class="text-nuted"></span> <input type="text" class="form-control"
         name="member_name" id="userName" placeholder="" value="" required="">
   </div>
</div>
<label>생년월일</label>
<span id="birthck"></span>
<div class="row">
   <div class="col-4">
      <select class="custom-select" id="year" name="year">
         <option value="0">선택하세요</option>
      </select>
   </div>
   <div class="col-4">
      <select class="custom-select" id="month" name="month">

         <option value="0">선택하세요</option>
      </select>
   </div>
   <div class="col-4">
      <select class="custom-select" id="day" name="day">
         <option value="0">선택하세요</option>

      </select>
   </div>
</div>
<div class="mb-3"></div>
<label>전화번호</label>
<span id="phoneck"></span>
<div class="row">
   <div class="col-4">
      <select class="custom-select" id="phone1" name="phone1">
         <option value="010">010</option>
         <option value="011">011</option>
         <option value="018">018</option>
      </select>
   </div>
   <div class="col-4">
      <input type="text" aria-label="Default"
         aria-describedby="inputGroup-sizing-default" name="phone2"
         id="phone2" placeholder="0000" style="height: 38px;"
         class="form-control">
   </div>
   <div class="col-4">
      <input type="text" aria-label="Default"
         aria-describedby="inputGroup-sizing-default" name="phone3"
         id="phone3" placeholder="0000" style="height: 38px;"
         class="form-control">
   </div>
</div>
  
    
    <button class="btn btn-primary btn-lg btn-block" type="submit">찾기</button>
      <hr class="mb-4">
</main>
   <div style="text-align: center;">© Playground 느그집</div>
   <div style="height: 30px;"></div>

    
</body>
</html>