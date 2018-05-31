package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mg_main_controller {
	
	@RequestMapping(value="/manager/main")
	public String mgMainPage(Model model) {
		
		String page = "manager/main.jsp";
		String view = "home";
		model.addAttribute("page", page);
		
		return view;
	}
	
}
