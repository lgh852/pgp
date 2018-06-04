package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Photo;
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
   public String mypageScrap(@RequestParam("member_id") String member_id, Model model,HttpSession session) {
      
    
      
      Member_info member = (Member_info)session.getAttribute("user");
      model.addAttribute("member", member);
      
      
        //스크랩 폴더 명 리스트 보여주기 
        List<scrapFN> scrapNameList = service2.folder(member.getMember_idx());
      
        model.addAttribute("scrapNameList", scrapNameList);
        
        //스크랩 폴더명에 맞는 사진 
        
      
        
      
      String page = "mypage/mp_scrap.jsp";
      String view = "home";
      model.addAttribute("page", page);

      return view;
      
   }
   
   @RequestMapping(value="/sidebar/scrapdetail")
   public String ScrapDetail(@RequestParam("scrap_name")String scrap_name,Model model,HttpSession session) {
      Member_info member = (Member_info)session.getAttribute("user");
      
      model.addAttribute("member", member);
      
   
      scrapFN scrap = service2.selectScrpaIdx(scrap_name);
      
      model.addAttribute("scrap", scrap);
      
      System.out.println("스크랩디테일 scrapfn_idx있냐"+scrap);
      
      //각 스크랩 폴더에 맞는 board_idx가져오기  
      List<String> s = service.selectBoardIdx(scrap);
      
      System.out.println("됐나모르겠따"+s);
      
      //폴더에 있는 photo경로 갖고 오기 위한 리스트
      List<String> photoName = service.selectPhotoName(s);
      
      
      
      String view="home";
      String page="mypage/mp_scrap_detail.jsp";
      
      model.addAttribute("page", page);
      
      return view;
   }
   
   @RequestMapping(value="/sidebar/scrapdelete",method=RequestMethod.GET)
   public String ScrapDelete(@RequestParam("scrap_name")String scrap_name,
         @RequestParam("member_idx")int member_idx,
         Model model,HttpSession session) {
      
      Member_info member = (Member_info)session.getAttribute("user");
      model.addAttribute("member", member);
      
   
      System.out.println("들어오긴 하는가$$$$$$$"+scrap_name);
      
      int resultC = service2.deleteScrapFolder(scrap_name,member_idx);
      
      System.out.println("귀찮앙"+scrap_name);
      
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