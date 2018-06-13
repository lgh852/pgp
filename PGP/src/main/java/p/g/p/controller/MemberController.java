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

	@RequestMapping(value = "/member/memberform", method = RequestMethod.GET)
	public String memberForm(Model model) {

		String view = "home";
		String page = "member/memberform.jsp";
		model.addAttribute("page", page);
		return view;
	}

	@RequestMapping(value = "/member/memberform", method = RequestMethod.POST)
	public String member(Model model, Member_info member, @RequestParam("year") String year,
			@RequestParam("month") String month, @RequestParam("day") String day, @RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2, @RequestParam("phone3") String phone3) {
		


		String pw = service.sha256(member.getMember_pw());
		
		member.setMember_pw(pw);
		
		member.setMember_phone(phone1 + phone2 + phone3);

		member.setMember_birth(year + "-" + month + "-" + day);

		System.out.println(member);
		
		String view = "home";
		
		String page = "member/member.jsp";


		int resultCnt = service.memberInsert(member);
		
		if (resultCnt == -1) {
			model.addAttribute("msg", "회원가입실패");
			model.addAttribute("page", page);
		} else if (resultCnt > 0) {
			model.addAttribute("msg", "회원가입성공");
			model.addAttribute("page", page);
		}

		return view;
	}

	@RequestMapping("/member/idck")
	@ResponseBody
	public String memberck(@RequestParam("member_id") String member_id) {
		String ck;
		Member_info member = service.memberCk(member_id);
		if (member == null) {
			// 로그인 성공
			ck = "y";
		} else {
			ck = "n";
		}

		return ck;
	}

	@RequestMapping(value="/member/change_pw",method = RequestMethod.GET)
	public String change_pwfrom() {

		
		return "member/change_pw";
	}
	@RequestMapping(value="/member/change_pw",method = RequestMethod.POST)
	public String change_pw(Model model,Member_info member,@RequestParam("member_pw1") String member_pw1,@RequestParam("member_pw2") String member_pw2) {
		String view = "member/change_pwcheck";
		String msg = "";
		String member_pw = member.getMember_pw();
		System.out.println(member);
		member = service.loginService(member.getMember_id(),member.getMember_pw());
		
		System.out.println(member);
		if(member.getMember_name() !=null) {
			member.setMember_pw(member_pw);
			if(member_pw1.equals(member_pw2)) {
				member.setMember_pw(member_pw1);
				//일치 업데이트 실행
				int result = service.change_pw(member);
				if(result>0) {
					//성공
					msg = "성공";
				}else {
					//실패
					msg = "";
				}
			
				
			}else {
				//변경할 비밀번호
				//비밀번호 불일치 
				msg = "";
			}
			//아이디 불일치
			//성공
			
		}else {
			msg = "";
			//실패 페이지
		}
		model.addAttribute("msg",msg);
		
		return view;
	}
	

}
