package p.g.p.controller;



import javax.servlet.http.HttpSession;

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
public class LoginController {
	@Autowired
	MemberService service;
	

	@RequestMapping(value = "/member/loginform", method = RequestMethod.GET)
	public String loginform(Model model) {

		String page = "member/loginform.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/member/loginform", method = RequestMethod.POST)
	public String login(@RequestParam("member_id") String id, @RequestParam("member_pw") String pw, Model model,
			HttpSession session) {
		

		
		
		pw = service.sha256(pw); 
		String page ="";
		String view = "home";	
		
		Member_info member = service.loginService(id, pw);
		
		
		if (member != null) {
			// null아니면 성공
			page = "member/main.jsp";
			session.setAttribute("user", member);
			model.addAttribute("page", page);
		} else {
			view = "redirect:/member/loginform";
			model.addAttribute("longinCheck","failure");
	
		}

		
		return view;
	}

	@RequestMapping("/member/kakaologin")
	@ResponseBody
	public String kakaologin(Member_info member, HttpSession session) {
		// 비교 서비스
		Member_info members = service.kakaock(member);
		String ck = "y";

		if (members != null) {
			// 이미 가입된 아이디
			session.setAttribute("user", members);
			ck = "n";

		} else {
			// 회원가입 처리 디비 저장
	
			
			session.setAttribute("user", member);
			ck = "y";

		}

		return ck;

	}

	@RequestMapping("/member/naver")
	public String naverlogin(Model model) {

		String page = "member/aa";

		System.out.println("들어왔습니다");

		return page;
	}

	@RequestMapping("/member/naverLogin")
	@ResponseBody
	public String naverLogin(Member_info member, HttpSession session) {
		// 비교 서비스

		Member_info members = service.kakaock(member);

		String ck = "y";

		if (members != null) {
			// 이미 가입된 아이디
			session.setAttribute("user", members);
			ck = "n";

		} else {
			// 회원가입 처리 디비 저장

			session.setAttribute("user", member);
			ck = "y";

		}

		return ck;
	}

	@RequestMapping("/member/facebook")
	@ResponseBody
	public String facebookLogin(Member_info member, HttpSession session) {
		Member_info members = service.kakaock(member);
		String ck = "y";

		if (members != null) {
			// 이미 가입된 아이디
			session.setAttribute("user", members);
			ck = "n";

		} else {
			// 회원가입 처리 디비 저장

			session.setAttribute("user", member);
			ck = "y";

		}

		return ck;
	}
	
	
	@RequestMapping(value="/member/mypage3", method=RequestMethod.POST)
	public String pwChk(Member_info member, Model model, HttpSession session) {

		String view = "";
		String msg = "";
		
		if(member.getMember_name()!=null&&member.getMember_id()!=null&&member.getMember_phone()!=null) {
			
			member = service.pwChk(member); // 임시 비밀번호 생성
			
		if(member==null) {
			view = "/member/memberFail";
			msg = "일치하는 비밀번호가 없습니다";
			
		}else {
			
			view = "member/mypage3";
			msg = "임시 비밀번호가 발송되었습니다";
		}
		
		}else {
			
			view = "/member/memberFail";
			msg = "일치하는 비밀번호가 없습니다";
			//실패
		}
		model.addAttribute("msg",msg);
	
		
		return view; 
	}
	
	@RequestMapping(value="/member/pwchk", method=RequestMethod.GET)
	public String chkPw() {
		
		return "member/pwchk";
		
	}
	
	@RequestMapping(value = "/member/idchk", method = RequestMethod.GET)
	public String chkId() {

		return "member/idchk";
	}

	
	@RequestMapping(value="/member/mypage2", method = RequestMethod.POST)
	public String idChk(Model model,Member_info member) {

	
		String member_id= service.idchk(member);

		if(member_id!=null) {
			model.addAttribute("member_id", member_id);	
		}else {
			//실패 햇을시 
		}
		
		
		return "member/mypage2";
	}
}
