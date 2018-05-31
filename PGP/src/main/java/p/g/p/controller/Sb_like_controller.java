package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.service.Sb_like_service;

@Controller 
public class Sb_like_controller {
   
   @Autowired
   Sb_like_service service;

   
   @RequestMapping("/sidebar/like")
   @ResponseBody
   public String sbLike(Like like,Board board,HttpSession session){
      
      Member_info member = (Member_info) session.getAttribute("user");
      like.setMember_idx(like.getMember_idx());
      
       String ck="q";
      
       Like likeck = service.likeck(like);
       
       if(member != null) {
      
       if(likeck ==null) {
          
          
          int result = service.Likeup(like);
       
          if(result>0) {
             
             int resultCnt = service.updateLikecntUp(board);
             
             if(resultCnt >0) {
                
                ck="y";
                
             }else {
             
                ck="s";
             }
             }else {
                
                ck="s";
             }
       }else {
          //값이 있으면 삭제후 -1 감소 실행
          
          
          int resultcnt=service.deletelike(like);
          
          if(resultcnt>0) {
             
             int result= service.updateLikecntDown(board);
             
             ck="n";
             
             if(result>0) {
                
             }else {
                
                ck="s";
             }
          }else {
             
             ck="s";
          }
       }
   
       }else {
          ck="s";
       }
      
     return ck;
      
   }
}