package p.g.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.g.p.service.Mg_manage_service;

@Controller
public class Mg_main_controller {
	
    @Autowired
	private Mg_manage_service service;
	
	@RequestMapping(value="/manager/main")
	public String mgMainPage(Model model) {
		
		String page = "manager/main.jsp";
		String view = "home";
		model.addAttribute("page", page);
		
		return view;
	}
	
	
}
