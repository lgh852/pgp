package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board;
import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.Scrap;
import p.g.p.model.report;
import p.g.p.model.scrapFN;
import p.g.p.service.SidebarSerivce;

@Controller
public class SidebarController {
	
	  @Autowired
	   SidebarSerivce service;

	//////////////////////////////////////////////////////좋아요
	  

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
	   
	   ///////////////////////////////////////////////////신고
	   
	    @RequestMapping(value="/sidebar/sb_report",method=RequestMethod.POST)
		@ResponseBody
		public String sidebarReport(report report) {
			
					
			String ck ="";
			
			int resultCnt = service.reportSubmit(report);
			
			if(resultCnt>0) {
				//성공
			ck = "y";
			
			}else {
				
				ck = "n";	
			}
			
			return ck;
		
		}
	    
	    ////////////////////////////////////////////////////////스크랩

	    
	    @RequestMapping("/sidebar/scrap")
	    @ResponseBody
	    public String sbScrap(scrapFN scrapfn) {
	       
	       String ck="n";
	       
	       
	       int result = service.insertFolderName(scrapfn);
	       
	       System.out.println("오잉"+scrapfn);
	        
	       if(result>0) {
	          ck="y";
	       }else {
	          ck="n";
	       }
	       
	       
	       return ck;
	    }
	    
	    @RequestMapping("/sidebar/updateScrap")
	    @ResponseBody
	    public String sbScrapUpdate(scrapFN fn) {
	       
	        String c="n";
	       
	       int r = service.updateFolderName(fn);
	       
	       if(r>0) {
	          c="y";
	       }else {
	          c="n";
	       }
	       
	          return c;
	    }

	    
	    @RequestMapping("/sidebar/scrapInsert")
	    @ResponseBody
	    public String sbScrapInsert(Scrap scrap,HttpSession session,Board board,scrapFN scrapfn) {
	       
	       Member_info member = (Member_info) session.getAttribute("user");
	     
	       scrap.setMember_idx(scrap.getMember_idx());
	       String ck = "q";
	       
	       if(member != null) {
	          
	          int member_idx = member.getMember_idx();
	          scrap.setMember_idx(member_idx);
	          	
	          Scrap scrapck = service.scrapck(scrap);
	          
	          if(scrapck==null) {
	         	 
	             int idx = service.getFnIdx(scrapfn);
	             
	             scrap.setScrapFN_idx(idx);
	            
	          
	             int result = service.insertScrap(scrap);
	             	
	             if(result>0) {
	                int c = service.scrapCountUp(board);
	               
	                if(c>0) {
	                   ck="y";
	                   
	                }else {
	                   ck="s";
	                }
	             }else {
	                ck="s";
	               
	             }
	          }else {//scrapck에 값이 있음
	             
	             int r = service.DeleteScrap(scrap);
	            
	             if(r>0) {
	                int a = service.scrapCountDown(board);
	               
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
	     
	       return ch;
	    }
	    
	    
}
