package p.g.p.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Photo;
import p.g.p.model.Join_Scrap_scrapFN;
import p.g.p.model.Member_info;
import p.g.p.model.Scrap;
import p.g.p.model.scrapFN;
import p.g.p.service.Mp_scrap_service;
import p.g.p.service.Sb_scrap_service;

@Controller
public class Mp_scrap_controller {
   
   @Autowired
   private Mp_scrap_service service;
   
   @Autowired
   private Sb_scrap_service service2;
   
   
   @RequestMapping(value="/mypage/mp_scrap",method=RequestMethod.GET)
   public String mypageScrap(@RequestParam("member_id") String member_id, Model model,
		   Join_Scrap_scrapFN scrap,HttpSession session) {
      
    
      
      Member_info member = (Member_info)session.getAttribute("user");
      model.addAttribute("member", member);
      
      System.out.println(member);
      	System.out.println(member);System.out.println(member);System.out.println(member);System.out.println(member);
      	System.out.println(member);System.out.println(member);
      	System.out.println(member);System.out.println(member);
      	System.out.println(member);System.out.println(member);
        //스크랩 폴더 명 리스트 보여주기 
        List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
        System.out.println(scrapNameList);
        System.out.println(scrapNameList);
        System.out.println(scrapNameList);
        System.out.println("asdas"+scrapNameList);
        model.addAttribute("scrapNameList", scrapNameList);
        
        
        //일단 scrapFN_idx 검색해오쟈
        List<Integer> scrapfnidx = service.selectscrapfnidx(member.getMember_idx());
        System.out.println("3"+scrapfnidx);
        System.out.println("3"+scrapfnidx); System.out.println("3"+scrapfnidx);
        System.out.println("3"+scrapfnidx);
        System.out.println("3"+scrapfnidx);
        System.out.println("3"+scrapfnidx);
        

        
        //반복 횟수 (스크랩 폴더 갯수 )가져오쟈
        int c = service.countFnIdx(member.getMember_idx());
      
        
        scrap.setMember_idx(member.getMember_idx());
        
        List<Integer> boardIdxList = new ArrayList<Integer>(); 
        
        
        
        for(int i=0;i<c;i++) {
        	
        scrap.setScrapFN_idx(scrapfnidx.get(i));
        
       
        
        int boardidx = service.selectScrapboardidx(scrap);
        
        
        boardIdxList.add(boardidx);
        
        }
        
       
        //board_idx를 통해서 photo_name가져오기 
        List<String> photonameList = new ArrayList<String>();
        
        for(int i=0;i<c;i++) {
        	
        	String photoname = service.selectPhotoName(boardIdxList.get(i));
        	
        	photonameList.add(photoname);
        	
        }
        
      
        model.addAttribute("photonameList", photonameList);
        
       
      String page = "mypage/mp_scrap.jsp";
      String view = "home";
      model.addAttribute("page", page);

      return view;
      
   }
   
   //스크랩 디테일이얌 스크랩 폴더에 각각 들어갔을 때
   @RequestMapping(value="/sidebar/scrapdetail")
   public String ScrapDetail(@RequestParam("scrap_name")String scrap_name,Model model,
		   HttpSession session,Scrap scrap2) {
      
	   Member_info member = (Member_info)session.getAttribute("user");
      
      model.addAttribute("member", member);
      
   
      scrapFN scrap = service2.selectScrpaIdx(scrap_name);
      
      model.addAttribute("scrap", scrap);
      
   
      
      scrap2.setMember_idx(scrap.getMember_idx());
      scrap2.setScrapFN_idx(scrap.getScrapFN_idx());
      
    
      //각각 스크랩 폴더에 들어갔을 떄 출력되는 사진 리스트
      List<Join_Scrap_scrapFN> scrapPhotoList = service.selectScrapPhotoList(scrap2);
      
      model.addAttribute("scrapPhotoList",scrapPhotoList);
      
      
      
      
      String view="home";
      String page="mypage/mp_scrap_detail.jsp";
      
      model.addAttribute("page", page);
      
      return view;
   }
   
   @RequestMapping(value="/sidebar/scrapdelete",method=RequestMethod.GET)
   public String ScrapDelete(@RequestParam("scrap_name")String scrap_name,
         @RequestParam("member_idx")int member_idx,scrapFN scrapfn,
         Model model,HttpSession session) {
      
      Member_info member = (Member_info)session.getAttribute("user");
      model.addAttribute("member", member);
      
      
      int resultC = service2.deleteScrapFolder(scrapfn);
      
     
      
      if(resultC>0) {
         System.out.println("폴더를 삭제하지 ");
      }else {
         System.out.println("멍청아!!!!!!!!");
      }
      
      model.addAttribute("member_id",member.getMember_id());
      

        List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
      
        model.addAttribute("scrapNameList", scrapNameList);
      
      String view="home";
      String page="mypage/mp_scrap.jsp";
      
      model.addAttribute("page", page);
      
      return view;
   }
    
   
   

}