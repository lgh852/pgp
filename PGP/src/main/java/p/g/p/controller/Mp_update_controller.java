package p.g.p.controller;

import static org.junit.Assume.assumeNoException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Member_info;
import p.g.p.service.Mp_update_service;

@Controller
@RequestMapping("/mypage/mp_update")

public class Mp_update_controller {
	
	@Autowired
	private Mp_update_service service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String mypageUpdateForm(@RequestParam("member_id") String member_id, Model model,
			Member_info member) {
		String page = "";
		String view ="";
		
		member = service.Mp_update_select(member_id);
		if(member!=null) {
			
			String sphone =member.getMember_phone().substring(0,2);
			String aphone =member.getMember_phone().substring(3,6);
			String zphone =member.getMember_phone().substring(7, 10);
			model.addAttribute("member", member);
			
			model.addAttribute("sphone", sphone);
			model.addAttribute("aphone", aphone);
			model.addAttribute("zphone", zphone);
			
			String sbirth =member.getMember_birth().substring(0,member.getMember_birth().indexOf("년",0));
			String abirth =member.getMember_birth().substring(0,member.getMember_birth().indexOf("월",4));
			


			
			
			page = "mypage/mp_update_form.jsp";
			view = "home";
				
		}else {
			
			//값이 없을때 
		}
		
		model.addAttribute("page", page);

		return view;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String mypageUpdate(@RequestParam("member_id") String member_id,Member_info member,HttpServletRequest request,Model model) throws IllegalStateException, IOException {
		
	
        System.out.println(member);
		
		if(member!=null) { //값이 있으면 
			int resultCnt = service.Mp_update(member, request);
		
		
		
		
		
		
		
		
		
		System.out.println(resultCnt);
		if(resultCnt>0) {
			System.out.println("정상적으로 실행");
			
			member = service.Mp_update_select(member_id);
			
			model.addAttribute("member",member);
		
		}else {
			System.out.println("비어있는 값이 있습니다.");
		}
		}
	    
		String page = "mypage/mp_update.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
		
		
		
	}
	
	
}
