package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "furniture/furnitureRank")
public class FurnitureRankController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String furnitureRankView(Model model) {
		String view = "home";
		String page = "furniture/furnitureRank.jsp";
		model.addAttribute("page", page);
		
		return view;
	}

}
