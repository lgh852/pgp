package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Member_info;
import p.g.p.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/member/memberform",method = RequestMethod.GET)
	public String memberForm(Model model) {
	
		String view = "home";
		String page = "member/memberform.jsp";
		model.addAttribute("page",page);
		return view;
	}
	
	
	@RequestMapping(value="/member/memberform",method = RequestMethod.POST)
	public String member(Model model,Member_info member,@RequestParam("year")String year,@RequestParam("month")String month,@RequestParam("day")String day,
			@RequestParam("phone1")String phone1,@RequestParam("phone2")String phone2,@RequestParam("phone3")String phone3) {
		
		member.setMember_phone(phone1+phone2+phone3);
		
		member.setMember_birth(year+"-"+month+"-"+day);
		
		System.out.println(member);
		String view = "home";
		String page ="member/member.jsp";
		
		int resultCnt = service.memberInsert(member);
		if(resultCnt==-1) {
			model.addAttribute("msg","회원가입실패");
			model.addAttribute("page",page);
		}else if(resultCnt>0) {
			model.addAttribute("msg","회원가입성공");
			model.addAttribute("page",page);
		}
	
		return view;
	}
	
	@RequestMapping("/member/idck")
	@ResponseBody
	public String memberck(@RequestParam("member_id")String member_id) {
		String ck;
		Member_info member = service.memberCk(member_id);
		if(member==null) {
			//로그인 성공
			ck = "y";
		}else {
			ck = "n";
		}
		
		
		
		return ck;
	}
	
}
