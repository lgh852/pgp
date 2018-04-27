<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <div>
   
   
   <h1>아이디 ${member.member_id}</h1>
   
   
   
   <ul>
   <li><a href="<%=request.getContextPath()%>/mypage/mp_update?member_id=${member.member_id}">설정</a></li>
   <li><a href="<%=request.getContextPath()%>/mypage/mp_scrap?member_id=${member.member_id}">스크랩</a></li>
   <li><a href="<%=request.getContextPath()%>/mypage/mp_myphoto?member_id=${member.member_id}">나의사진</a></li>
   </ul>
   
   
   </div>

   
    <a href="<%=request.getContextPath()%>/sidebar/share">공유</a>
