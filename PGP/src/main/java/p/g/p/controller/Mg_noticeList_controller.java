package p.g.p.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Notice;
import p.g.p.service.Mg_noticeList_service;

@Controller
public class Mg_noticeList_controller {
	
	@Autowired
	Mg_noticeList_service service;
	
	
	@RequestMapping(value="/manager/noticelist")
	public String noticeList(Model model) {
	
		List<Notice> notices = service.getNoticeList();
		
		model.addAttribute("notices",notices);
		
		
		
		String page = "manager/noticelist.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;

	
	}
	

}
