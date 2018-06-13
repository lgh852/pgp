package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import p.g.p.model.Member_info;
import p.g.p.service.MemberChkidService;



@Controller
public class MemberChkidController {

	@Autowired
	private MemberChkidService chkidService;

	@RequestMapping(value = "/member/idchk", method = RequestMethod.GET)
	public String chkId() {

		return "member/idchk";
	}

	@RequestMapping(value= "/member/findFail", method=RequestMethod.GET)
	public String chkId1() {
		
		return "member/findFail";
	}
	
	@RequestMapping(value="/member/mypage2", method = RequestMethod.POST)
	public String idChk(Model model,Member_info member) {

		System.out.println("시작하자 : "+ member);
		
		String member_id= chkidService.idchk(member);

		System.out.println("qqs :"+ member_id);

		model.addAttribute("member_id", member_id);
		
		return "member/mypage2";
	}
	
	
}
