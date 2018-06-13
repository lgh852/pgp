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
import p.g.p.service.MainPageService;
import p.g.p.service.MemberService;
import p.g.p.service.sha256;

@Controller
public class LoginController {
	@Autowired
	MemberService service;
	@Autowired
	MainPageService service2;

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
		
		sha256 secret = new sha256();
		
		System.out.println("!!!!!!! :::: --> "+pw.length());
		
		pw = secret.encrypt(pw); 
		// 새로 생성하니까 같은 비밀번호라도 값이 다르다...
		System.out.println("왜 널이야 !!? : " +pw);
		/* String page = "member/login.jsp"; */
		String page = "member/main.jsp";
		String view = "home";	
		Member_info member = service.loginService(id, pw);
		
		
		if (member != null) {
			// null아니면 성공
				
			session.setAttribute("user", member);
			model.addAttribute("msg", "로그인 성공");
			System.out.println("지금은!? : " + member);
		} else {
			System.out.println("시류ㅐ실패");
			model.addAttribute("msg", "로그인실패");
		}

		model.addAttribute("page", page);
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
}
