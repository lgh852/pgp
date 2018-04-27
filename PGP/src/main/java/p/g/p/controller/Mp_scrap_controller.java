package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Board_Photo;
import p.g.p.service.Mp_scrap_service;

@Controller
@RequestMapping("/mypage/mp_scrap")
public class Mp_scrap_controller {
	
	@Autowired
	private Mp_scrap_service service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String mypageScrap(@RequestParam("member_id") String member_id, Model model) {
		
		
		
				
		List<Board_Photo> scrap = service.Mp_ScrapList(member_id);
		
		model.addAttribute("scrap",scrap);
		
		String page = "mypage/mp_scrap.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
		
	}
	
	
	
	
	

}
