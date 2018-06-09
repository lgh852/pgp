 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="margin: 0 auto;width: 100%">
            <div class="imgcenter">    
           <div id="imgbox" class="border" style="max-width: 100%;width: 700px;margin: 0 auto;">    
         <img width="100%" height="100%" id="imgPre" src="%EC%A7%91.jpg" alt="" style=" max-height: 600px;min-height: 600px;margin: 0 auto;"  class="border-0 img-thumbnail">
            </div>
        </div>
        <div style="max-width: 100%;width: 700px;margin: 0 auto">
        <form action="<%=request.getContextPath()%>/board/boardFrom"
   method="post" enctype="multipart/form-data">
        <div class="container">
  <div class="row " style="margin-top: 10px" >
    <div class="col">
        
        <select class="custom-select" id="inputGroupSelect02"
            name="category_room">
            <option selected value="0">모든 공간</option>
            <option value="1">원룸</option>
            <option value="2">거실</option>
            <option value="3">침실</option>
            <option value="4">키친</option>
            <option value="5">욕실</option>
            <option value="6">아이방</option>
            <option value="7">드레스룸</option>
            <option value="8">서재&작업실</option>
            <option value="9">침실</option>
            <option value="4">베란다</option>
            <option value="5">사무공간</option>
            <option value="6">상업공간</option>
            <option value="7">가구&소품</option>
            <option value="8">현관</option>
            <option value="9">외관&기타</option>
            <option value="10">복도</option>
            <option value="11">제품후기</option>
         </select>
          </div>
    <div class="col">
      <select class="custom-select" id="inputGroupSelect02"
            name="category_space">
            <option selected value="0">모든 평수</option>
            <option value="1">10평 미만</option>
            <option value="2">10평대</option>
            <option value="3">20평대</option>
            <option value="1">30평대</option>
            <option value="2">40평대 이상</option>
         </select>
      </div>
   
            </div>
            </div>
        <div class="custom-file" style="margin-top: 10px">
         <input type="file" class="custom-file-input fileboxsize"
            id="inputGroupFile02" name="FileName"> <label
            class="custom-file-label" for="inputGroupFile02">photo</label>
      </div>
        
        
        
        <div class="input-group mb-3" style="margin-top: 10px">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">제목</span>
  </div>
  <input type="text"  name="board_title" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
</div>
            <div >
          <textarea   id="summernote" name="board_contents"></textarea>
      </div>
    
         <div class="container">
  <div class="row" style="margin-top: 10px">
    <div class="col">
    
    </div>
    <div class="col-6">
     <input type="submit" class="btn btn-outline-primary" style="width: 48%" value="입력" />
        <input type="reset" class="btn btn-outline-secondary" style="width: 48%" value="취소" />

    </div>
    <div class="col">
   
    </div>
  </div>
  
</div>
            
        </form>
        </div>
        
        
        
            
      </div>  <!--margin auto-->      
      
      <script>
      	$(document).ready(function(){
      		$('.note-editor').css('width','100%')
      	})
      
      </script>