package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class star_controller {

	@RequestMapping("/star/sidebar")
	public String mypage(Model model) {
		String view="home";
		String page ="star/sidebar.jsp";
		
		model.addAttribute("page",page);
		
		return view;
		
		
	}
	
}
