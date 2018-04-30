package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Board;

@Controller
public class BoardPhotoTag {
	@RequestMapping("/board/boardPhtoTagForm")
	
	public String BoardphotoTagForm(Model model) {
		
		String view = "home";
		String page = "board/boardPhotoTagForm.jsp";
		
		model.addAttribute("page",page);
		return view;
	}
	
}
