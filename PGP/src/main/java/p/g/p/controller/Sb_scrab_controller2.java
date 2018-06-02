package p.g.p.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Member_info;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.Sb_scrap_service;

@Controller
public class Sb_scrab_controller2 {
   
   @Autowired 
   Sb_scrap_service service;
   
   @RequestMapping("/sidebar/scrapInsert")
   @ResponseBody
   public String sbScrapInsert(Scrap scrap,HttpSession session,Board board,scrapFN scrapfn) {
      
      Member_info member = (Member_info) session.getAttribute("user");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      System.out.println("asdasdasd");
      
      scrap.setMember_idx(scrap.getMember_idx());
      String ck = "q";
      	System.out.println("1");
      if(member != null) {
         System.out.println("2");
         int member_idx = member.getMember_idx();
         scrap.setMember_idx(member_idx);
         	
         Scrap scrapck = service.scrapck(scrap);
         System.out.println("3");
         if(scrapck==null) {
        	 System.out.println("4");
            System.out.println("scrapfn확인해보쟈"+scrapfn);
            int idx = service.getFnIdx(scrapfn);
            scrap.setScrapFN_idx(idx);
            System.out.println("scrap확인해보쟈"+scrap);
            
            int result = service.insertScrap(scrap);
            	System.out.println("5");
            if(result>0) {
               int c = service.scrapCountUp(board);
               System.out.println("6");
               System.out.println(c);
               if(c>0) {
                  ck="y";
                  
               }else {
                  ck="s";
               }
            }else {
               ck="s";
               System.out.println("첨부터 꺼져");
            }
         }else {//scrapck에 값이 있음
            
            int r = service.DeleteScrap(scrap);
            System.out.println(r);
            System.out.println("2-1");
            if(r>0) {
               int a = service.scrapCountDown(board);
               System.out.println("dwon 성곻ㅇ");
               System.out.println(a);
               if(a>0) {
                  ck="n";
                  //스크 수 감소 성공
               }else {
                  //스크랩 수 감소 실패
                  ck="s";
               }
            }else {
               ck="S";
            }
            
         }
         
      }else {
    	  System.out.println("밍밍");
    	  ck = "s";
      }
      
   
      return ck;
   }
   
   @RequestMapping("/sidebar/scrapCheck")
   @ResponseBody
   public String sbScrapCheck(Scrap scrap,HttpSession session,Board board) {
      Member_info member = (Member_info) session.getAttribute("user");
    

    
      String ch = "q";
      
      
      if(member!=null) {
         
         int member_idx = member.getMember_idx();
         
         scrap.setMember_idx(member_idx);
         
         Scrap scrapck = service.scrapck(scrap);
         System.out.println(scrapck);
         
      
      if(scrapck==null) {
    	  
         return ch="y";
         
         
      }else {
         int r = service.DeleteScrap(scrap);
         if(r>0) {
            int a = service.scrapCountDown(board);
            if(a>0) {
               ch="n";
               //스크 수 감소 성공
            }else {
               //스크랩 수 감소 실패
               ch="s";
            }
         }else {
            ch="s";
         }
         
      }
         
      }
      System.out.println(ch);
      
      return ch;
   }
   


}