package p.g.p.controller;

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
	public String mypageUpdateForm(@RequestParam("member_id") String member_id, Model model) {
		
		Member_info member = service.Mp_update_select(member_id);
		
		model.addAttribute("member", member);
		
		String page = "mypage/mp_update_form.jsp";
		String view = "home";
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
