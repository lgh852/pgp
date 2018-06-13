package p.g.p.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Manager;
import p.g.p.model.Notice;
import p.g.p.service.Mg_noticeInsert_service;


@Controller
public class Mg_noticeInsert_controller {
	
	@Autowired
	private Mg_noticeInsert_service service;
	
	
	@RequestMapping(value="/manager/noticeinsert",method=RequestMethod.GET)
	public String noticeInsertForm(Model model) {
		
		String page = "manager/noticeinsertform.jsp";
		String view = "home";
		model.addAttribute("page", page);
		return view;
	}
	
	@RequestMapping(value="/manager/noticeinsert",method=RequestMethod.POST)
	public String noticeInsert(Notice notice,Model model,HttpSession session) {
	
		
		//requestparam으로 manager안가져와도 된다. //jsp에서 hidden으로 넘겨주지 않아도 이렇게 해주면 된다.
		Manager manager =(Manager) session.getAttribute("manager");
		
		notice.setManager_idx(manager.getManager_idx());
		
		
		int resultCnt = service.noticeInsert(notice);
		
	   // resultCnt  실행여부 확인해서 model  msg 저장할값 설정 

       if(resultCnt==-1) {
			
			model.addAttribute("msg","회원가입 실패");
			
       }else if(resultCnt>0) {
			
    	   model.addAttribute("msg","회원가입 성공");
		
		}
	

		
		
		
		return "redirect:/manager/noticelist";
		
		
	}
	
	
	
	

}
