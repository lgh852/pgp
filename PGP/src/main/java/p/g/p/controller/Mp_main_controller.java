package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Member_info;
import p.g.p.service.MemberService;

@Controller
public class Mp_main_controller {

	
	@Autowired
	MemberService service;
	
	@RequestMapping("/mypage/mp_main")
	public String mypage(HttpSession session, Model model) {
		
		String view = "home";
		
		String page = "mypage/mp_newmain.jsp";
		
		model.addAttribute("page",page);
		
		Member_info member = (Member_info)session.getAttribute("user");
		System.out.println(member);
		model.addAttribute("member",member);
		
		return view;
		
	}
	
	
	
	
	
	
}
