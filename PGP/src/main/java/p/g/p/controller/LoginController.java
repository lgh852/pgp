package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import p.g.p.model.Board_Photo;
import p.g.p.model.Member_info;
import p.g.p.service.MainPageService;
import p.g.p.service.MemberService;

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

	@RequestMapping(value = "/member/loginform", method = RequestMethod.POST)
	public String login(@RequestParam("member_id") String id, @RequestParam("member_pw") String pw, Model model,
			HttpSession session) {

		/* String page = "member/login.jsp"; */
		String page = "member/main.jsp";
		String view = "home";
		// homecontroller  - 여기부터 
		List<Board_Photo> list = service2.mainimg();
		if (list.size() > 0) {
			model.addAttribute("maxcntimg", list);
		}

		List<Board_Photo> latelylist = (List<Board_Photo>) session.getAttribute("latelylist");
		if (latelylist != null) {
			for (int i = 0; i < latelylist.size(); i++) {
				model.addAttribute("latelylist", latelylist);
			}
		}
		// ^^ 여기까지 homecontroller

		Member_info member = service.loginService(id, pw);
		System.out.println(member);
		if (member != null) {
			// null아니면 성공
			session.setAttribute("user", member);
			model.addAttribute("msg", "로그인 성공");
			System.out.println("성");
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
