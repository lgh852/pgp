package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class photofeedController {
	
	@RequestMapping(value = "/photo/photofeed")
	public String feed(Model model) {
		String view ="home";
		String page="photo/photofeed.jsp";
		model.addAttribute("page",page);
		return view;
	}

}
