package p.g.p.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Like;
import p.g.p.model.Member_info;
import p.g.p.model.PhotoListmodel;
import p.g.p.service.Mp_myphoto_service;
import p.g.p.service.Mp_update_service;



@Controller
@RequestMapping("/mypage/mp_myphoto")
public class Mp_myphoto_contorller {
	
	@Autowired
	private Mp_myphoto_service service;
	@Autowired
	private Mp_update_service selectservice;
		

	@RequestMapping(method=RequestMethod.GET)
	public String mypageMyphoto(Model model,
			HttpSession session,Like like,@RequestParam("member_idx")int member_idx) {
	
		
		String member_idxs = String.valueOf(member_idx);
	
	    Member_info member = selectservice.Mp_update_select(member_idxs);	
		
		model.addAttribute("member", member);
		
		
		
		
		List<PhotoListmodel> list = service.myPhotolistview(like,member_idx);
		
		model.addAttribute("listlist",list);
		
		
		
		String page = "mypage/mp_myphoto.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
		
	
	}
	
}
