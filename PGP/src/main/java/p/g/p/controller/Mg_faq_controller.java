package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Faq;
import p.g.p.model.Manager;
import p.g.p.service.Mg_faq_service;

@Controller
public class Mg_faq_controller {
   
   @Autowired
   Mg_faq_service service;
   

   @RequestMapping(value="/manager/faqlist")
   public String faqList(Model model,HttpSession session) {
      
      List<Faq> faq = service.getFaqList();
      
      model.addAttribute("faq",faq);
      
      
      Manager manager = (Manager)session.getAttribute("manager");
      model.addAttribute("manager", manager);
      
      String page="manager/faqlist.jsp";
      String view="home";
      model.addAttribute("page",page);
      
      return view;
   }
   
   @RequestMapping(value="/manager/faqinsert",method=RequestMethod.GET)
   public String faqInsertForm(Model model) {
      
      String page="manager/faqinsertform.jsp";
      String view = "home";
      model.addAttribute("page", page);
      return view;
   }
   
   @RequestMapping(value="/manager/faqinsert",method=RequestMethod.POST)
   public String faqInsert(Faq faq,Model model,HttpSession session) {
      
      Manager manager =(Manager) session.getAttribute("manager");
      
      faq.setManager_idx(manager.getManager_idx());

      int resultCnt = service.faqInsert(faq);
      
      if(resultCnt>0) {
         System.out.println("공지사항 입력 성공");
      }else {
         System.out.println("실패 ㅠㅠ");
      }
      
      return "redirect:/manager/faqlist";
   }
   
   @RequestMapping(value="/manager/faqview")
   public String faqView(@RequestParam("faq_idx")int faq_idx,Model model,HttpSession session) {
      
      Faq faq = service.viewFaqContents(faq_idx);
      
      Manager manager = (Manager)session.getAttribute("manager");
      
      faq.setManager_idx(manager.getManager_idx());
      
      model.addAttribute("faq", faq);
      
      String page="manager/faqview.jsp";
      String view="home";
      model.addAttribute("page", page);
      
      return view;
      
   }
   
   @RequestMapping(value="/manager/faqdelete",method=RequestMethod.GET)
   public String faqDelete(@RequestParam("faq_idx")int faq_idx) {
      
      System.out.println("faqidx확인"+faq_idx);
      
      int result = service.deleteFaqList(faq_idx);
      if(result>0) {
         System.out.println("삭제");
      }else {
         System.out.println("삭제실패 망");
      }
   
      return "redirect:/manager/faqlist";
      
   }
   
   @RequestMapping(value="/manager/faqupdate",method=RequestMethod.GET)
   public String FaqUpdateForm(@RequestParam("faq_idx") int faq_idx,Model model) {
      
      Faq faq = service.updateSelectFaq(faq_idx);
      
      model.addAttribute("faq",faq);
      
      String view="home";
      String page="manager/faqupdateform.jsp";
      
      model.addAttribute("page", page);
      
      return view;
   }
   
   @RequestMapping(value="/manager/faqupdate",method=RequestMethod.POST)
   public String FaqUpdate(Faq faq,Model model,HttpServletRequest request,HttpSession session) {
      
      Manager manager = (Manager)session.getAttribute("manager");
      
      faq.setManager_idx(manager.getManager_idx());
      
      if(faq!=null) {
         int r = service.updateFaqList(faq,request);
         
         if(r>0) {
            System.out.println("정상 업데이트");
         }else {
            System.out.println("놉놉놉");
         }
      }else {
         System.out.println("faq정보 필요함 ㅠ퓨");
      }
      return "redirect:/manager/faqlist";
   }
   
   
}