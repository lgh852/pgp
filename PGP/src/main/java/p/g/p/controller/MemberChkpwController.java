package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Member_info;
import p.g.p.service.MemberChkpwService;
import p.g.p.service.MemberTemppwService;
import p.g.p.service.SimpleRegistrationNotifier;
import p.g.p.service.sha256;


@Controller
public class MemberChkpwController {

	@Autowired
	private MemberChkpwService chkservice; // 임시 비번 생성
	
	@Autowired
	private MemberTemppwService tempservice; // 임시 비번 데이터 베이스 저장하기
	
	@Autowired
	private SimpleRegistrationNotifier notifier; // 메일 보내기
	
	@RequestMapping(value="/member/pwchk", method=RequestMethod.GET)
	public String chkPw() {
		
		return "member/pwchk";
		
	}

	@RequestMapping(value="/member/findpwFail", method=RequestMethod.GET)
	public String chkPw1() {
		
		return "member/findpwFail";
	}

	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/member/mypage3", method=RequestMethod.POST)
	public String pwChk(Member_info member, Model model, HttpSession session) {

		/*1. 임시 비밀번호 생성
		-> 두개의 변수를 만들어 데이터 저장/ 메일에 저장 값으로 나눈다

		2. 임시 비밀번호 암호화 처리
		
		3. 데이터베이스 저장(임시 비번)
		
		4. 메일 보내기 실행 (암호화 처리x)*/
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		System.out.println(member);
		sha256 secret = new sha256();
		Member_info member_pw = chkservice.pwChk(member); // 임시 비밀번호 생성
		String final_pw = member.getMember_pw();
		System.out.println("메일에 보낼 비밀번호 : " + final_pw);
		
		Member_info member_intro = chkservice.findemail(member); // 보내는 사람 메일 주소 확인
		member.setMember_pw(secret.encrypt(member.getMember_pw()));
		Member_info resultMember = tempservice.tempPw(member); // 업데이트
		
		
		System.out.println("[[p : "+member_pw);
		System.out.println("[[p : "+ member);
		
		
		if(member_intro != null) {
			
			member.setMember_pw(final_pw);
			notifier.sendMailAttach(member);
		}else {
			return "/member/memberFail";
		}
		
		
		
		
		System.out.println("qeq :" + member_intro); // 보내는 이 메일 주소 값
		System.out.println("zzx :" + member.getMember_pw());// 변경된 비밀번호
	
		
		System.out.println("resultMember : "+ member);
		model.addAttribute("member_pw", member_pw);
		
	
		System.out.println("ttl = "+member);
		System.out.println("ttl = "+member);
		
		model.addAttribute("aaa", resultMember);
		
		
		
		//session.getAttribute(member_pw); // 뷰에서 입력한(비밀번호 찾기) 데이터값을 가져와 up 
		
	
		
		
		return "member/mypage3"; 
	}
	
}
