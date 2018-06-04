<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>

.s{

position:absolute;
top:200px;
letf:500px;

}

#scrapNameDetail{

position:absolute;
top:200px;
left:530px;


}

#pop{
  padding:30px; 
  border:4px solid #ddd; 
  position:absolute; 
  left:100px; 
  top:100px; 
  background:#fff;
}

#pop button{
  cursor:pointer;
}
</style>


<div class="s"> <h1>${scrap.scrap_name}</h1> </div>

<div id="scrapNameDetail">

<a href="#pop" 
class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">설정</a>
<div id="pop">
<h1>스크랩북 정보 수정</h1><a href="<%=request.getContextPath()%>/sidebar/scrapdelete?scrap_name=${scrap.scrap_name}&member_idx=${user.member_idx}">삭제</a><br> 
    <input type="text" id="name" placeholder=${scrap_name}>
    <button type="button" id="update">수정</button>
    <button type="button" id="close">닫기</button>
    
    <input type="hidden" id="idx" value="${scrap.scrapFN_idx}"/>
</div>
</div>

