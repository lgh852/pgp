package p.g.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import p.g.p.model.Board;

@Controller
public class BoardPhotoTag {
	@RequestMapping("/board/boardPhtoTag")
	public String BoardphotoTagForm(Model model,Board board) {
		String view = "home";
		String page = "board/boardPhtoTag.jsp";
		
		model.addAttribute("page",page);
		System.out.println(board);
		System.out.println(board);
		System.out.println(board);
		System.out.println(board);
		System.out.println(board);
		
		return view;
	}
	
}
