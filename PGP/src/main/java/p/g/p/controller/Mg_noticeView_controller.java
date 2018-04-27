package p.g.p.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.model.Manager;
import p.g.p.model.Notice;
import p.g.p.service.Mg_noticeView_service;

@Controller
public class Mg_noticeView_controller {

	@Autowired
	private Mg_noticeView_service service;

	@RequestMapping(value = "/manager/noticeview")
	public String noticeView(@RequestParam("notice_idx") int notice_idx, Model model,HttpSession session) {

		

		Notice notice = service.viewNoticeContents(notice_idx);

		Manager manager = (Manager) session.getAttribute("manager");

		notice.setManager_idx(manager.getManager_idx());
		
		
		model.addAttribute("notice", notice);

		
		String page = "manager/noticeview.jsp";
		String view = "home";
		model.addAttribute("page", page);

		return view;
		
		
		

	}
}
