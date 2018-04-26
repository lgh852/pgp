package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Member_info;
import p.g.p.service.MemberService;

@Controller
@RequestMapping(value="/member/memberform" )
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memberForm(Model model) {
	
		String view = "home";
		String page = "member/memberform.jsp";
		model.addAttribute("page",page);
		return view;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String member(Model model,Member_info member) {
		
		System.out.println(member);
		String view = "home";
		String page ="member/member.jsp";
		int resultCnt = service.memberInsert(member);
		if(resultCnt==-1) {
			model.addAttribute("msg","회원가입 실패");
			model.addAttribute("page",page);
		}else if(resultCnt>0) {
			model.addAttribute("msg","회원가입 성공");
			model.addAttribute("page",page);
		}
	
		
		return view;
	}
	
	
}
