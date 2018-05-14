package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Member_info;
import p.g.p.service.MemberService;

@Controller
@RequestMapping(value = "/member/loginform")
public class LoginController {
	@Autowired
	MemberService service;

	@RequestMapping(method = RequestMethod.GET)
	public String loginform(Model model) {

		String page = "member/loginform.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("member_id")String id,
			@RequestParam("member_pw")String pw,Model model,HttpSession session) {
		
		String page = "member/login.jsp";		
		String view ="home";
	
		Member_info member= service.loginService(id,pw);
		System.out.println(member);
		if(member!=null) {
			//null아니면 성공
			session.setAttribute("user",member);
		
			model.addAttribute("page",page);
				
		   
			System.out.println("성");
			 return"redirect:/";
		}else {
			System.out.println("시류ㅐ실패");
			model.addAttribute("msg","로그인실패");
			model.addAttribute("page",page);
		}
		
		
		return view;
	}
}
